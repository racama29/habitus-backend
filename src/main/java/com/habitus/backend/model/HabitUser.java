package com.habitus.backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "habit_user")
public class HabitUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habit_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "habit_id", nullable = false)
    private Habit habit;

    public HabitUser() {}


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
