package com.habitus.backend.repository;

import com.habitus.backend.model.Habit;
import com.habitus.backend.model.HabitUser;
import com.habitus.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitUserRepository extends JpaRepository<HabitUser, Long> {

    List<HabitUser> findByUser(User user);

    List<HabitUser> findByHabit(Habit habit);
}
