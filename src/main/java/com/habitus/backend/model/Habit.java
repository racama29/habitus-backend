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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }

    public String getFrecuencia() { return frecuencia; }
    public void setFrecuencia(String frecuencia) { this.frecuencia = frecuencia; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

}
