package com.hcc.cpf.media.service.impl;

import com.hcc.cpf.media.converter.VehicleConverter;
import com.hcc.cpf.media.dto.VehicleUserDTO;
import com.hcc.cpf.media.entity.UserEntity;
import com.hcc.cpf.media.entity.VehicleUserEntity;
import com.hcc.cpf.media.repository.UserRepository;
import com.hcc.cpf.media.repository.VehicleRepository;
import com.hcc.cpf.media.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private VehicleConverter vehicleConverter;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<VehicleUserDTO> findByUserId(Long id) {
        List<VehicleUserEntity> list = vehicleRepository.findByUsersId(id);
        return list.stream().map(item -> vehicleConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public VehicleUserDTO save(VehicleUserDTO vehicleDTO, Long id) {
        VehicleUserEntity vehicleUserEntity;
        if(id != null){
            VehicleUserEntity existVehicle = vehicleRepository.findById(id);
            vehicleUserEntity = vehicleConverter.convertToEntity(vehicleDTO);
            vehicleUserEntity.setId(existVehicle.getId());
            vehicleUserEntity.setCreatedDate(existVehicle.getCreatedDate());
            vehicleUserEntity.setCreatedBy(existVehicle.getCreatedBy());
            vehicleUserEntity.setUsers(existVehicle.getUsers());

        }else{
        UserEntity userEntity = userRepository.getOne(1L);
        vehicleUserEntity = vehicleConverter.convertToEntity(vehicleDTO);
        vehicleUserEntity.setUsers(userEntity);

        }
        vehicleRepository.save(vehicleUserEntity);
        return vehicleConverter.convertToDto(vehicleUserEntity);
    }

    @Override
    public VehicleUserDTO findByVehicleID(Long id) {
        VehicleUserEntity vehicleUserEntity = vehicleRepository.findById(id);
        VehicleUserDTO vehicleUserDTO = vehicleConverter.convertToDto(vehicleUserEntity);
        return vehicleUserDTO;
    }

    @Override
    public void deleteVehicle(Long[] ids) {
        for(long id: ids){
            vehicleRepository.delete(id);
        }
    }
}
