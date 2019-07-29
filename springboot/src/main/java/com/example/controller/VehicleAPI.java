package com.example.controller;

import com.example.dto.VehicleDTO;
import com.example.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping({ "/api/vehicle" })
public class VehicleAPI {
    @Autowired
    private IVehicleService vehicleService;

    @GetMapping(produces = "application/json")
    public List<VehicleDTO> firstPage() {
        return vehicleService.findAll();
    }

    @GetMapping(value={"/idss"}, produces = "application/json")
    public List<VehicleDTO> getVehicleId(@RequestParam("ids") String[] ids) {
            return vehicleService.findVehicleId(ids);
    }



}
