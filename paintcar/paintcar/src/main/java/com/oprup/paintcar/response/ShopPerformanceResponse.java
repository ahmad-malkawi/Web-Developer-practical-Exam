package com.oprup.paintcar.response;

public class ShopPerformanceResponse {
    private int totalCarsPainted;
    private int totalBlueCarsPainted;
    private int totalRedCarsPainted;
    private int totalGreenCarsPainted;

    public ShopPerformanceResponse() {
    }

    public ShopPerformanceResponse(int totalCarsPainted, int totalBlueCarsPainted, int totalRedCarsPainted, int totalGreenCarsPainted) {
        this.totalCarsPainted = totalCarsPainted;
        this.totalBlueCarsPainted = totalBlueCarsPainted;
        this.totalRedCarsPainted = totalRedCarsPainted;
        this.totalGreenCarsPainted = totalGreenCarsPainted;
    }

    public int getTotalCarsPainted() {
        return totalCarsPainted;
    }

    public void setTotalCarsPainted(int totalCarsPainted) {
        this.totalCarsPainted = totalCarsPainted;
    }

    public int getTotalBlueCarsPainted() {
        return totalBlueCarsPainted;
    }

    public void setTotalBlueCarsPainted(int totalBlueCarsPainted) {
        this.totalBlueCarsPainted = totalBlueCarsPainted;
    }

    public int getTotalRedCarsPainted() {
        return totalRedCarsPainted;
    }

    public void setTotalRedCarsPainted(int totalRedCarsPainted) {
        this.totalRedCarsPainted = totalRedCarsPainted;
    }

    public int getTotalGreenCarsPainted() {
        return totalGreenCarsPainted;
    }

    public void setTotalGreenCarsPainted(int totalGreenCarsPainted) {
        this.totalGreenCarsPainted = totalGreenCarsPainted;
    }
}
