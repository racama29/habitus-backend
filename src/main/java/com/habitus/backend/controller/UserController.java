package com.habitus.backend.controller;

import com.habitus.backend.DTO.HabitMetricsDTO;
import com.habitus.backend.model.User;
import com.habitus.backend.service.HabitService;
import com.habitus.backend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final HabitService habitService;

    public UserController(UserService userService, HabitService habitService) {
        this.userService = userService;
        this.habitService = habitService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/by-email")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) {
        User user = userService.getUserByEmail(email);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/{userId}/metrics")
    public ResponseEntity<HabitMetricsDTO> getUserMetrics(@PathVariable Long userId) {
        HabitMetricsDTO metrics = habitService.calculateMetricsForUser(userId);
        return ResponseEntity.ok(metrics);
    }



}
