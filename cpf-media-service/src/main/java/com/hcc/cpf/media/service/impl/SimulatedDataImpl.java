package com.hcc.cpf.media.service.impl;

import java.io.FileWriter;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.context.annotation.Bean;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import com.hcc.cpf.media.dto.VehicleDto;
import com.hcc.cpf.media.service.impl.RandomVehicleDataImpl;
import com.hcc.cpf.media.service.impl.GPSInterpolationImp;
import java.util.LinkedHashMap;

/**
 * {@link TelematicService} implement SimulatedDataImpl
 * 
 * @author phuchn.fa
 *
 */
@Service
public class SimulatedDataImpl {

    /**
     * Record Log of this service when it run
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SimulatedDataImpl.class);
    private static final String vehicle_id = "DVSN90";

    public static final VehicleDto pushDataToVehicleObject(VehicleDto vehicle) {       
        vehicle.setCalculatedEngineLoad(RandomVehicleDataImpl.getRandomDoubleValue(10, 80));
        vehicle.setEngineCoolantTemp(RandomVehicleDataImpl.getRandomIntegerValue(10, 50));
        vehicle.setIntakeMAP(RandomVehicleDataImpl.getRandomIntegerValue(30, 200));
        vehicle.setEngineRPM(RandomVehicleDataImpl.getRandomDoubleValue(600, 8000));
        vehicle.setThrottlePosition(RandomVehicleDataImpl.getRandomDoubleValue(20, 60));
        vehicle.setEngineTorque(RandomVehicleDataImpl.getRandomDoubleValue(150, 250));
        vehicle.setRunTime(RandomVehicleDataImpl.getRandomDoubleValue(30, 300));
        vehicle.setVehicleSpeed(RandomVehicleDataImpl.getRandomIntegerValue(40, 100));
        vehicle.setFuelLevel(RandomVehicleDataImpl.getRandomDoubleValue(80, 255));
        vehicle.setFuelPressure(RandomVehicleDataImpl.getRandomIntegerValue(80, 90));
        vehicle.setEngineOilTemp(RandomVehicleDataImpl.getRandomIntegerValue(50, 260));
        vehicle.setFuelType(RandomVehicleDataImpl.getRandomIntegerValue(1, 6));
        vehicle.setEthanolFuel(RandomVehicleDataImpl.getRandomDoubleValue(1, 20));
        vehicle.setEngineFuelRate(RandomVehicleDataImpl.getRandomDoubleValue(1000, 2000));
        vehicle.setIntakeAirTemp(RandomVehicleDataImpl.getRandomDoubleValue(0, 100));
        vehicle.setMAFAirFlow(RandomVehicleDataImpl.getRandomDoubleValue(0, 50));
        vehicle.setAmbientAirTemp(RandomVehicleDataImpl.getRandomIntegerValue(50, 100));
        //vehicle.setLatitute(RandomVehicleDataImpl.getQuangTrungLatitute(10.8536800,10.8536900));
        //LOGGER.info("Latitue: {}",vehicle.getLatitute());
        //vehicle.setLongitude(RandomVehicleDataImpl.getQuangTrungLongitute(106.6280800, 106.6280900));
        //LOGGER.info("Longitute: {}",vehicle.getLongitude());
        vehicle.setVehicleId(vehicle_id);        
        return vehicle;
    }
    
    public static final JSONObject parseVehicleObjectToJSON(VehicleDto vehicle) {
        JSONObject vehicleJSON = new JSONObject();
        vehicleJSON.put(VehicleDto.CalculatedEngineLoadID, vehicle.getCalculatedEngineLoad());
        vehicleJSON.put(VehicleDto.EngineCoolantTempID, vehicle.getCalculatedEngineLoad());
        vehicleJSON.put(VehicleDto.IntakeMAPID, vehicle.getIntakeMAP());
        vehicleJSON.put(VehicleDto.EngineRPMID, vehicle.getEngineRPM());
        vehicleJSON.put(VehicleDto.ThrottlePositionID, vehicle.getThrottlePosition());
        vehicleJSON.put(VehicleDto.EngineTorqueID, vehicle.getEngineTorque());
        vehicleJSON.put(VehicleDto.RunTimeID, vehicle.getRunTime());
        vehicleJSON.put(VehicleDto.VehicleSpeedID, vehicle.getVehicleSpeed());
        vehicleJSON.put(VehicleDto.FuelLevelID, vehicle.getFuelLevel());
        vehicleJSON.put(VehicleDto.FuelPressureID, vehicle.getFuelPressure());
        vehicleJSON.put(VehicleDto.EngineOilTempID, vehicle.getEngineOilTemp());
        vehicleJSON.put(VehicleDto.FuelTypeID, vehicle.getFuelType());
        vehicleJSON.put(VehicleDto.EthanolFuelID, vehicle.getEthanolFuel());
        vehicleJSON.put(VehicleDto.EngineFuelRateID, vehicle.getEngineFuelRate());
        vehicleJSON.put(VehicleDto.IntakeAirTempID, vehicle.getIntakeAirTemp());
        vehicleJSON.put(VehicleDto.MAFAirFlowID, vehicle.getMAFAirFlow());
        vehicleJSON.put(VehicleDto.AmbientAirTempID, vehicle.getAmbientAirTemp());
        vehicleJSON.put(VehicleDto.GpsLatitudeID, vehicle.getGpsLatitude());
        vehicleJSON.put(VehicleDto.GpsLongitudeID, vehicle.getGpsLongitude());
        vehicleJSON.put(VehicleDto.VehicleIdID, vehicle.getVehicleId());
        return vehicleJSON;
    }

    public static final VehicleDto pushDataToVehicleObjectWithRandomVehicleID(VehicleDto vehicle) {       
        vehicle.setCalculatedEngineLoad(RandomVehicleDataImpl.getRandomDoubleValue(10, 80));
        vehicle.setEngineCoolantTemp(RandomVehicleDataImpl.getRandomIntegerValue(10, 50));
        vehicle.setIntakeMAP(RandomVehicleDataImpl.getRandomIntegerValue(30, 200));
        vehicle.setEngineRPM(RandomVehicleDataImpl.getRandomDoubleValue(600, 8000));
        vehicle.setThrottlePosition(RandomVehicleDataImpl.getRandomDoubleValue(20, 60));
        vehicle.setEngineTorque(RandomVehicleDataImpl.getRandomDoubleValue(150, 250));
        vehicle.setRunTime(RandomVehicleDataImpl.getRandomDoubleValue(30, 300));
        vehicle.setVehicleSpeed(RandomVehicleDataImpl.getRandomIntegerValue(40, 300));
        vehicle.setFuelLevel(RandomVehicleDataImpl.getRandomDoubleValue(80, 255));
        vehicle.setFuelPressure(RandomVehicleDataImpl.getRandomIntegerValue(80, 90));
        vehicle.setEngineOilTemp(RandomVehicleDataImpl.getRandomIntegerValue(50, 260));
        vehicle.setFuelType(RandomVehicleDataImpl.getRandomIntegerValue(1, 6));
        vehicle.setEthanolFuel(RandomVehicleDataImpl.getRandomDoubleValue(1, 20));
        vehicle.setEngineFuelRate(RandomVehicleDataImpl.getRandomDoubleValue(1000, 2000));
        vehicle.setIntakeAirTemp(RandomVehicleDataImpl.getRandomDoubleValue(0, 100));
        vehicle.setMAFAirFlow(RandomVehicleDataImpl.getRandomDoubleValue(0, 50));
        vehicle.setAmbientAirTemp(RandomVehicleDataImpl.getRandomIntegerValue(50, 100));
        vehicle.setGpsLatitude(RandomVehicleDataImpl.getQuangTrungGpsLatitude(10.8500000,10.8599999));
        LOGGER.info("Latitue: {}",vehicle.getGpsLatitude());
        vehicle.setGpsLongitude(RandomVehicleDataImpl.getQuangTrungGpsLongitude(106.6000000, 106.6999999));
        vehicle.setVehicleId(RandomVehicleDataImpl.getVehicleId());        
        return vehicle;
    }

    
/* 	public static final JSONArray generatedGPSByUsingLagrage() {
		JSONArray gpsPoints = new JSONArray();
		LinkedHashMap<Double, Double> inputCoordinate = new LinkedHashMap<Double, Double>();
		LinkedHashMap<Double, Double> outputCoordinate = new LinkedHashMap<Double, Double>();

        inputCoordinate.put(10.813415, 106.673570);
        inputCoordinate.put(10.815519, 106.671341);
        inputCoordinate.put(10.816458, 106.670377);

		outputCoordinate = GPSInterpolationImp.generateGPSFrom2LatitudePoints(inputCoordinate, 550);
		Double[] latitude = outputCoordinate.keySet().toArray(new Double[outputCoordinate.size()]);
		Double[] longitude = outputCoordinate.values().toArray(new Double[outputCoordinate.size()]);
		for(int i = 0; i < 550 ; i++) {
			VehicleDto vehicleObject = new VehicleDto();
			JSONObject vehicleJSON = new JSONObject();
            vehicleObject.setLatitute(latitude[i]);
            LOGGER.info("Latitute: {}", latitude[i]);
            vehicleObject.setLongitude(longitude[i]);
            LOGGER.info("Longitude: {}", longitude[i]);
            vehicleJSON = SimulatedDataImpl.parseVehicleObjectToJSON(SimulatedDataImpl.pushDataToVehicleObject(vehicleObject));
			gpsPoints.add(vehicleJSON);
        }
        // String street = "DangVanSam";
        // try (FileWriter file = new FileWriter(vehicle_id + "_" + street + ".json")) {            
        //     gpsPoints.writeJSONString(file);
        //     file.close();
        //     LOGGER.info("Write successfully!");
        // } catch (IOException e) {
        //      e.printStackTrace();
        // }
		return gpsPoints;
	} */
}