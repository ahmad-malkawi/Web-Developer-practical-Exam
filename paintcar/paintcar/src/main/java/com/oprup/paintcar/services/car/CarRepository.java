package com.oprup.paintcar.services.car;

import com.oprup.paintcar.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    @Query("SELECT c FROM Car c WHERE c.plateNo = :plateNo")
    Optional<Car> findByPlantNo(String plateNo);
}
