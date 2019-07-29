package com.hcc.cpf.media.repository;


import com.hcc.cpf.media.entity.VehicleUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface VehicleRepository extends JpaRepository<VehicleUserEntity, Long> {
    VehicleUserEntity findById(Long id);
    List<VehicleUserEntity> findByUsersId(Long id);
}
