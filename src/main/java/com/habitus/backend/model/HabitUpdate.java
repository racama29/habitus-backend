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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Habit getHabit() { return habit; }
    public void setHabit(Habit habit) { this.habit = habit; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public boolean getCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }

}
