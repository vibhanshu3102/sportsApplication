package com.app.gloesports.service.impl;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.Equipment;
import com.app.gloesports.entity.User;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.EquipmentRepository;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.UserService;
import com.app.gloesports.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// make this into a service layer for User entity
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public UserDto addUser(UserDto userDto) {
       User user = Mapper.mapToUserEntity(userDto);
       User savedUser=userRepository.save(user);

       List<EquipmentDto> equipmentDtoList = userDto.getEquipment();
       for (int i = 0; i < equipmentDtoList.size(); i++) {
            Equipment equipment = new Equipment(equipmentDtoList.get(i).getId(),equipmentDtoList.get(i).getType(),equipmentDtoList.get(i).getBrand(), equipmentDtoList.get(i).getModel(), user);
            equipmentRepository.save(equipment);
            equipmentDtoList.get(i).setId(equipment.getId());
        }
       userDto.setEquipment(equipmentDtoList);
       userDto.setId(savedUser.getId());
       return userDto;
    }

    @Override
    public UserDto getUserById(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        UserDto userDto = new UserDto();
        if(optionalUser.isEmpty()){
            throw new ResourceNotFoundException("user" , "id" , userId);
        }
        User user = optionalUser.get();
        userDto.setId(userId);
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        List<Equipment> equipmentList = equipmentRepository.findEquipmentByUserId(userId);
        List<EquipmentDto> equipmentDtoList = new ArrayList<>();
        for (int i = 0 ; i < equipmentList.size(); i++){
           EquipmentDto equipmentDto = Mapper.mapToEquipmentDto(equipmentList.get(i));
           equipmentDtoList.add(equipmentDto);
        }
        userDto.setEquipment(equipmentDtoList);
        return userDto;
    }
}
