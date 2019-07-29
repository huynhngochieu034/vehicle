package com.hcc.cpf.vehicle.controller;



import com.hcc.cpf.vehicle.dto.VehicleDTO;
import com.hcc.cpf.vehicle.service.IVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(allowCredentials = "true")
@RestController
@RequestMapping({ "/api/car" })
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping(value={"/{id}"}, produces = "application/json")
    public List<VehicleDTO> getVehicleId(@PathVariable("id") Long id) {
        return vehicleService.findByUserId(id);
    }

    @GetMapping(value={"/update/{id}"}, produces = "application/json")
    public VehicleDTO getVehicleById(@PathVariable("id") Long id) {
        return vehicleService.findByVehicleID(id);
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> createVehicle(@RequestBody VehicleDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO,vehicleDTO.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleDTO> updateNew(@RequestBody VehicleDTO vehicleDTO, @PathVariable("id") Long id) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO, id));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteVehicle(@RequestParam("ids") Long[] ids) {
        if (ids.length > 0) {
            vehicleService.deleteVehicle(ids);
        }
        return ResponseEntity.noContent().build();
    }
}
