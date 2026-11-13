package com.galaxy.api_escuelaConductores.escuela.repository;
import com.galaxy.api_escuelaConductores.escuela.entity.EscuelaEntity;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface EscuelaRepository extends  JpaRepository<EscuelaEntity, Id> {

    //JPQL
    @Query(nativeQuery = false, value = "select u from EscuelaEntity u where u.estado='1'")
    List<EscuelaEntity> findAllCustom();

    //JPQL
    @Query(nativeQuery = false,
            value = "select u from EscuelaEntity u "
                    + " where u.nombre like :nombre "
                    + " and u.estado= '1'")
    List<EscuelaEntity> findByNombre(@Param("nombre") String nombre);
    // SQL
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "update tbl_escuela set estado='0' where escuela_id=:id")
    void deleteLogic(@Param("id") Long id);




}
