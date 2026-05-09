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
import com.EjercicioAyudantia.ISoft.service.PatchTareaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;




@RestController
@RequestMapping("/tasks")
public class TareaController {

    private final PostTareaService postTareaService;
    private final GetTareaFilterService getTareaFilterService;
    private final PatchTareaService patchTareaService;

    public TareaController(PostTareaService postTareaService, GetTareaFilterService getTareaFilterService, PatchTareaService patchTareaService) {
        this.postTareaService = postTareaService;
        this.getTareaFilterService = getTareaFilterService;
        this.patchTareaService = patchTareaService;
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

    @PatchMapping("/{id}")
    public ResponseEntity<Tarea> markTaskAsCompleted(@PathVariable Long id){
        return ResponseEntity.ok(patchTareaService.updateStateTask(id));
    }
}
