package com.galaxy.api_escuelaConductores.ubicacion.enity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "UbicacionEntity")
@Table(name = "tbl_ubicaciones")

public class UbicacionEntity {

    @Id
    @Column(name = "ubicacion_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "departamento", unique = true, nullable = false, length = 60)
    private String departamento;

    @Column(name = "provincia",  unique = true,nullable = false, length = 60)
    private String provincia;

    @Column(name = "distrito", unique = true, nullable = false, length = 60)
    private String distrito;

    @Column(name = "estado")
    private String estado;

    public UbicacionEntity(Long id) {
        this.id = id;
    }

}
