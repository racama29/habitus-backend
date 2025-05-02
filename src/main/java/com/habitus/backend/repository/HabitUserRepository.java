package com.habitus.backend.repository;

import com.habitus.backend.model.HabitUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitUserRepository extends JpaRepository<HabitUser, Long> {
    List<HabitUser> findByUserId(String userId);
    List<HabitUser> findByHabitId(Long habitId);
}
