package com.hcc.cpf.media.converter;


import com.hcc.cpf.media.dto.VehicleUserDTO;
import com.hcc.cpf.media.entity.VehicleUserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleConverter {

    @Autowired
    private ModelMapper modelMapper;

    public VehicleUserDTO convertToDto(VehicleUserEntity entity) {
        VehicleUserDTO result = modelMapper.map(entity, VehicleUserDTO.class);
        return result;
    }

    public VehicleUserEntity convertToEntity(VehicleUserDTO dto) {
        VehicleUserEntity result = modelMapper.map(dto, VehicleUserEntity.class);
        return result;
    }
}
