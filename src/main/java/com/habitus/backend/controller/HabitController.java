package com.habitus.backend.controller;

import com.habitus.backend.model.Habit;
import com.habitus.backend.model.HabitUser;
import com.habitus.backend.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
@CrossOrigin(origins = "*") // Configura bien esto más adelante
public class HabitController {

    @Autowired
    private HabitService habitService;

    @PostMapping("/{userId}")
    public Habit createHabit(@PathVariable String userId, @RequestBody Habit habit) {
        return habitService.createHabit(userId, habit);
    }

    @GetMapping("/user/{userId}")
    public List<HabitUser> getHabitsByUser(@PathVariable String userId) {
        return habitService.getHabitsByUser(userId);
    }

    @GetMapping("/{id}")
    public Habit getHabit(@PathVariable Long id) {
        return habitService.getHabitById(id).orElse(null);
    }

    @GetMapping
    public List<Habit> getAllHabits() {
        return habitService.getAllHabits();
    }
}
