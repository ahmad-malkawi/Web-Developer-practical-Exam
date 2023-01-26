package com.oprup.paintcar.response;

import com.oprup.paintcar.enums.OperationStatus;

public class PantJobResponse {
    String plateNO;
    String curentColor;
    String targetColor;
    OperationStatus operationStatus;



    public PantJobResponse() {

    }

    public PantJobResponse(String plateNO, String curentColor, String targetColor,OperationStatus operationStatus) {
        this.plateNO = plateNO;
        this.curentColor = curentColor;
        this.targetColor = targetColor;
        this.operationStatus = operationStatus;
    }

    public String getPlateNO() {
        return plateNO;
    }

    public void setPlateNO(String plateNO) {
        this.plateNO = plateNO;
    }

    public String getCurentColor() {
        return curentColor;
    }

    public void setCurentColor(String curentColor) {
        this.curentColor = curentColor;
    }

    public String getTargetColor() {
        return targetColor;
    }

    public void setTargetColor(String targetColor) {
        this.targetColor = targetColor;
    }

    public OperationStatus getOperationStatus() {
        return operationStatus;
    }

    public void setOperationStatus(OperationStatus operationStatus) {
        this.operationStatus = operationStatus;
    }
}
