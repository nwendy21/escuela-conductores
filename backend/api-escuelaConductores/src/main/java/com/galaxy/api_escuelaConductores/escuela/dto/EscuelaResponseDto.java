package com.galaxy.api_escuelaConductores.escuela.dto;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class EscuelaResponseDto {

    private Long id;
    private String nombre;
    private String ruc;
    private String direccion;
    private String estado;
    private UbicacionResponseDto ubicacion;




}
