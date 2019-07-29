package com.hcc.cpf.media.service.impl;

import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;
import java.util.NoSuchElementException;
import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.QueryResult;
import org.influxdb.dto.Query;

/**
 * {@link TelematicService} implement VehicleDatabaseServicesImpl
 * 
 * @author phuchn.fa
 *
 */
@Service
public class VehicleDatabaseServicesImpl {
    private static String databaseURL = "http://35.240.143.66:8086";
    private static String userName = "root";
    private static String password = "root";
    private static final Logger LOG = LoggerFactory.getLogger(VehicleDatabaseServicesImpl.class);

    //1. Get VehicleId from database
    public static final List<String> getAllVehicleID() {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
		List<String> results = new ArrayList<String>();
        //String queryVehicle = "select distinct(VehicleId) from car";
        String queryVehicle = "SHOW TAG VALUES WITH KEY = VehicleId";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        int size = queryResult.getResults().get(0).getSeries().get(0).getValues().size();
        for (int i = 0; i < size; i++) {
            results.add(queryResult.getResults().get(0).getSeries().get(0).getValues().get(i).get(1).toString());
        }
        return results;
    }

     //1. Get VehicleId from database
     public static final List<String> findVehicleByVehicleID(String vehicleID) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
		List<String> results = new ArrayList<String>();
        //String queryVehicle = "select distinct(VehicleId) from car";
        String queryVehicle = "SHOW TAG VALUES WITH KEY = VehicleId where \"VehicleId\" = '" + vehicleID + "'";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        int size = queryResult.getResults().get(0).getSeries().get(0).getValues().size();
        for (int i = 0; i < size; i++) {
            results.add(queryResult.getResults().get(0).getSeries().get(0).getValues().get(i).get(1).toString());
        }
        return results;
    }

    //2. Get amount series of 1 vehicle
    public static final Integer getAmountOfAVehicleSeries(String vehicleID) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
        String queryVehicle = "select count(GpsLongitude) from vehicles where \"VehicleId\" = '" + vehicleID + "'";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        LOG.info("Amount: {}", queryResult);
        if (queryResult.getResults().get(0).getSeries() == null)
            return 0;
        String[] amount = queryResult.getResults().get(0).getSeries().get(0).getValues().get(0).get(1).toString().split("\\.");
        return Integer.parseInt(amount[0]);
    }

    //2.a Get last amount series of 1 vehicle
    public static final Integer getLastAmountOfAVehicleSeries(String vehicleID, String lastTime) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
        String queryVehicle = "select count(GpsLongitude) from vehicles where \"VehicleId\" = '" + vehicleID + "' and time >= '" + lastTime + "'";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        LOG.info("Amount: {}", queryResult);
        if (queryResult.getResults().get(0).getSeries() == null)
            return 0;
        String[] amount = queryResult.getResults().get(0).getSeries().get(0).getValues().get(0).get(1).toString().split("\\.");
        return Integer.parseInt(amount[0]);
    }

    //2'. Get series of each vehicle
    public static final QueryResult getSeriesOfOneVehicle(String vehicleID) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
		String queryVehicle = "select * from vehicles where \"VehicleId\" = '" + vehicleID + "'";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        //LOG.info("query series each vehicle: {}", queryResult);    
        return queryResult;
    }

    //2'.a Get last series of each vehicle
    public static final QueryResult getLastSeriesOfOneVehicle(String vehicleID, String lastTime) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
        String queryVehicle = "select * from vehicles where \"VehicleId\" = '" + vehicleID + "' and time >= '" + lastTime + "'";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        //LOG.info("query series each vehicle: {}", queryResult);    
        return queryResult;
    }

    //3. Get largest series of vehicle list
    public static final Integer getMaximumAmountSeries() {
        List<Integer> vehicles = new ArrayList<Integer>();
        List<String> deviceids = VehicleDatabaseServicesImpl.getAllVehicleID();
		for (String str : deviceids) {
			vehicles.add(VehicleDatabaseServicesImpl.getAmountOfAVehicleSeries(str));
		}
        Integer max = vehicles.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException::new);
        return max;
    }

    //4. Get 5 minutes of series of each vehicle
    public static final QueryResult get5MinutesSeriesOfOneVehicle(String vehicleID) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
        String queryVehicle = "select * from vehicles where \"VehicleId\" = '" + vehicleID + "' AND time > now() - 60m";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        //LOG.info("query series each vehicle: {}", queryResult);    
        return queryResult;
    }

    //5. Get last record of each vehicle
    public static final QueryResult getLastRecordOfOneVehicle(String vehicleID) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
        String queryVehicle = "select * from vehicles where \"VehicleId\" = '" + vehicleID + "' AND time > now() - 60m GROUP BY * ORDER BY DESC LIMIT 1";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        //LOG.info("query series each vehicle: {}", queryResult);    
        return queryResult;
    }

    //5. Get amount series of 1 vehicle in 5 minutes
    public static final Integer getAmountOfAVehicleSeries5m(String vehicleID) {
        InfluxDB influxDB = InfluxDBFactory.connect(databaseURL);
        String queryVehicle = "select count(GpsLongitude) from vehicles where \"VehicleId\" = '" + vehicleID + "' AND time > now() - 60m";
        Query query = new Query(queryVehicle, "Linux_TSDB");
        QueryResult queryResult = influxDB.query(query);
        LOG.info("Amount: {}", queryResult);
        String amount = queryResult.getResults().get(0).getSeries().get(0).getValues().get(0).get(1).toString();
        return (int)Float.parseFloat(amount);
    }
}