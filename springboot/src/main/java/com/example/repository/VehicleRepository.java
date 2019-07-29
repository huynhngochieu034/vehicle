package com.example.repository;

import com.example.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    VehicleEntity findByVehicleId(String VehicleId);

}
