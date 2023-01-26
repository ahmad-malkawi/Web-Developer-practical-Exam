package com.oprup.paintcar.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "cars")
public class Car {
    @Id
    @SequenceGenerator(name = "car_sequence",sequenceName = "car_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "car_sequence")
    private Long id;
    @Column(unique = true)
    private String plateNo;
    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Operation> operations;

    public Car(String plateNo) {
        this.plateNo = plateNo;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public Set<Operation> getOperations() {
        return operations;
    }

    public void setOperations(Set<Operation> operations) {
        this.operations = operations;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }
}
