package com.EjercicioAyudantia.ISoft.service;

import org.springframework.stereotype.Service;

import com.EjercicioAyudantia.ISoft.dto.RequestTareaDTO;
import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.repository.TareaRepository;

@Service
public class PostTareaService {

    private final TareaRepository tareaRepository;

    public PostTareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea createTask(RequestTareaDTO requestTareaDTO) {
        Tarea tarea = new Tarea();
        tarea.setTitulo(requestTareaDTO.getTitulo());
        tarea.setPrioridad(requestTareaDTO.getPrioridad());
        tarea.setFechaLimite(requestTareaDTO.getFechaLimite());
        return tareaRepository.save(tarea);
    }
    
}
