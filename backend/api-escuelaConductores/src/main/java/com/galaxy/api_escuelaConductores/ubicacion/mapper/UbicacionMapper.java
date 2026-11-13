package com.galaxy.api_escuelaConductores.ubicacion.mapper;


import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionRequestDto;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionResponseDto;
import com.galaxy.api_escuelaConductores.ubicacion.enity.UbicacionEntity;

public interface UbicacionMapper {

    UbicacionResponseDto toDto(UbicacionEntity ubicacionEntity);

    UbicacionEntity toEntity(UbicacionRequestDto ubicacionRequestDto);


}
