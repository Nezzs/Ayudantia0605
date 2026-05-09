package com.EjercicioAyudantia.ISoft.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.repository.TareaRepository;

@Service
public class GetTareaFilterService {
    private final TareaRepository tareaRepository;
    
    public GetTareaFilterService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public List<Tarea> getFilteredTasks(String prioridad, String fechaLimite, String titulo) {
        List<Tarea> tareasFiltradas = new ArrayList<>();

        for (Tarea t : tareaRepository.findAll()) {
            if (prioridad != null && (t.getPrioridad() == null || !t.getPrioridad().equalsIgnoreCase(prioridad))) {
                continue;
            }

            if (titulo != null && (t.getTitulo() == null || !t.getTitulo().toLowerCase().contains(titulo.toLowerCase()))) {
                continue;
            }
            
            if (fechaLimite != null && (t.getFechaLimite() == null || !t.getFechaLimite().equals(fechaLimite))) {
                continue;
            }

            tareasFiltradas.add(t);
        }
        
        if (tareasFiltradas.isEmpty()) {
            return tareaRepository.findAll();
        } else {
            return tareasFiltradas;
        }
    }
    
}
