package com.hcc.cpf.vehicle.controller;

import com.hcc.cpf.vehicle.dto.UserDTO;
import com.hcc.cpf.vehicle.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserService userService;

    //@Secured({"ADMIN"})
    @PostMapping(value = "/login", produces = "application/json")
    public UserDTO demo(){
        System.out.println("lam on vo");
        return userService.getCurentUser();
    }

    @GetMapping(value = "/login", produces = "application/json")
    public UserDTO demo4(){
        System.out.println("lam on vo");
        return userService.getCurentUser();
    }

    //@Secured({"ADMIN","USER"})
    @GetMapping(value = "/login2",
            produces = MimeTypeUtils.TEXT_PLAIN_VALUE)
    public String demo2(){
        return "success";
    }


}
