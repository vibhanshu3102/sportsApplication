package com.app.gloesports.repository;

import com.app.gloesports.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// make this into a equipment repository
@Repository
public interface EquipmentRepository  extends JpaRepository<Equipment,Long> {

    public List<Equipment> findEquipmentByUserId(Long userId);

}
