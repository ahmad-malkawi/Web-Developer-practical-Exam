package com.oprup.paintcar.Models;

import com.oprup.paintcar.enums.OperationStatus;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "operations")
public class Operation {
    @Id
    @SequenceGenerator(name = "operation_sequence",sequenceName = "operation_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "operation_sequence")
    private Long id;
    @Column(nullable = false)
    private String currentColor;
    @Column(nullable = false)
    private String targetColor;
    @Column(nullable = false)
    private LocalDateTime criationDate;
    @Column(nullable = false)
    private OperationStatus operationStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    public Operation( String currentColor, String targetColor,Car car) {
        this.currentColor = currentColor;
        this.targetColor = targetColor;
        this.criationDate = LocalDateTime.now();
        this.operationStatus = OperationStatus.IN_QUEUE;
        this.car = car;
    }

    public Operation() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrentColor() {
        return currentColor;
    }

    public void setCurrentColor(String currentColor) {
        this.currentColor = currentColor;
    }

    public String getTargetColor() {
        return targetColor;
    }

    public void setTargetColor(String targetColor) {
        this.targetColor = targetColor;
    }

    public LocalDateTime getCriationDate() {
        return criationDate;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }

    public Car getCar() {
        return car;
    }
}
