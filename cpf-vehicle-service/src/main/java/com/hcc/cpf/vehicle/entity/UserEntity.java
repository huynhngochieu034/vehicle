package com.hcc.cpf.vehicle.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -4907767318320601464L;

    @Column(unique = true)
    private String userName;

    @Column
    private String password;

    @Column
    private String fullName;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private Integer status;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = {
            @JoinColumn(name = "user_id", nullable = false)}, inverseJoinColumns = {
            @JoinColumn(name = "role_id", nullable = false)})
    private List<RoleEntity> roles = new ArrayList<>();

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<VehicleEntity> vehicles = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public List<VehicleEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleEntity> vehicles) {
        this.vehicles = vehicles;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
