package com.ApiLocalizaciones.rest.ciudades;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("ciudades")
@RestController
public class CiudadController {

    private CiudadService ciudadService;

    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;

    }

    @GetMapping
    List<Ciudad> buscarCiudades (@RequestParam(required = false ) final String cadena){
        return ciudadService.findCiudades(cadena);
    }

    @GetMapping("/{idCiudad}")
    Ciudad ciudad (@PathVariable final Long idCiudad){
        return ciudadService.findCiudad(idCiudad);
    }
}
