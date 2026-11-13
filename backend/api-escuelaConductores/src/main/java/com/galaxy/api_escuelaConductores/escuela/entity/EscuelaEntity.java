package com.galaxy.api_escuelaConductores.escuela.entity;
import com.galaxy.api_escuelaConductores.ubicacion.enity.UbicacionEntity;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "EscuelaEntity")
@Table(name = "tbl_escuela")

public class EscuelaEntity {
    @Id
    @Column(name ="escuela_id" )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="nombre",  unique = true, nullable = false,length = 120)
    private String nombre;

    @Column(name ="ruc", unique = true, nullable = false,length = 120)
    private String ruc;

    @Column(name ="direccion", unique = true, nullable = false,length = 120)
    private String direccion;


    @Column(name ="estado",  unique = true,nullable = false)
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ubicacion_id", nullable = false)
    private UbicacionEntity ubicacion;


}
