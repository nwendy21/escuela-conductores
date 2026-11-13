package com.galaxy.api_escuelaConductores.escuela.service;

import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaRequestDto;
import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaResponseDto;
import com.galaxy.api_escuelaConductores.escuela.entity.EscuelaEntity;
import com.galaxy.api_escuelaConductores.escuela.mapper.EscuelaMapper;
import com.galaxy.api_escuelaConductores.escuela.repository.EscuelaRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscuelaServiceImpl implements EscuelaService{

    private final EscuelaRepository escuelaRepository ;
    private final EscuelaMapper escuelaMapper;

    public EscuelaServiceImpl(EscuelaRepository escuelaRepository, EscuelaMapper escuelaMapper) {
        this.escuelaRepository = escuelaRepository;
        this.escuelaMapper= escuelaMapper;
    }

    @Override
    public List<EscuelaResponseDto> findAll() throws ServiceException {
        return escuelaRepository.findAllCustom().stream().map(escuelaMapper::toDto).toList();
    }

    @Override
    public List<EscuelaResponseDto> findByNombre(String nombre) throws ServiceException {
        nombre= "%"+((nombre==null)?"":nombre.trim())+"%";
        return escuelaRepository.findByNombre(nombre).stream().map(escuelaMapper::toDto).toList();
    }

    @Override
    public Long save(EscuelaRequestDto escuelaRequestDto) throws ServiceException {
        EscuelaEntity escuelaEntity=  escuelaMapper.toEntity(escuelaRequestDto);
        escuelaEntity.setEstado("1");
        EscuelaEntity escuelaEntity1 = escuelaRepository.save(escuelaEntity);
        return escuelaEntity1.getId();
    }




    @Override
    public void delete(Long id) throws ServiceException {
        this.escuelaRepository.deleteLogic(id);
    }

}
