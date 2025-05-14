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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Habit getHabit() { return habit; }
    public void setHabit(Habit habit) { this.habit = habit; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

}
