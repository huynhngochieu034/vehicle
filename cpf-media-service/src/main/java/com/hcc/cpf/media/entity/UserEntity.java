package com.hcc.cpf.media.entity;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    private static final long serialVersionUID = -4907767318320601464L;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column
    private Integer status;


    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<VehicleUserEntity> vehicles = new ArrayList<>();

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public List<VehicleUserEntity> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<VehicleUserEntity> vehicles) {
        this.vehicles = vehicles;
    }
}
