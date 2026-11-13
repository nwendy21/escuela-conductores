package com.galaxy.api_escuelaConductores.escuela.mapper;

import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaRequestDto;
import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaResponseDto;
import com.galaxy.api_escuelaConductores.escuela.entity.EscuelaEntity;
import com.galaxy.api_escuelaConductores.ubicacion.enity.UbicacionEntity;
import com.galaxy.api_escuelaConductores.ubicacion.mapper.UbicacionMapper;
import org.springframework.stereotype.Component;

@Component
public class EscuelaMapperImpl implements EscuelaMapper {

    private final UbicacionMapper ubicacionMapper;

    public EscuelaMapperImpl(UbicacionMapper ubicacionMapper) {
        this.ubicacionMapper = ubicacionMapper;
    }
    @Override
    public EscuelaResponseDto toDto(EscuelaEntity escuelaEntity) {
        return EscuelaResponseDto
                .builder()
                .id(escuelaEntity.getId())
                .nombre(escuelaEntity.getNombre())
                .ruc(escuelaEntity.getRuc())
                .direccion(escuelaEntity.getDireccion())
                .estado(escuelaEntity.getEstado())
                .ubicacion(ubicacionMapper.toDto(escuelaEntity.getUbicacion()))
                .build();
    }

    @Override
    public EscuelaEntity toEntity(EscuelaRequestDto escuelaRequestDto) {
        return EscuelaEntity
                .builder()
                .nombre(escuelaRequestDto.getNombre())
                .ruc(escuelaRequestDto.getRuc())
                .direccion(escuelaRequestDto.getDireccion())
                .ubicacion( new UbicacionEntity(escuelaRequestDto.getUbicacionId()))
                .build();
    }

}
