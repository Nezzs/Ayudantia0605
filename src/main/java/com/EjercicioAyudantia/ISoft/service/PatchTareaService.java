package com.EjercicioAyudantia.ISoft.service;

import org.springframework.stereotype.Service;

import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.repository.TareaRepository;

@Service
public class PatchTareaService {
    private final TareaRepository tareaRepository;

    public PatchTareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea updateStateTask (Long id){
        Tarea t = tareaRepository.findById(id);

        if (t != null){
            t.setCompletada(true);
            return t;
        } else {
            return null;
        }
    }

}
