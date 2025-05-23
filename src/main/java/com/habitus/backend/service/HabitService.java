package com.habitus.backend.service;

import com.habitus.backend.DTO.HabitMetricsDTO;
import com.habitus.backend.model.Habit;
import com.habitus.backend.model.HabitUpdate;
import com.habitus.backend.model.User;
import com.habitus.backend.repository.HabitRepository;
import com.habitus.backend.repository.HabitUpdateRepository;
import com.habitus.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HabitService {

    private final HabitRepository habitRepository;
    private final UserRepository userRepository;
    private final HabitUpdateRepository habitUpdateRepository;

    public HabitService(HabitRepository habitRepository, UserRepository userRepository, HabitUpdateRepository habitUpdateRepository) {
        this.habitRepository = habitRepository;
        this.userRepository = userRepository;
        this.habitUpdateRepository = habitUpdateRepository;
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
        Habit existing = habitRepository.findById(habitId)
                .orElseThrow(() -> new RuntimeException("Hábito no encontrado"));

        String estadoAnterior = existing.getEstado();
        String nuevoEstado = updatedHabit.getEstado();

        existing.setEstado(nuevoEstado);
        existing.setColor(updatedHabit.getColor());
        existing.setFechaFin(updatedHabit.getFechaFin());
        existing.setObjetivo(updatedHabit.getObjetivo());
        existing.setTitulo(updatedHabit.getTitulo());
        existing.setFrecuencia(updatedHabit.getFrecuencia());

        Habit saved = habitRepository.save(existing);

        if (!estadoAnterior.equals(nuevoEstado)) {
            HabitUpdate update = new HabitUpdate();
            update.setHabit(saved);
            update.setEstado(nuevoEstado);
            update.setFechaActualizacion(LocalDateTime.now());
            habitUpdateRepository.save(update);
        }

        return saved;
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
