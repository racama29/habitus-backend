package com.habitus.backend.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HabitusTest {

    private Habit habit;

    @BeforeEach
    void setUp() {
        habit = new Habit();
    }

    @Test
    void testId() {
        habit.setId(1L);
        assertEquals(1L, habit.getId());
    }
    @Test
    void testTitulo() {
        habit.setTitulo("Leer");
        assertEquals("Leer", habit.getTitulo());
    }
    @Test
    void testObjetivo() {
        habit.setObjetivo("Leer 10 paginas al dia");
        assertEquals("Leer 10 paginas al dia", habit.getObjetivo());
    }
    @Test
    void testFrecuencia() {
        habit.setFrecuencia(Frecuency.DAILY);
        assertEquals(Frecuency.DAILY, habit.getFrecuencia());
    }
    @Test
    void testColor() {
        habit.setColor("#ffffff");
        assertEquals("#ffffff", habit.getColor());
    }
    @Test
    void testEstadoPorDefecto() {
        assertEquals("pending", habit.getEstado());
    }
    @Test
    void testSetEstado() {
        habit.setEstado("in_progress");
        assertEquals("in_progress", habit.getEstado());
    }
    @Test
    void testUser() {
        User user = new User();
        user.setUserId(5L);
        habit.setUser(user);
        assertEquals(5L, habit.getUser().getUserId());
    }
    @Test
    void testFechaFin() {
        LocalDate date = LocalDate.of(2025, 6, 1);
        habit.setFechaFin(date);
        assertEquals(date, habit.getFechaFin());
    }
    @Test
    void testUsuarios() {
        HabitUser hu1 = new HabitUser();
        HabitUser hu2 = new HabitUser();
        habit.setUsuarios(List.of(hu1, hu2));
        assertEquals(2, habit.getUsuarios().size());
    }
    @Test
    void testUpdates() {
        HabitUpdate up1 = new HabitUpdate();
        HabitUpdate up2 = new HabitUpdate();
        habit.setUpdates(List.of(up1, up2));
        assertEquals(2, habit.getUpdates().size());
    }
    @Test
    void testGetAndSetUpdateId() {
        HabitUpdate update = new HabitUpdate();
        update.setUpdateId(1L);
        assertEquals(1L, update.getUpdateId());
    }
    @Test
    void testGetAndSetHabit() {
        Habit habit = new Habit();
        habit.setTitulo("Ejemplo");
        HabitUpdate update = new HabitUpdate();
        update.setHabit(habit);
        assertEquals("Ejemplo", update.getHabit().getTitulo());
    }
    @Test
    void testGetAndSetEstado() {
        HabitUpdate update = new HabitUpdate();
        update.setEstado("completed");
        assertEquals("completed", update.getEstado());
    }
    @Test
    void testGetAndSetFechaActualizacion() {
        LocalDateTime fecha = LocalDateTime.of(2024, 1, 1, 12, 0);
        HabitUpdate update = new HabitUpdate();
        update.setFechaActualizacion(fecha);
        assertEquals(fecha, update.getFechaActualizacion());
    }
    @Test
    void testConstructorInicializaCamposComoNull() {
        HabitUpdate update = new HabitUpdate();
        assertNull(update.getUpdateId());
        assertNull(update.getHabit());
        assertNull(update.getEstado());
        assertNull(update.getFechaActualizacion());
    }
}