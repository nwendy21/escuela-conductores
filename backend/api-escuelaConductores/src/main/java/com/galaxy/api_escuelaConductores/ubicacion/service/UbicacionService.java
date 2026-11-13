package com.galaxy.api_escuelaConductores.ubicacion.service;

import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionRequestDto;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionResponseDto;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface UbicacionService {
    List<UbicacionResponseDto> findAll() throws ServiceException;

    List<UbicacionResponseDto> findByNombre(String nombre) throws ServiceException;

    Long  save(UbicacionRequestDto ubicacionDto) throws ServiceException;

    void delete (Long id) throws ServiceException;




}
