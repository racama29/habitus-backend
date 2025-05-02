package com.habitus.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String objetivo;
    private String frecuencia;
    private String color;

    @OneToMany(mappedBy = "habit")
    private List<HabitUser> usuarios;

    @OneToMany(mappedBy = "habit")
    private List<HabitUpdate> updates;

    // Getters and setters
    public Habit() {}
}
