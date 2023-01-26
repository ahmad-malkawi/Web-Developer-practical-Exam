package com.oprup.paintcar.request;


public class APIRequest {
    String plateNO;
    String curentColor;
    String targetColor;

    public APIRequest() {

    }

    public APIRequest(String plateNO, String curentColor, String targetColor) {
        this.plateNO = plateNO;
        this.curentColor = curentColor;
        this.targetColor = targetColor;
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
}
