package com.galaxy.api_escuelaConductores.escuela.mapper;

import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaRequestDto;
import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaResponseDto;
import com.galaxy.api_escuelaConductores.escuela.entity.EscuelaEntity;

public interface EscuelaMapper {

    EscuelaResponseDto toDto(EscuelaEntity escuelaEntity);

    EscuelaEntity toEntity(EscuelaRequestDto escuelaRequestDto);


}
