package com.galaxy.api_escuelaConductores.ubicacion.repository;

import com.galaxy.api_escuelaConductores.ubicacion.enity.UbicacionEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository<UbicacionEntity, Long> {
    //JPQL
    @Query(nativeQuery = false, value = "select u from UbicacionEntity u where u.estado='1'")
    List<UbicacionEntity> findAllCustom();

    //JPQL
    @Query(nativeQuery = false,
            value = "select u from UbicacionEntity u where (u.departamento like :nombre or u.provincia like :nombre or u.distrito like :nombre) and u.estado = '1'")
    List<UbicacionEntity> findByNombre(@Param("nombre") String nombre);




    // SQL
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update tbl_ubicaciones set estado='0' where ubicacion_id=:id")
    void deleteLogic(@Param("id") Long id);
}
