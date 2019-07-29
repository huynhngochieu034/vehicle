    package com.hcc.cpf.vehicle.entity;

    import javax.persistence.*;

    @Entity
    @Table(name = "vehicle")
    public class VehicleEntity extends BaseEntity {


        private static final long serialVersionUID = 239723907255626806L;

        @Column(nullable = false, unique = true)
        private String vehicleId;

        @Column
        private String model;

        @Column
        private String manufacturer;


        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id", nullable = false)
        private UserEntity users;


        public UserEntity getUsers() {
            return users;
        }

        public void setUsers(UserEntity users) {
            this.users = users;
        }

        public String getVehicleId() {
            return vehicleId;
        }

        public void setVehicleId(String vehicleId) {
            this.vehicleId = vehicleId;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }
    }

