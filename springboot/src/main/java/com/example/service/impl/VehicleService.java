package com.example.service.impl;

import com.example.converter.VehicleConverter;
import com.example.dto.VehicleDTO;
import com.example.entity.VehicleEntity;
import com.example.repository.VehicleRepository;
import com.example.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleConverter vehicleConverter;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Override
    public List<VehicleDTO> findAll() {
        List<VehicleEntity> list = vehicleRepository.findAll();
        return list.stream().map(item -> vehicleConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public List<VehicleDTO> findVehicleId(String[] vehicleId) {
        List<VehicleEntity> list= new ArrayList<>();
        VehicleEntity vehicleEntity;
        for(String item: vehicleId){
            vehicleEntity = vehicleRepository.findByVehicleId(item);
            list.add(vehicleEntity);
        }
        return list.stream().map(item -> vehicleConverter.convertToDto(item)).collect(Collectors.toList());
    }



}
