package com.habitus.backend.repository;

import com.habitus.backend.model.Frecuency;
import com.habitus.backend.model.Habit;
import com.habitus.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitRepository extends JpaRepository<Habit, Long> {

    List<Habit> findByUser(User user);

    List<Habit> findByFrecuencia(Frecuency frecuencia);
}
