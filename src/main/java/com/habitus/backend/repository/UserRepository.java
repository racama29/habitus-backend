package com.habitus.backend.repository;

import com.habitus.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // Puedes añadir métodos personalizados si los necesitas
}