package com.habitus.backend.repository;

import com.habitus.backend.model.Habit;
import com.habitus.backend.model.HabitUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HabitUpdateRepository extends JpaRepository<HabitUpdate, Long> {

    boolean existsByHabitAndFechaActualizacionBetween(
            Habit habit,
            LocalDateTime start,
            LocalDateTime end
    );

    List<HabitUpdate> findByHabitOrderByFechaActualizacionDesc(Habit habit);

    List<HabitUpdate> findByHabitIdOrderByFechaActualizacionDesc(Long habitId);

    List<HabitUpdate> findByHabit_IdOrderByFechaActualizacionDesc(Long habitId);

}
