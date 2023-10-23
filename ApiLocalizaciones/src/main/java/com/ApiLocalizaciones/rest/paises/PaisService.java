package com.ApiLocalizaciones.rest.paises;

import com.ApiLocalizaciones.rest.ciudades.Ciudad;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PaisService {

    PaisRepository paisRepository;

    public PaisService(PaisRepository paisRepository) {
        this.paisRepository = paisRepository;
    }

    //buscar pais por coincidencia de cadena introducida
    List<Pais> findPaises(String term) {
        return paisRepository.findByNombreContainingIgnoreCase(term);
    }

    //buscar pais por su código
    public Pais findPaisPorCodigo(@RequestParam String codigoPais){
        return paisRepository.findBycodigo(codigoPais).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
