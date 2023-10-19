package com.ApiLocalizaciones.rest.ciudades;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CiudadService {

    private final CiudadRepository ciudadRepository;

    public CiudadService(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    List<Ciudad> findCiudades(final String nombre) {
        if(nombre == null){
            return ciudadRepository.findAll();
        }
        List<Ciudad> buscarCiudades = ciudadRepository.findByNombreContainingIgnoreCase(nombre);
        return  buscarCiudades;
    }

    Ciudad findCiudad(final Long id){
        return ciudadRepository.findByid(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
