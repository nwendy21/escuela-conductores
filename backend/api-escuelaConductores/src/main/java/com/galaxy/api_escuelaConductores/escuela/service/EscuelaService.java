package com.galaxy.api_escuelaConductores.escuela.service;
import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaRequestDto;
import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaResponseDto;
import org.hibernate.service.spi.ServiceException;
import java.util.List;
public interface EscuelaService {


    List<EscuelaResponseDto> findAll() throws ServiceException;

    List<EscuelaResponseDto> findByNombre(String nombre) throws ServiceException;

    Long  save(EscuelaRequestDto escuelaRequestDto) throws ServiceException;

    void delete (Long id) throws ServiceException;


}
