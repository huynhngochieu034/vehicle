package com.hcc.cpf.vehicle.repository;


import com.hcc.cpf.vehicle.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {

    List<VehicleEntity> findByUsersId(Long id);
}
