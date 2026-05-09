package com.EjercicioAyudantia.ISoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EjercicioAyudantia.ISoft.dto.RequestTareaDTO;
import com.EjercicioAyudantia.ISoft.model.Tarea;
import com.EjercicioAyudantia.ISoft.service.PostTareaService;



@RestController
@RequestMapping("/tasks")
public class TareaController {

    private final PostTareaService postTareaService;

    public TareaController(PostTareaService postTareaService) {
        this.postTareaService = postTareaService;
    }

    @PostMapping()
    public ResponseEntity<Tarea> createTask(@RequestBody RequestTareaDTO requestTareaDTO) {
        return ResponseEntity.created(null).body(postTareaService.createTask(requestTareaDTO));
    }
    
}
    
