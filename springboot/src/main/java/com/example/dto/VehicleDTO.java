package com.example.dto;

public class VehicleDTO extends AbstractDTO<VehicleDTO>{
    private String time;
    private Double calculatedEngineLoad;
    private Integer engineCoolantTemp;
    private Integer intakeMAP;
    private Double engineRPM;
    private Double throttlePosition;
    private Double engineTorque;
    private Double runTime;
    private Integer vehicleSpeed;
    private Double fuelLevel;
    private Integer fuelPressure;
    private Integer engineOilTemp;
    private Integer fuelType;
    private Double ethanolFuel;
    private Double engineFuelRate;
    private Double intakeAirTemp;
    private Integer mAFAirFlow;
    private Double ambientAirTemp;
    private Double gpsLongitude;
    private Double gpsLatitude;
    private String vehicleId;


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Double getCalculatedEngineLoad() {
        return calculatedEngineLoad;
    }

    public void setCalculatedEngineLoad(Double calculatedEngineLoad) {
        this.calculatedEngineLoad = calculatedEngineLoad;
    }

    public Integer getEngineCoolantTemp() {
        return engineCoolantTemp;
    }

    public void setEngineCoolantTemp(Integer engineCoolantTemp) {
        this.engineCoolantTemp = engineCoolantTemp;
    }

    public Integer getIntakeMAP() {
        return intakeMAP;
    }

    public void setIntakeMAP(Integer intakeMAP) {
        this.intakeMAP = intakeMAP;
    }

    public Double getEngineRPM() {
        return engineRPM;
    }

    public void setEngineRPM(Double engineRPM) {
        this.engineRPM = engineRPM;
    }

    public Double getThrottlePosition() {
        return throttlePosition;
    }

    public void setThrottlePosition(Double throttlePosition) {
        this.throttlePosition = throttlePosition;
    }

    public Double getEngineTorque() {
        return engineTorque;
    }

    public void setEngineTorque(Double engineTorque) {
        this.engineTorque = engineTorque;
    }

    public Double getRunTime() {
        return runTime;
    }

    public void setRunTime(Double runTime) {
        this.runTime = runTime;
    }

    public Integer getVehicleSpeed() {
        return vehicleSpeed;
    }

    public void setVehicleSpeed(Integer vehicleSpeed) {
        this.vehicleSpeed = vehicleSpeed;
    }

    public Double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(Double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public Integer getFuelPressure() {
        return fuelPressure;
    }

    public void setFuelPressure(Integer fuelPressure) {
        this.fuelPressure = fuelPressure;
    }

    public Integer getEngineOilTemp() {
        return engineOilTemp;
    }

    public void setEngineOilTemp(Integer engineOilTemp) {
        this.engineOilTemp = engineOilTemp;
    }

    public Integer getFuelType() {
        return fuelType;
    }

    public void setFuelType(Integer fuelType) {
        this.fuelType = fuelType;
    }

    public Double getEthanolFuel() {
        return ethanolFuel;
    }

    public void setEthanolFuel(Double ethanolFuel) {
        this.ethanolFuel = ethanolFuel;
    }

    public Double getEngineFuelRate() {
        return engineFuelRate;
    }

    public void setEngineFuelRate(Double engineFuelRate) {
        this.engineFuelRate = engineFuelRate;
    }

    public Double getIntakeAirTemp() {
        return intakeAirTemp;
    }

    public void setIntakeAirTemp(Double intakeAirTemp) {
        this.intakeAirTemp = intakeAirTemp;
    }

    public Integer getmAFAirFlow() {
        return mAFAirFlow;
    }

    public void setmAFAirFlow(Integer mAFAirFlow) {
        this.mAFAirFlow = mAFAirFlow;
    }

    public Double getAmbientAirTemp() {
        return ambientAirTemp;
    }

    public void setAmbientAirTemp(Double ambientAirTemp) {
        this.ambientAirTemp = ambientAirTemp;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }
}
