package com.habitus.backend.service;

import com.habitus.backend.DTO.HabitMetricsDTO;
import com.habitus.backend.model.Habit;
import com.habitus.backend.model.User;
import com.habitus.backend.repository.HabitRepository;
import com.habitus.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;

    public HabitService(HabitRepository habitRepository, UserRepository userRepository) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
    }

    public Habit saveHabit(Habit habit) {
        return habitRepository.save(habit);
    }

    public List<Habit> getHabitsByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + userId));
        return habitRepository.findByUser(user);
    }

    public void deleteHabit(Long habitId) {
        habitRepository.deleteById(habitId);
    }

    public Habit updateHabit(Long habitId, Habit updatedHabit) {
        Habit existingHabit = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Hábito no encontrado con ID: " + habitId));

        existingHabit.setTitulo(updatedHabit.getTitulo());
        existingHabit.setObjetivo(updatedHabit.getObjetivo());
        existingHabit.setFrecuencia(updatedHabit.getFrecuencia());
        existingHabit.setColor(updatedHabit.getColor());
        existingHabit.setEstado(updatedHabit.getEstado());
        existingHabit.setFechaFin(updatedHabit.getFechaFin());

        return habitRepository.save(existingHabit);
    }

    public HabitMetricsDTO calculateMetricsForUser(Long userId) {
        List<Habit> habits = habitRepository.findByUser_UserId(userId);
        int total = habits.size();
        int completed = (int) habits.stream().filter(h -> "completed".equals(h.getEstado())).count();
        int inProgress = (int) habits.stream().filter(h -> "in_progress".equals(h.getEstado())).count();
        int failed = (int) habits.stream().filter(h -> "pending".equals(h.getEstado())).count();
        double rate = total > 0 ? (double) completed / total : 0.0;

        return new HabitMetricsDTO(userId, total, completed, inProgress, failed, rate);
    }


}
