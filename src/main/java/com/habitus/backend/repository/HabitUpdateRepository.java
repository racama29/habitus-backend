package com.habitus.backend.repository;

import com.habitus.backend.model.HabitUpdate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HabitUpdateRepository extends JpaRepository<HabitUpdate, Long> {
    List<HabitUpdate> findByHabitId(Long habitId);
    List<HabitUpdate> findByUserId(String userId);
}
