package com.habitus.backend.DTO;

public class HabitMetricsDTO {

    private Long userId;
    private int totalHabits;
    private int completed;
    private int inProgress;
    private int failed;
    private double completionRate;

    public HabitMetricsDTO() {}

    public HabitMetricsDTO(Long userId, int totalHabits, int completed, int inProgress, int failed, double completionRate) {
        this.userId = userId;
        this.totalHabits = totalHabits;
        this.completed = completed;
        this.inProgress = inProgress;
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

    public int getInProgress() {
        return inProgress;
    }

    public void setInProgress(int inProgress) {
        this.inProgress = inProgress;
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
