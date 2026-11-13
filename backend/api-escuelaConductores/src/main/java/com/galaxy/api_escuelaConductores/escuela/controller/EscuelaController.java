package com.galaxy.api_escuelaConductores.escuela.controller;


import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaRequestDto;
import com.galaxy.api_escuelaConductores.escuela.dto.EscuelaResponseDto;
import com.galaxy.api_escuelaConductores.escuela.service.EscuelaService;
import com.galaxy.api_escuelaConductores.exceptions.CustomBadRequest;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/escuela")
public class EscuelaController {
    private final EscuelaService escuelaService;

    public EscuelaController(EscuelaService escuelaService) {
        super();
        this.escuelaService = escuelaService;

    }

    @GetMapping
    public ResponseEntity<List<EscuelaResponseDto>> findAll(){

        List<EscuelaResponseDto> escuelaResponseDto = escuelaService.findAll();

        if (escuelaResponseDto.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(escuelaResponseDto);
        }

    }

    @GetMapping("/by-nombre")
    public ResponseEntity<List<EscuelaResponseDto>> findByNombre(@RequestParam("nombre") String nombre){

        List<EscuelaResponseDto> escuelaResponseDto = escuelaService.findByNombre(nombre);

        if ( escuelaResponseDto.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(escuelaResponseDto);
        }

    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody EscuelaRequestDto escuelaRequestDto,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.info("escuelaRequestDto {}",escuelaRequestDto);

        }
        Long id = escuelaService.save(escuelaRequestDto);

        if (id==null) {
            return ResponseEntity.badRequest().build();
        } else {
            return new ResponseEntity<>(Map.of("id",id),HttpStatus.CREATED);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        this.escuelaService.delete(id);
        return ResponseEntity.ok().build();

    }


}
