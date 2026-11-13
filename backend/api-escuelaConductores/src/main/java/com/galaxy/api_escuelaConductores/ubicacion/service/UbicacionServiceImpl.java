package com.galaxy.api_escuelaConductores.ubicacion.service;

import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionRequestDto;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionResponseDto;
import com.galaxy.api_escuelaConductores.ubicacion.enity.UbicacionEntity;
import com.galaxy.api_escuelaConductores.ubicacion.mapper.UbicacionMapper;
import com.galaxy.api_escuelaConductores.ubicacion.repository.UbicacionRepository;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UbicacionServiceImpl implements UbicacionService{
    private final UbicacionRepository ubicacionRepository;
    private final UbicacionMapper ubicacionMapper;

    @Autowired
    public UbicacionServiceImpl(UbicacionRepository ubicacionRepository, UbicacionMapper ubicacionMapper) {
        this.ubicacionRepository = ubicacionRepository;
        this.ubicacionMapper = ubicacionMapper;
    }

    @Override
    public List<UbicacionResponseDto> findAll() throws ServiceException {
        return ubicacionRepository.findAllCustom().stream().map(ubicacionMapper::toDto).toList();

    }

    @Override
    public List<UbicacionResponseDto> findByNombre(String nombre) throws ServiceException {
        nombre= "%"+((nombre==null)?"":nombre.trim())+"%";
        return ubicacionRepository.findByNombre(nombre).stream().map(ubicacionMapper::toDto).toList();

    }

    @Override
    public Long save(UbicacionRequestDto ubicacionDto) throws ServiceException {
        UbicacionEntity ubicacionEntity=  ubicacionMapper.toEntity(ubicacionDto);
        ubicacionEntity.setEstado("1");
        UbicacionEntity ubicacionesEntity= ubicacionRepository.save(ubicacionEntity);
        return ubicacionesEntity.getId();

    }

    @Override
    public void delete(Long id) throws ServiceException {
        this.ubicacionRepository.deleteLogic(id);
    }









}
