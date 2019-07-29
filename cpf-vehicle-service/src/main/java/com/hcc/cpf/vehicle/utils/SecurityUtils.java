package com.hcc.cpf.vehicle.utils;

import java.util.ArrayList;
import java.util.List;


import com.hcc.cpf.vehicle.dto.MyUserDetail;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {

    public static MyUserDetail getPrincipal() {
        MyUserDetail myUserDetail = (MyUserDetail) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        return myUserDetail;
    }

    public static List<String> getAuthorities() {
        List<String> results = new ArrayList<>();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) (SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
        return results;
    }
}
