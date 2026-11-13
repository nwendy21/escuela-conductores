package com.galaxy.api_escuelaConductores.ubicacion.mapper;


import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionRequestDto;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionResponseDto;
import com.galaxy.api_escuelaConductores.ubicacion.enity.UbicacionEntity;
import org.springframework.stereotype.Component;

@Component
public class UbicacionMapperImpl implements UbicacionMapper {
    @Override
    public UbicacionResponseDto toDto(UbicacionEntity ubicacionEntity) {
        return UbicacionResponseDto
                .builder()
                .id(ubicacionEntity.getId())
                .departamento(ubicacionEntity.getDepartamento())
                .provincia(ubicacionEntity.getProvincia())
                .distrito(ubicacionEntity.getDistrito())
                .estado(ubicacionEntity.getEstado())
                .build();
    }

    @Override
    public UbicacionEntity toEntity(UbicacionRequestDto ubicacionRequestDto) {
        return UbicacionEntity
                .builder()
                .departamento(ubicacionRequestDto.getDepartamento())
                .provincia(ubicacionRequestDto.getProvincia())
                .distrito(ubicacionRequestDto.getDistrito())
                .build();
    }
}
