package com.galaxy.api_escuelaConductores.ubicacion.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UbicacionRequestDto {



    @NotNull(message = "El departamento es requerido")
    @Size(min = 2,max = 10, message = "El departamento es requerido y debe tener como mínimo {min} y {max} carateres")
    private String departamento;

    @NotNull(message = "La provincia es requerida")
    @Size(min = 2,max = 10, message = "La provincia es requerida y debe tener como mínimo {min} y {max} carateres")
    private String provincia;

    @NotNull(message = "El distrito es requerido")
    @Size(min = 2,max = 10, message = "El distrito es requerido y debe tener como mínimo {min} y {max} carateres")
    private String distrito;




}
