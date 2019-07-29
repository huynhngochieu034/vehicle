package com.hcc.cpf.vehicle.service;

import com.hcc.cpf.vehicle.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
   // List<UserDTO> findAll();
    //UserDTO save(UserDTO vehicleDTO);
    //UserDTO findByUserID(Long id);
    //void deleteUser(Long[] ids);
    UserDTO getCurentUser();
}
