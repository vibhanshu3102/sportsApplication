package com.app.gloesports.repository;

import com.app.gloesports.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// make this into a user repository
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
