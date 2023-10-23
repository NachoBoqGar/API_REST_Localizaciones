package com.ApiLocalizaciones.rest.paises;

import com.ApiLocalizaciones.rest.ciudades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaisRepository extends JpaRepository<Pais, String> {

    List<Pais> findAll();
    List<Pais> findByNombreContainingIgnoreCase(String nombre);

    Optional<Pais> findBycodigo(String codigo);
}
