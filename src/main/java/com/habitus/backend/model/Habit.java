package com.habitus.backend.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "habits")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_id")
    private Long id;

    private String titulo;

    private String objetivo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Frecuency frecuencia;

    private String color;

    @Column(nullable = false)
    private String estado = "pending"; // Valores: pending, in_progress, completed

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonIgnore
    private User user;

    @Column(name = "fecha_fin")
    private LocalDate fechaFin; // Puede ser null si es indefinido

    @OneToMany(mappedBy = "habit")
    @JsonIgnore
    private List<HabitUser> usuarios;

    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<HabitUpdate> updates;

    public Habit() {}

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public Frecuency getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(Frecuency frecuencia) {
        this.frecuencia = frecuencia;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public List<HabitUser> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<HabitUser> usuarios) {
        this.usuarios = usuarios;
    }

    public List<HabitUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(List<HabitUpdate> updates) {
        this.updates = updates;
    }
}
