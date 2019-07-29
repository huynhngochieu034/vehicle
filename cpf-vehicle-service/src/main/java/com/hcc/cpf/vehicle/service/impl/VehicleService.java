package com.hcc.cpf.vehicle.service.impl;

import com.hcc.cpf.vehicle.converter.VehicleConverter;
import com.hcc.cpf.vehicle.dto.VehicleDTO;
import com.hcc.cpf.vehicle.entity.UserEntity;
import com.hcc.cpf.vehicle.entity.VehicleEntity;
import com.hcc.cpf.vehicle.repository.UserRepository;
import com.hcc.cpf.vehicle.repository.VehicleRepository;
import com.hcc.cpf.vehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleConverter vehicleConverter;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<VehicleDTO> findByUserId(Long id) {
        List<VehicleEntity> list = vehicleRepository.findByUsersId(id);
        return list.stream().map(item -> vehicleConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public VehicleDTO save(VehicleDTO vehicleDTO, Long id) {
        VehicleEntity vehicleEntity;
        if(id != null){
            VehicleEntity existVehicle = vehicleRepository.getOne(id);
            vehicleEntity = vehicleConverter.convertToEntity(vehicleDTO);
            vehicleEntity.setId(existVehicle.getId());
            vehicleEntity.setCreatedDate(existVehicle.getCreatedDate());
            vehicleEntity.setCreatedBy(existVehicle.getCreatedBy());
            vehicleEntity.setUsers(existVehicle.getUsers());

        }else{
        UserEntity userEntity = userRepository.getOne(1L);
        vehicleEntity = vehicleConverter.convertToEntity(vehicleDTO);
        vehicleEntity.setUsers(userEntity);

        }
        vehicleRepository.save(vehicleEntity);
        return vehicleConverter.convertToDto(vehicleEntity);
    }

    @Override
    public VehicleDTO findByVehicleID(Long id) {
        VehicleEntity vehicleEntity = vehicleRepository.getOne(id);
        return vehicleConverter.convertToDto(vehicleEntity);
    }

    @Override
    public void deleteVehicle(Long[] ids) {
        for(long id: ids){
            vehicleRepository.deleteById(id);
        }
    }
}
