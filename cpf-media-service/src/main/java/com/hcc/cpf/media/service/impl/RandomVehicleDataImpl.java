package com.hcc.cpf.media.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Random;
import java.lang.StringBuilder;

/**
 * Random data methods
 * 
 * @author phuchn.fa
 *
 */
public class RandomVehicleDataImpl {

    private static final String ALPHABET_NUMBERIC = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Logger LOG = LoggerFactory.getLogger(RandomVehicleDataImpl.class);

    /**
     * Generate random integer value in specificed range
     * 
     * @param min - in range [minimum, maximum]
     * @param max - in range [minimum, maximum]
     * @return integer value in range
     */
    public static Integer getRandomIntegerValue(int min, int max){
        Random random = new Random();
        return random.ints(min, max).findFirst().getAsInt();
    }

    /**
     * Generate random float value in specificed range
     * 
     * @param min - in range [minimum, maximum]
     * @param max - in range [minimum, maximum]
     * @return float value in range
     */
    public static Float getRandomFloatValue(float min, float max){
        Random random = new Random();
        return random.nextFloat()*(max - min) + min;
    }

    /**
     * Generate random double value in specificed range
     * 
     * @param min - in range [minimum, maximum]
     * @param max - in range [minimum, maximum]
     * @return double value in range
     */
    public static Double getRandomDoubleValue(double min, double max){
        Random random = new Random();
        return random.doubles(min, max).findFirst().getAsDouble();
    }

    /**
     * Generate random double latitute value in specificed range near 
     * Quang Trung Software Park
     * 
     * @param latitute - latitute value
     * @return double value in range of Quang Trung Park Latitute
     */
    public static Double getQuangTrungGpsLatitude(double min, double max){
        Random random = new Random();
        return random.doubles(min, max).findFirst().getAsDouble();
        //return Math.random()*latitute;
    }

    /**
     * Generate random double longitute value in specificed range near 
     * Quang Trung Software Park
     * 
     * @param longitute - longitute value
     * @return double value in range of Quang Trung Park longitute
     */
    public static Double getQuangTrungGpsLongitude(double min, double max){
        Random random = new Random();
        return random.doubles(min, max).findFirst().getAsDouble();
        //return Math.random()*longitute;
    }

    /**
     * Generate random vehicle id 
     * Length of vehicle_id is 6 characters
     * Characters in range [ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789]
     * 
     * 
     * @return vehicle_id
     */
    public static String getVehicleId(){
        int count = 6;
        StringBuilder vehicle_id = new StringBuilder();
        while(count-- != 0) {
            Random random = new Random();            
            vehicle_id.append(ALPHABET_NUMBERIC.charAt(random.ints(0, ALPHABET_NUMBERIC.length()).findFirst().getAsInt()));
        }
        LOG.info("Random vehicle_id: {}",vehicle_id);
        return vehicle_id.toString();
    }


}