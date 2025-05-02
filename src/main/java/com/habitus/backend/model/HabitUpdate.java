package com.habitus.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "habit_updates")
public class HabitUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Habit habit;

    @ManyToOne
    private User user;

    private LocalDate fecha;

    private boolean completado;

    // Getters and setters
    public HabitUpdate() {}
}
