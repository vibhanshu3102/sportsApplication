package com.app.gloesports.controller;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// It is a controller class that handles the equipment related requests
@RestController
@Validated
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;

    // Add equipment to a user
    @PostMapping("/users/{userId}/equipment")
    public EquipmentDto setEquipments(@Valid @RequestBody EquipmentDto equipmentDto, @PathVariable Long userId){
        return equipmentService.addEquipmentToUser(equipmentDto , userId);
    }

    // Get equipment by equipmentId
    @GetMapping("/users/{id}/equipment/{equipmentId}")
    public EquipmentDto getEquipment(@PathVariable Long id , @PathVariable Long equipmentId){
        return equipmentService.getEquipmentById(id , equipmentId);
    }

    // Delete equipment from a User by equipmentId
    @DeleteMapping("/equipment/{equipmentId}")
    public String deleteEquipment(@PathVariable Long equipmentId){
            return equipmentService.deleteEquipmentById(equipmentId);
    }

}
