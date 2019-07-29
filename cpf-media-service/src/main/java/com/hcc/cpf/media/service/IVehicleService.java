package com.hcc.cpf.media.service;



import com.hcc.cpf.media.dto.VehicleUserDTO;

import java.util.List;

public interface IVehicleService {
    List<VehicleUserDTO> findByUserId(Long id);
    VehicleUserDTO save(VehicleUserDTO vehicleDTO, Long id);
    VehicleUserDTO findByVehicleID(Long id);
    void deleteVehicle(Long[] ids);
}
