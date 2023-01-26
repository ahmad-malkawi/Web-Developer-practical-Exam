package com.oprup.paintcar.services.operation;

import com.oprup.paintcar.Models.Car;
import com.oprup.paintcar.Models.Operation;
import com.oprup.paintcar.enums.OperationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("SELECT o FROM Operation o WHERE o.targetColor= :targetColor AND o.operationStatus = 2")
    List<Operation> findAllByColor(String targetColor);
    @Query("SELECT o FROM Operation o WHERE o.car= :car AND o.operationStatus = 1")
    Optional<Operation> findAllInProgresByCar(Car car);
}
