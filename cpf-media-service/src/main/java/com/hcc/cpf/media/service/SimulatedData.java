package com.hcc.cpf.media.service;

import com.hcc.cpf.media.dto.VehicleDto;
import org.json.simple.JSONObject;

/**
 * Simulated Data for Front end
 * 
 * @author phuchn.fa
 *
 */
public interface SimulatedData {
    
    /**
	 * Push random vehicle data into Vehicle object {@link Vehicle}
	 *  
	 * @param vehicle
	 * @return vehicle that not empty fields
	 */
    public VehicleDto pushDataToVehicleObject(VehicleDto vehicle);

    /**
	 * Parse vehicle object to JSON
	 * 
	 * @param vehicle
	 * @return vehicle's JSONPObject
	 */
	public JSONObject parseVehicleObjectToJSON(VehicleDto vehicle);
}