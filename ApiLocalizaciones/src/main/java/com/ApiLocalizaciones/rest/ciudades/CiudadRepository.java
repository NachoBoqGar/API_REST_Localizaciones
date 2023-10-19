package com.ApiLocalizaciones.rest.ciudades;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    List<Ciudad> findByNombreContainingIgnoreCase(String cadena);
    Optional<Ciudad> findByid(Long id);
}
