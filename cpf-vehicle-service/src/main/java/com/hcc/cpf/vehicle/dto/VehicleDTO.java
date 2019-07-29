package com.hcc.cpf.vehicle.dto;



public class VehicleDTO extends  AbstractDTO<VehicleDTO>{


    private static final long serialVersionUID = -5297716899867087548L;

    private String vehicleId;
    private String model;
    private String manufacturer;


    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }



}
