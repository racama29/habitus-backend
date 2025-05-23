package com.habitus.backend.controller;

import com.habitus.backend.model.Habit;
import com.habitus.backend.model.HabitUpdate;
import com.habitus.backend.model.User;
import com.habitus.backend.repository.HabitUpdateRepository;
import com.habitus.backend.service.HabitService;
import com.habitus.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habits")
public class HabitController {

    private final HabitService habitService;
    private final UserService userService;
    private final HabitUpdateRepository habitUpdateRepository;

    public HabitController(HabitService habitService, UserService userService, HabitUpdateRepository habitUpdateRepository) {
        this.habitService = habitService;
        this.userService = userService;
        this.habitUpdateRepository = habitUpdateRepository;
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Habit>> getHabitsByUserId(@PathVariable Long userId) {
        List<Habit> habits = habitService.getHabitsByUserId(userId);
        return ResponseEntity.ok(habits);
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Habit> createHabit(@PathVariable Long userId, @RequestBody Habit habit) {
        User user = userService.getUserById(userId);
        habit.setUser(user);
        Habit savedHabit = habitService.saveHabit(habit);
        return ResponseEntity.ok(savedHabit);
    }

    @DeleteMapping("/{habitId}")
    public ResponseEntity<Void> deleteHabit(@PathVariable Long habitId) {
        habitService.deleteHabit(habitId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{habitId}")
    public ResponseEntity<Habit> updateHabit(@PathVariable Long habitId, @RequestBody Habit habit) {
        Habit updated = habitService.updateHabit(habitId, habit);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{habitId}/history")
    public ResponseEntity<List<HabitUpdate>> getHabitHistory(@PathVariable Long habitId) {
        List<HabitUpdate> history = habitUpdateRepository.findByHabit_IdOrderByFechaActualizacionDesc(habitId);
        return ResponseEntity.ok(history);
    }
}
