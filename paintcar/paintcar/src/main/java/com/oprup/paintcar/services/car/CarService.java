package com.oprup.paintcar.services.car;

import com.oprup.paintcar.Models.Car;
import com.oprup.paintcar.Models.Operation;
import com.oprup.paintcar.enums.OperationStatus;
import com.oprup.paintcar.request.APIRequest;
import com.oprup.paintcar.response.PantJobResponse;
import com.oprup.paintcar.response.ShopPerformanceResponse;
import com.oprup.paintcar.services.operation.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final OperationRepository operationRepository;

    @Autowired
    public CarService(CarRepository carRepository, OperationRepository operationRepository) {
        this.carRepository = carRepository;
        this.operationRepository = operationRepository;
    }



    public void addNewCar(APIRequest request) throws Exception {
        Optional<Car> carByPlantNo = carRepository.findByPlantNo(request.getPlateNO());
        Car car;
        if(carByPlantNo.isPresent()){
            car = carByPlantNo.get();
            Set<Operation> operations = car.getOperations();
            for(Operation operation: operations){
                if(operation.getOperationStatus().equals(OperationStatus.IN_QUEUE) || operation.getOperationStatus().equals(OperationStatus.IN_PROGRESS)){
                    throw new Exception("The Car has Operation In Order");
                }
            }
        }else{
            car = new Car(request.getPlateNO());
            car.setOperations(new HashSet<Operation>());
        }

        Operation operation = new Operation(request.getCurentColor(),request.getTargetColor(),car);
        car.getOperations().add(operation);
        carRepository.save(car);

    }

    public List<PantJobResponse> getAllData() {
        List<Car> cars = carRepository.findAll();
        List<Operation> inQueueOperations = new LinkedList<>();
        List<Operation> inProgresOperations = new LinkedList<>();
        for(Car car:cars){
            Set<Operation> operations = car.getOperations();
            for(Operation operation: operations){
                if(operation.getOperationStatus().equals(OperationStatus.IN_QUEUE)){
                    inQueueOperations.add(operation);
                } else if (operation.getOperationStatus().equals(OperationStatus.IN_PROGRESS)){
                    inProgresOperations.add(operation);
                }
            }
        }

        Collections.sort(inQueueOperations, new Comparator<Operation>() {
            @Override
            public int compare(Operation o1, Operation o2) {
                return o1.getCriationDate().compareTo(o2.getCriationDate());
            }
        });


        while(inProgresOperations.size() < 5 && !inQueueOperations.isEmpty()){
            Operation operation = inQueueOperations.get(0);
            inProgresOperations.add(operation);
            operation.setOperationStatus(OperationStatus.IN_PROGRESS);
            inQueueOperations.remove(0);

        }
        operationRepository.saveAll(inProgresOperations);

        List<PantJobResponse> resOperations = new LinkedList<>();

        for(Operation operation:inProgresOperations){
            resOperations.add(new PantJobResponse(operation.getCar().getPlateNo(),operation.getCurrentColor(),operation.getTargetColor(),operation.getOperationStatus()));
        }
        for(Operation operation:inQueueOperations){
            resOperations.add(new PantJobResponse(operation.getCar().getPlateNo(),operation.getCurrentColor(),operation.getTargetColor(),operation.getOperationStatus()));
        }
        return resOperations;
    }

    public ShopPerformanceResponse getShopPerformance() {
        int redCars = operationRepository.findAllByColor("red").size();
        int blueCars = operationRepository.findAllByColor("blue").size();
        int greenCars = operationRepository.findAllByColor("green").size();
        return new ShopPerformanceResponse(redCars+blueCars+greenCars ,blueCars,redCars,greenCars);
    }

    public void setOperationDone(String plateNo) {
        Optional<Car> carByPlantNo = carRepository.findByPlantNo(plateNo);
        if(carByPlantNo.isPresent()){
            Optional<Operation> inProgressByCar = operationRepository.findAllInProgresByCar(carByPlantNo.get());
            if(inProgressByCar.isPresent()){
                Operation operation = inProgressByCar.get();
                operation.setOperationStatus(OperationStatus.DONE);
                operationRepository.save(operation);
            }
        }
    }
}
