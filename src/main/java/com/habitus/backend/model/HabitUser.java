package com.habitus.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "habit_users")
public class HabitUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Habit habit;

    private String rol; // 'owner' o 'invited'

    // Getters and setters
    public HabitUser() {}
}
