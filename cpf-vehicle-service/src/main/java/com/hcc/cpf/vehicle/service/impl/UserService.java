package com.hcc.cpf.vehicle.service.impl;

import com.hcc.cpf.vehicle.converter.UserConverter;
import com.hcc.cpf.vehicle.dto.MyUserDetail;
import com.hcc.cpf.vehicle.dto.UserDTO;
import com.hcc.cpf.vehicle.entity.RoleEntity;
import com.hcc.cpf.vehicle.entity.UserEntity;
import com.hcc.cpf.vehicle.repository.UserRepository;
import com.hcc.cpf.vehicle.service.IUserService;
import com.hcc.cpf.vehicle.utils.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService implements  IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

//    @Override
//    public UserDTO save(UserDTO userDTO) {
//        UserEntity userEntity = userConverter.convertToEntity(userDTO);
//        userRepository.save(userEntity);
//        return userConverter.convertToDto(userEntity);
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUserName(username);
        //UserDTO userDTO = userConverter.convertToDto(userEntity);
        if (userEntity == null) {
            throw new UsernameNotFoundException("username not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        }
        MyUserDetail myUserDetail = new MyUserDetail(username, userEntity.getPassword(), true, true, true, true, authorities);
        BeanUtils.copyProperties(userEntity, myUserDetail);
        return myUserDetail;
        //return new User(username,userEntity.getPassword(),authorities);
    }

    @Override
    public UserDTO getCurentUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(SecurityUtils.getPrincipal().getUsername());
        userDTO.setRoles(SecurityUtils.getAuthorities());
        return userDTO;
    }
}
