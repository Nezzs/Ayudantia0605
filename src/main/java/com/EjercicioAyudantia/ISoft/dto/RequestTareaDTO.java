package com.EjercicioAyudantia.ISoft.dto;

import lombok.Data;

@Data
public class RequestTareaDTO {
    private String titulo;
    private String prioridad;
    private String fechaLimite;
}