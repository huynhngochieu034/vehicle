
package com.hcc.cpf.media.dto;


import lombok.Getter;
import lombok.Setter;

/**
 * Vehicle DTO.
 * 
 * @author phuchn.fa
 *
 */
@Getter
@Setter
public class VehicleDto {
    public static final String CalculatedEngineLoadID = "CalculatedEngineLoad";
    private Double CalculatedEngineLoad;

    public static final String EngineCoolantTempID = "EngineCoolantTemp";
    private Integer EngineCoolantTemp;
    
    public static final String IntakeMAPID = "IntakeMAP";
    private Integer IntakeMAP;
    
    public static final String EngineRPMID = "EngineRPM";
    private Double EngineRPM;

    public static final String ThrottlePositionID = "ThrottlePosition";
    private Double ThrottlePosition;
    
    public static final String EngineTorqueID = "EngineTorque";
    private Double EngineTorque;
    
    public static final String RunTimeID = "RunTime";
    private Double RunTime;

    public static final String VehicleSpeedID = "VehicleSpeed";
    private Integer VehicleSpeed;
    
    public static final String FuelLevelID = "FuelLevel";
    private Double FuelLevel;

    public static final String FuelPressureID = "FuelPressure";
    private Integer FuelPressure;

    public static final String EngineOilTempID = "EngineOilTemp";
    private Integer EngineOilTemp;

    public static final String FuelTypeID = "FuelType";
    private Integer FuelType;

    public static final String EthanolFuelID = "EthanolFuel";
    private Double EthanolFuel;

    public static final String EngineFuelRateID = "EngineFuelRate";
    private Double EngineFuelRate;

    public static final String IntakeAirTempID = "IntakeAirTemp";
    private Double IntakeAirTemp;

    public static final String MAFAirFlowID = "MAFAirFlow";
    private Double MAFAirFlow;

    public static final String AmbientAirTempID = "AmbientAirTemp";
    private Integer AmbientAirTemp;

    public static final String GpsLongitudeID = "GpsLongitude";
    private Double GpsLongitude;

    public static final String GpsLatitudeID = "GpsLatitude";
    private Double GpsLatitude;

    public static final String VehicleIdID = "VehicleId";
    private String VehicleId;

    public VehicleDto(Double CalculatedEngineLoad, Integer EngineCoolantTemp, Integer IntakeMAP, 
                      Double EngineRPM, Double ThrottlePosition, Double EngineTorque, Double RunTime,
                      Integer VehicleSpeed, Double FuelLevel, Integer FuelPressure,
                      Integer EngineOilTemp, Integer FuelType, Double EthanolFuel,
                      Double EngineFuelRate, Double IntakeAirTemp, Double MAFAirFlow,
                      Integer AmbientAirTemp, Double GpsLongitude, Double GpsLatitude, String VehicleId){
        this.CalculatedEngineLoad = CalculatedEngineLoad;
        this.EngineCoolantTemp = EngineCoolantTemp;
        this.IntakeMAP = IntakeMAP;
        this.EngineRPM = EngineRPM;
        this.ThrottlePosition = ThrottlePosition;
        this.EngineTorque = EngineTorque;
        this.RunTime = RunTime;
        this.VehicleSpeed = VehicleSpeed;
        this.FuelLevel = FuelLevel;
        this.FuelPressure = FuelPressure;
        this.EngineOilTemp = EngineOilTemp;
        this.FuelType = FuelType;
        this.EthanolFuel = EthanolFuel;
        this.EngineFuelRate = EngineFuelRate;
        this.IntakeAirTemp = IntakeAirTemp;
        this.MAFAirFlow = MAFAirFlow;
        this.AmbientAirTemp = AmbientAirTemp;
        this.GpsLongitude = GpsLongitude;
        this.GpsLatitude = GpsLatitude;
        this.VehicleId = VehicleId;
    };

    public VehicleDto(){   
    }


}
