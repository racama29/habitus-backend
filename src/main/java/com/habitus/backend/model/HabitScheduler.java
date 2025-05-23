package com.habitus.backend.model;

import com.habitus.backend.repository.HabitRepository;
import com.habitus.backend.repository.HabitUpdateRepository;
import jakarta.transaction.Transactional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class HabitScheduler {

    private final HabitRepository habitRepository;
    private final HabitUpdateRepository habitUpdateRepository;

    public HabitScheduler(HabitRepository habitRepository, HabitUpdateRepository habitUpdateRepository) {
        this.habitRepository = habitRepository;
        this.habitUpdateRepository = habitUpdateRepository;
    }

    // Ejecutar cada día a las 00:00
    @Scheduled(cron = "0 0 0 * * *")
    @Transactional
    public void processHabits() {
        List<Habit> allHabits = habitRepository.findAll();
        LocalDate today = LocalDate.now();
        DayOfWeek day = today.getDayOfWeek();

        List<Habit> habitsToReset = new ArrayList<>();
        List<HabitUpdate> updatesToSave = new ArrayList<>();

        for (Habit habit : allHabits) {
            boolean shouldReset = false;

            if (habit.getFrecuencia() == Frecuency.DAILY) {
                shouldReset = true;
            } else if (habit.getFrecuencia() == Frecuency.WEEKLY && day == DayOfWeek.MONDAY) {
                shouldReset = true;
            }

            if (shouldReset) {
                LocalDate fechaAnterior = today.minusDays(1);
                LocalDateTime startOfDay = fechaAnterior.atStartOfDay();
                LocalDateTime endOfDay = fechaAnterior.atTime(23, 59, 59);

                boolean yaRegistrado = habitUpdateRepository
                        .existsByHabitAndFechaActualizacionBetween(habit, startOfDay, endOfDay);

                if (yaRegistrado) continue;

                HabitUpdate update = new HabitUpdate();
                update.setHabit(habit);
                update.setEstado(habit.getEstado());
                update.setFechaActualizacion(LocalDateTime.now().minusDays(1));
                updatesToSave.add(update);

                habit.setEstado("pending");
                habitsToReset.add(habit);
            }
        }

        habitUpdateRepository.saveAll(updatesToSave);
        habitRepository.saveAll(habitsToReset);
    }
}
