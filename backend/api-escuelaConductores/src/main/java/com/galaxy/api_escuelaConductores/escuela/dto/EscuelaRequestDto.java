package com.galaxy.api_escuelaConductores.escuela.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EscuelaRequestDto {

    @NotNull(message = "El nombre es requerido")
    @Size(min = 30,max = 120, message = "El nombre es requerido y debe tener como mínimo {min} y {max} carateres")
    private String nombre;

    @NotNull(message = "El ruc es requerido")
    @Size(min = 30,max = 120, message = "El ruc  es requerido y debe tener como mínimo {min} y {max} carateres")
    private String ruc;

    @NotNull(message = "La direccion  es requerido")
    @Size(min = 30,max = 120, message = "La direccion es requerido y debe tener como mínimo {min} y {max} carateres")
    private String direccion;


    @NotNull(message = "La ubicacion es requerida")
    @Positive(message = "La ubicacion debe ser mayor que cero")
    private Long ubicacionId;




}
