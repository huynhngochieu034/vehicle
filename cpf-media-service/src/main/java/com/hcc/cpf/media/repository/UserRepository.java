package com.hcc.cpf.media.repository;

import com.hcc.cpf.media.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Long> {


}
