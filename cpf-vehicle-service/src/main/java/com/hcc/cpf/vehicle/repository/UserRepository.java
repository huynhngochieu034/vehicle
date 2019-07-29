package com.hcc.cpf.vehicle.repository;

import com.hcc.cpf.vehicle.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserName(String name);

}
