package com.hcc.cpf.vehicle.service;



import com.hcc.cpf.vehicle.dto.VehicleDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleDTO> findByUserId(Long id);
    VehicleDTO save(VehicleDTO vehicleDTO, Long id);
    VehicleDTO findByVehicleID(Long id);
    void deleteVehicle(Long[] ids);
}
