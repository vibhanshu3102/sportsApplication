package com.app.gloesports.service.impl;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.entity.Equipment;
import com.app.gloesports.entity.User;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.EquipmentRepository;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.EquipmentService;
import com.app.gloesports.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// make this into a service layer for Equipment entity
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public EquipmentDto addEquipmentToUser(EquipmentDto equipmentDto, Long userId) {

      Equipment equipment = Mapper.mapToEquipmentEntity(equipmentDto);
      Optional<User> optionalUser = userRepository.findById(userId);
      if(optionalUser.isEmpty()){
          throw new ResourceNotFoundException("user" , "id" , userId);
      }
      User user = optionalUser.get();
      equipment.setUser(user);
      equipmentRepository.save(equipment);
      return Mapper.mapToEquipmentDto(equipment);
    }

    @Override
    public EquipmentDto getEquipmentById(Long userId, Long equipmentId) {
        Optional<Equipment> optionalEquipment = equipmentRepository.findById(equipmentId);
        if(optionalEquipment.isEmpty()){
            throw new ResourceNotFoundException("user" , "id" , userId);
        }
        return Mapper.mapToEquipmentDto(optionalEquipment.get());
    }

    @Override
    public String deleteEquipmentById(Long equipmentId) {
        if(equipmentRepository.existsById(equipmentId)){
            equipmentRepository.deleteById(equipmentId);
          return "Equipment deleted Successfully";
        }
        else {
            throw new ResourceNotFoundException("equipment" , "equipmentId" , equipmentId);
        }
    }
}
