package com.habitus.backend.DTO;

public class HabitMetricsDTO {

    private Long userId;
    private int totalHabits;
    private int completed;
    private int failed;
    private double completionRate; // % completados

    public HabitMetricsDTO() {}

    public HabitMetricsDTO(Long userId, int totalHabits, int completed, int failed, double completionRate) {
        this.userId = userId;
        this.totalHabits = totalHabits;
        this.completed = completed;
        this.failed = failed;
        this.completionRate = completionRate;
    }

    // Getters y Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getTotalHabits() {
        return totalHabits;
    }

    public void setTotalHabits(int totalHabits) {
        this.totalHabits = totalHabits;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getFailed() {
        return failed;
    }

    public void setFailed(int failed) {
        this.failed = failed;
    }

    public double getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(double completionRate) {
        this.completionRate = completionRate;
    }
}
