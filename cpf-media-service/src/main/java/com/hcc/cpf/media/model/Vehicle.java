package com.hcc.cpf.media.model;

import java.time.Instant;

import org.influxdb.annotation.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Measurement(name = "vehicles")
public class Vehicle {
    @Column(name = "time")
    private String time;
    
    @Column(name = "CalculatedEngineLoad")
    private Double CalculatedEngineLoad;

    @Column(name = "EngineCoolantTemp")
    private Integer EngineCoolantTemp;
    
    @Column(name = "IntakeMAP")
    private Integer IntakeMAP;
    
    @Column(name = "EngineRPM")
    private Double EngineRPM;

    @Column(name = "ThrottlePosition")
    private Double ThrottlePosition;
    
    @Column(name = "EngineTorque")
    private Double EngineTorque;
    
    @Column(name = "RunTime")
    private Double RunTime;

    @Column(name = "VehicleSpeed")
    private Integer VehicleSpeed;
    
    @Column(name = "FuelLevel")
    private Double FuelLevel;

    @Column(name = "FuelPressure")
    private Integer FuelPressure;

    @Column(name = "EngineOilTemp")
    private Integer EngineOilTemp;

    @Column(name = "FuelType")
    private Integer FuelType;

    @Column(name = "EthanolFuel")
    private Double EthanolFuel;

    @Column(name = "EngineFuelRate")
    private Double EngineFuelRate;

    @Column(name = "IntakeAirTemp")
    private Double IntakeAirTemp;

    @Column(name = "MAFAirFlow")
    private Integer MAFAirFlow;

    @Column(name = "AmbientAirTemp")
    private Double AmbientAirTemp;

    @Column(name = "GpsLongitude")
    private Double GpsLongitude;

    @Column(name = "GpsLatitude")
    private Double GpsLatitude;

    @Column(name = "VehicleId")
    private String VehicleId;

    public String getTime() {
        return time;
    }
}