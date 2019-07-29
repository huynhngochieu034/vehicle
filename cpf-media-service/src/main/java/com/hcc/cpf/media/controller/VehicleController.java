package com.hcc.cpf.media.controller;



import com.hcc.cpf.media.dto.VehicleUserDTO;
import com.hcc.cpf.media.service.IVehicleService;
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
    public List<VehicleUserDTO> getVehicleId(@PathVariable("id") Long id) {
        return vehicleService.findByUserId(id);
    }

    @GetMapping(value={"/update/{id}"}, produces = "application/json")
    public VehicleUserDTO getVehicleById(@PathVariable("id") Long id) {
        return vehicleService.findByVehicleID(id);
    }

    @PostMapping
    public ResponseEntity<VehicleUserDTO> createVehicle(@RequestBody VehicleUserDTO vehicleDTO) {
        return ResponseEntity.ok(vehicleService.save(vehicleDTO,vehicleDTO.getId()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleUserDTO> updateVehicle(@RequestBody VehicleUserDTO vehicleDTO, @PathVariable("id") Long id) {
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
