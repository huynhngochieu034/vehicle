package com.hcc.cpf.media.controller;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcc.cpf.media.dto.VehicleDto;
import com.hcc.cpf.media.service.impl.SimulatedDataImpl;
import com.hcc.cpf.media.model.Vehicle;

import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.QueryResult;
import org.influxdb.dto.Query;
import org.influxdb.impl.InfluxDBResultMapper;
import com.hcc.cpf.media.service.impl.VehicleDatabaseServicesImpl;

/**
 * 
 * @author phuchn.fa
 *
 */
@CrossOrigin(allowCredentials = "true")
@RestController
public class TelematicController {

	private static final Logger LOG = LoggerFactory.getLogger(TelematicController.class);
	//private static final JSONArray gpsJSON = SimulatedDataImpl.generatedGPSByUsingLagrage();
	private static int count = 0;
	private static String timeLastRec = java.time.Clock.systemUTC().instant().toString();
	//This is realtime database, you should not use this way for get max value. You should be put it in your method controller

	@RequestMapping(value = "/aloha", method = RequestMethod.GET)
	public String hello() {
	  return "Hello World from Tomcat";
	}

	/**
	 * Send a current specific vehicle information base on vehicle_id to Front-end page.
	 * 
	 * @param carId
	 * @return A specific vehicle information under JSON format
	 */
	@RequestMapping(value= "/{vehicle_id}/getlocation", method=RequestMethod.GET)
	public JSONObject getOneVehicalLocation(@PathVariable("vehicle_id") String carId) {
		VehicleDto vehicleObject = new VehicleDto();
		JSONObject vehicleJSON = new JSONObject();
		vehicleJSON = SimulatedDataImpl.parseVehicleObjectToJSON(SimulatedDataImpl.pushDataToVehicleObject(vehicleObject));
		if (carId.equals(new String("STUYV8"))) {
			return vehicleJSON;
		} else {
			return null;
		}
	}

	/**
	 * Send all current vehicle information to Front-end page.
	 * 
	 *
	 * @return All current vehicle information
	 */
	@RequestMapping(value="/all/getlocation", method=RequestMethod.GET)
	public JSONArray getAllVehicles() {
		JSONArray allVehiclesData = new JSONArray();
		// Generate 100 vehicles
		for (int numberOfVehicle = 0; numberOfVehicle < 35; numberOfVehicle++) {
			VehicleDto vehicleObject = new VehicleDto();
			JSONObject vehicleJSON = new JSONObject();
			vehicleJSON = SimulatedDataImpl.parseVehicleObjectToJSON(SimulatedDataImpl.pushDataToVehicleObjectWithRandomVehicleID(vehicleObject));
			allVehiclesData.add(vehicleJSON);
		}
		return allVehiclesData;
	}


	//JSONObject does not ordered
	//JSONArray has ordered
	/* 	@RequestMapping(value="/all/gpslocation", method=RequestMethod.GET)
		public JSONArray getOneVehicalLocationWithListKnownGPS() {		
			JSONArray gps = new JSONArray();
			if(count >= 0 && count <= 549) {
				gps.add(gpsJSON.get(count));
				LOG.info("Counter is: {}", count);
				count--;
				return gps;
			} else {
				count = 549;
				return null;
			}
		} */

	/**
	 * Send a current specific vehicle information base on vehicle_id to Front-end page.
	 * 
	 * @param carId
	 * @return A specific vehicle information under JSON format
	 */
	@RequestMapping(value= "/{vehicle_id}/getvehicle", method=RequestMethod.GET)
	public JSONArray getOneVehicleInformation(@PathVariable("vehicle_id") String carId) {		
		JSONArray vehicleData = new JSONArray();
		String databaseURL = "http://172.18.14.156:8086";
		String userName = "root";
		String password = "root";
		InfluxDB influxDB = InfluxDBFactory.connect(databaseURL, userName, password);
		String queryVehicle = "select * from vehicles where \"VehicleId\" = '" + carId.toString() + "'";
		Query query = new Query(queryVehicle, "Linux_TSDB");
		QueryResult queryResult = influxDB.query(query);
		//LOG.info("{}",queryResult);
		InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
		List<Vehicle> PointList = resultMapper.toPOJO(queryResult, Vehicle.class);	
		if(count >= 0 && count < PointList.size()) {
			vehicleData.add(PointList.get(count));
			count++;
			return vehicleData;
		} else {
			LOG.info("Counter out of size");
			count = 0;
			return null;
		}
	}

	
	/**
	 * Send all current vehicle information to Front-end page.
	 * 
	 *
	 * @return All current vehicle information
	 */
	@RequestMapping(value="/all/getvehicles", method=RequestMethod.GET)
	public JSONArray getAllVehicleInformation() {
		JSONArray allVehiclesData = new JSONArray();
		List<String> vehicleIDs = VehicleDatabaseServicesImpl.getAllVehicleID();
		LOG.info("vehicleIDs: {}", vehicleIDs);
		//int maxDBCount = VehicleDatabaseServicesImpl.getMaximumAmountSeries();
		//LOG.info("maxDBCount: {}", maxDBCount);
		for(String vehicleid : vehicleIDs) {
			int dataAmount = VehicleDatabaseServicesImpl.getAmountOfAVehicleSeries(vehicleid);
			if (dataAmount == 0)
				continue;
			QueryResult result = VehicleDatabaseServicesImpl.getSeriesOfOneVehicle(vehicleid);
			for (int i = 0; i < dataAmount; i++) {
				InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
				List<Vehicle> PointList = resultMapper.toPOJO(result, Vehicle.class);
				try {
					Vehicle v = PointList.get(i);
					//LOG.info("PointList.get(dbCount): {}", v);
					allVehiclesData.add(new ObjectMapper().writeValueAsString(v));
					timeLastRec = v.getTime();
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		}
		return allVehiclesData;
	}

	@RequestMapping(value="/last/getvehicles", method=RequestMethod.GET)
	public JSONArray getLastAllVehicleInformation() {
		JSONArray allVehiclesData = new JSONArray();
		List<String> vehicleIDs = VehicleDatabaseServicesImpl.getAllVehicleID();
		LOG.info("vehicleIDs: {}", vehicleIDs);
		//int maxDBCount = VehicleDatabaseServicesImpl.getMaximumAmountSeries();
		//LOG.info("maxDBCount: {}", maxDBCount);
		//timeLastRec="2019-06-14T04:29:46.099Z";
		for(String vehicleid : vehicleIDs) {
			int dataAmount = VehicleDatabaseServicesImpl.getLastAmountOfAVehicleSeries(vehicleid, timeLastRec);
			if (dataAmount == 0)
				continue;
			QueryResult result = VehicleDatabaseServicesImpl.getLastSeriesOfOneVehicle(vehicleid, timeLastRec);
			for (int i = 0; i < dataAmount; i++) {
				InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
				List<Vehicle> PointList = resultMapper.toPOJO(result, Vehicle.class);
				try {
					Vehicle v = PointList.get(i);
					//LOG.info("PointList.get(dbCount): {}", v);
					allVehiclesData.add(new ObjectMapper().writeValueAsString(v));
					timeLastRec = v.getTime();
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
		}
		return allVehiclesData;
	}
	@RequestMapping(value="/{vehicle_id}/getvehicle5m", method=RequestMethod.GET)
	public JSONArray getVehicleInformation5m(@PathVariable("vehicle_id") String VehId) {
		JSONArray VehicleSeries = new JSONArray();
		int dataAmount = VehicleDatabaseServicesImpl.getAmountOfAVehicleSeries5m(VehId);
		QueryResult result = VehicleDatabaseServicesImpl.get5MinutesSeriesOfOneVehicle(VehId);
		for (int i = 0; i < dataAmount; i++) {
			InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
			List<Vehicle> PointList = resultMapper.toPOJO(result, Vehicle.class);
			try {
				Vehicle v = PointList.get(i);
				//LOG.info("PointList.get(dbCount): {}", v);
				VehicleSeries.add(new ObjectMapper().writeValueAsString(v));
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		}
		return VehicleSeries;
	}

	@RequestMapping(value="/{vehicle_id}/getvehiclelast", method=RequestMethod.GET)
	public JSONArray getVehicleInformationLast(@PathVariable("vehicle_id") String VehId) {
		JSONArray VehicleSeries = new JSONArray();
		QueryResult result = VehicleDatabaseServicesImpl.getLastRecordOfOneVehicle(VehId);
		InfluxDBResultMapper resultMapper = new InfluxDBResultMapper();
		List<Vehicle> PointList = resultMapper.toPOJO(result, Vehicle.class);
		try {
			Vehicle v = PointList.get(0);
			//LOG.info("PointList.get(dbCount): {}", v);
			VehicleSeries.add(new ObjectMapper().writeValueAsString(v));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return VehicleSeries;
	}
}
