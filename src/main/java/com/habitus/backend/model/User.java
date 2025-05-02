package com.habitus.backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    private String id; // UID de Firebase

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "user")
    private List<HabitUser> habitLinks;

    @OneToMany(mappedBy = "user")
    private List<HabitUpdate> updates;

    // Getters and setters
    public User() {}
}
