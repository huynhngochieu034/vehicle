package com.hcc.cpf.vehicle.converter;


import com.hcc.cpf.vehicle.dto.VehicleDTO;
import com.hcc.cpf.vehicle.entity.VehicleEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleConverter {

    @Autowired
    private ModelMapper modelMapper;

    public VehicleDTO convertToDto(VehicleEntity entity) {
        VehicleDTO result = modelMapper.map(entity, VehicleDTO.class);
        return result;
    }

    public VehicleEntity convertToEntity(VehicleDTO dto) {
        VehicleEntity result = modelMapper.map(dto, VehicleEntity.class);
        return result;
    }
}
