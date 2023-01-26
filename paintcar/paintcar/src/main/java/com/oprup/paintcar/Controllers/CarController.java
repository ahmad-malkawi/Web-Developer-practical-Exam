package com.oprup.paintcar.Controllers;

import com.oprup.paintcar.request.APIRequest;
import com.oprup.paintcar.response.PantJobResponse;
import com.oprup.paintcar.response.ShopPerformanceResponse;
import com.oprup.paintcar.services.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/vi/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/submit")
    public void createNewPaintRequest(@RequestBody APIRequest request) throws Exception {

        carService.addNewCar(request);
    }
    @PostMapping("/getAll")
    public List<PantJobResponse> getAll(){

       return carService.getAllData();
    }

    @PostMapping("/getShopPerformance")
    public ShopPerformanceResponse getShopPerformance(){

        return carService.getShopPerformance();
    }

    @PutMapping("/MarkAsDone/{plateNo}")
    public void updateOnprogressOperation(@PathVariable String plateNo){

        carService.setOperationDone(plateNo);
    }
}
