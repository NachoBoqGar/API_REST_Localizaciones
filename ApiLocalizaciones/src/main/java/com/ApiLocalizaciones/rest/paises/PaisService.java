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

    //buscar pais por coincidencia de cadena introducida o mostrarlos todos si non se introduce nada
    public List<Pais> findPaises(String cadena) {
        if(cadena == null){
            return paisRepository.findAll();
        }

        List<Pais> buscarPaises = paisRepository.findByNombreContainingIgnoreCase(cadena);
        return  buscarPaises;
    }

    //buscar pais por su código
    public Pais findPaisPorCodigo(@RequestParam String codigoPais){
        return paisRepository.findBycodigo(codigoPais).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
