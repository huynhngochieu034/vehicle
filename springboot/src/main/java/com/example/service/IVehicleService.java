package com.example.service;

import com.example.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> findAll();
    List<VehicleDTO> findVehicleId(String[] ids);


}
