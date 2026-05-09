package com.EjercicioAyudantia.ISoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.dto.RequestTareaDTO;
import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.service.PostTareaService;
import com.EjercicioAyudantia.ISoft.service.GetTareaFilterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;




@RestController
@RequestMapping("/tasks")
public class TareaController {

    private final PostTareaService postTareaService;
    private final GetTareaFilterService getTareaFilterService;

    public TareaController(PostTareaService postTareaService, GetTareaFilterService getTareaFilterService) {
        this.postTareaService = postTareaService;
        this.getTareaFilterService = getTareaFilterService;
    }

    @PostMapping()
    public ResponseEntity<Tarea> createTask(@RequestBody RequestTareaDTO requestTareaDTO) {
        return ResponseEntity.created(null).body(postTareaService.createTask(requestTareaDTO));
    }

    @GetMapping()
    public ResponseEntity<List<Tarea>> getFilteredTasks(
        @RequestParam(required = false) String prioridad,
        @RequestParam(required = false) String fechaLimite,
        @RequestParam(required = false) String titulo) {
            
            return ResponseEntity.ok(getTareaFilterService.getFilteredTasks(prioridad, fechaLimite, titulo));
    }
}

    
