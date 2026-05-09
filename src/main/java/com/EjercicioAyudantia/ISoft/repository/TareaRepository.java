package com.EjercicioAyudantia.ISoft.repository;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.EjercicioAyudantia.ISoft.model.Tarea;

@Repository
public class TareaRepository {
    private final List<Tarea> tareas = new ArrayList<>();


    public List<Tarea> findAll() {
        return tareas;
    }

    public Tarea findById(Long id){
        for (Tarea t : tareas){
            if (t.getId().equals(id)){
                return t;
            }
        }
        return null;
    }

    public Tarea save(Tarea tarea){
        Long id = tareas.size() + 1L;
        tarea.setId(id);
        tareas.add(tarea);
        return tarea;
    }
}
