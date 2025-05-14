package com.habitus.backend.service;

import com.habitus.backend.model.Habit;
import com.habitus.backend.model.HabitUser;
import com.habitus.backend.model.User;
import com.habitus.backend.repository.HabitRepository;
import com.habitus.backend.repository.HabitUserRepository;
import com.habitus.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HabitUserRepository habitUserRepository;

    public Habit createHabit(String userId, Habit habit) {
        Habit savedHabit = habitRepository.save(habit);

        Optional<User> userOpt = userRepository.findById(userId);
        if (userOpt.isPresent()) {
            HabitUser link = new HabitUser();
            link.setUser(userOpt.get());
            link.setHabit(savedHabit);
            link.setRol("owner");
            habitUserRepository.save(link);
        }

        return savedHabit;
    }

    public List<HabitUser> getHabitsByUser(String userId) {
        return habitUserRepository.findByUserId(userId);
    }

    public Optional<Habit> getHabitById(Long id) {
        return habitRepository.findById(id);
    }

    public List<Habit> getAllHabits() {
        return habitRepository.findAll();
    }
}
