package com.example.jogodedadossophia.repo;

import com.example.jogodedadossophia.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
