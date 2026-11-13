package com.galaxy.api_escuelaConductores.ubicacion.controller;
import com.galaxy.api_escuelaConductores.exceptions.CustomBadRequest;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionRequestDto;
import com.galaxy.api_escuelaConductores.ubicacion.dto.UbicacionResponseDto;
import com.galaxy.api_escuelaConductores.ubicacion.service.UbicacionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestHeader;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("api/v1/ubicacion")
public class UbicacionController {
    private final UbicacionService ubicacionService;

    public UbicacionController(UbicacionService ubicacionService) {
        this.ubicacionService = ubicacionService;

    }

    @GetMapping
    public ResponseEntity<List<UbicacionResponseDto>> findAll(){

        List<UbicacionResponseDto> ubicacionResponseDto = ubicacionService.findAll();

        if (ubicacionResponseDto.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(ubicacionResponseDto );
        }
    }

    @GetMapping("/by-nombre")
    public ResponseEntity<List<UbicacionResponseDto>> findByNombre(@RequestParam("nombre") String nombre){

        List<UbicacionResponseDto>  ubicacionResponseDto= ubicacionService.findByNombre(nombre);

        if (ubicacionResponseDto.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(ubicacionResponseDto);
        }

    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody UbicacionRequestDto ubicacionRequestDto,
                                  BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            throw new CustomBadRequest(bindingResult);
        }
        Long id = ubicacionService.save(ubicacionRequestDto);

        if (id==null) {
            return ResponseEntity.badRequest().build();
        } else {
            return new ResponseEntity<>(Map.of("id",id),HttpStatus.CREATED);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        this.ubicacionService.delete(id);
        return ResponseEntity.ok().build();

    }







}
