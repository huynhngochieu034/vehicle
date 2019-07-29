package com.hcc.cpf.media.service.impl;

import java.util.LinkedHashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Interpolate other GPS coordinates from given/known GPS coordinates 
 */
public class GPSInterpolationImp {

    private static final Logger LOG = LoggerFactory.getLogger(RandomVehicleDataImpl.class);
    /**
     * Generate longitude of a GPS coordinate from given/known GPS coordinates 
     * 
     * @param GPSCoordinate - These coordinates were collected from online map
     * @param lat - Use this latitude for generate a longitude
     * @return GPS Longitude from given GPS Coordinates
     */
    public static Double generateGPSLongitudeFromGivenGPSCoordinates(LinkedHashMap<Double, Double> GPSCoordinate, double lat) {
        Double result = 0.0;
        //System.out.print(GPSCoordinate.size()+ "\n");
        Double[] latitude = GPSCoordinate.keySet().toArray(new Double[GPSCoordinate.size()]);
      	//System.out.print(latitude[1]+ "\n");
        Double[] longitude = GPSCoordinate.values().toArray(new Double[GPSCoordinate.size()]);
      	//System.out.print(longitude[1]+ "\n");
        
        for (int i = 0; i < GPSCoordinate.size(); i++) {
            Double polynomial = longitude[i];
            for (int j = 0; j < GPSCoordinate.size(); j++) {
                if (j != i) {
                    polynomial = polynomial*((lat - latitude[j])/(double)(latitude[i] - latitude[j]));
                }
            }
            result = result + polynomial;
        }
        return result;
    }

    /**
     * Generate latitude of a GPS coordinate from given/known GPS coordinates 
     * 
     * @param GPSCoordinate - These coordinates were collected from online map
     * @param lat - Use this latitude for generate a longitude
     * @return GPS Longitude from given GPS Coordinates
     */
    public static Double generateGPSLatitudeFromGivenGPSCoordinates(LinkedHashMap<Double, Double> GPSCoordinate, double lo) {
        Double result = 0.0;
        //System.out.print(GPSCoordinate.size()+ "\n");
        Double[] latitude = GPSCoordinate.keySet().toArray(new Double[GPSCoordinate.size()]);
      	//System.out.print(latitude[1]+ "\n");
        Double[] longitude = GPSCoordinate.values().toArray(new Double[GPSCoordinate.size()]);
      	//System.out.print(longitude[1]+ "\n");
        
        for (int i = 0; i < GPSCoordinate.size(); i++) {
            Double polynomial = latitude[i];
            for (int j = 0; j < GPSCoordinate.size(); j++) {
                if (j != i) {
                    polynomial = polynomial*((lo - longitude[j])/(double)(longitude[i] - longitude[j]));
                }
            }
            result = result + polynomial;
        }
        return result;
    }
    
    /**
     * Generate pair (x,y) in two latitude points
     * 
     * @param GPSCoordinate - These coordinates were collected from online map
     * @param amount - Number of points you want to generate
     * @return GPS coordinate from given GPS Coordinates
     */
    public static LinkedHashMap<Double, Double> generateGPSFrom2LatitudePoints(LinkedHashMap<Double, Double> GPSCoordinate, int amount) {
        LinkedHashMap<Double, Double> generatedCoordinates = new LinkedHashMap<Double, Double>();
        Double[] latitude = GPSCoordinate.keySet().toArray(new Double[GPSCoordinate.size()]);
        Double variance = (latitude[GPSCoordinate.size()-1] - latitude[0])/(double)amount;
        //Double variance = (latitude[0] - latitude[GPSCoordinate.size()-1])/(double)amount;
        LOG.info("Last Latitude: {}", latitude[GPSCoordinate.size()-1]);
        LOG.info("First Longitude: {}", latitude[0]);
        LOG.info("Variance: {}", variance);
        Double dividedLatitude = latitude[0];
        for (int i = 0; i < amount; i++) {           
            dividedLatitude = dividedLatitude + variance;
            generatedCoordinates.put(dividedLatitude, generateGPSLongitudeFromGivenGPSCoordinates(GPSCoordinate, dividedLatitude));          
        }            
        return generatedCoordinates;
    }

    //Generate Latitude
    public static LinkedHashMap<Double, Double> generateGPSFrom2LongitudePoints(LinkedHashMap<Double, Double> GPSCoordinate, int amount) {
        LinkedHashMap<Double, Double> generatedCoordinates = new LinkedHashMap<Double, Double>();
        Double[] longitude = GPSCoordinate.values().toArray(new Double[GPSCoordinate.size()]);
        Double variance = (longitude[GPSCoordinate.size()-1] - longitude[0])/(double)amount;
        //Double variance = (latitude[0] - latitude[GPSCoordinate.size()-1])/(double)amount;
        LOG.info("Last Longitude: {}", longitude[GPSCoordinate.size()-1]);
        LOG.info("First Longitude: {}", longitude[0]);
        LOG.info("Variance: {}", variance);
        Double dividedLongitude = longitude[0];
        for (int i = 0; i < amount; i++) {           
            dividedLongitude = dividedLongitude + variance;
            generatedCoordinates.put(generateGPSLatitudeFromGivenGPSCoordinates(GPSCoordinate, dividedLongitude), dividedLongitude);          
        }            
        return generatedCoordinates;
    }
}