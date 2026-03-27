package com.mountain_journey.mj_moteur.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mountain_journey.mj_moteur.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserEmail(String userEmail);

    boolean existsByUserEmail(String userEmail);
}
