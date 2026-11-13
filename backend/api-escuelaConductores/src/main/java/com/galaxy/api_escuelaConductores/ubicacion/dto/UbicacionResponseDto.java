package com.galaxy.api_escuelaConductores.ubicacion.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UbicacionResponseDto {
    private Long id;
    private String departamento;
    private String provincia;
    private String distrito;
    private String estado;
}
