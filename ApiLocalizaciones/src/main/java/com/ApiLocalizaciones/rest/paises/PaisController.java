package com.ApiLocalizaciones.rest.paises;

import com.ApiLocalizaciones.rest.ciudades.Ciudad;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/paises")
@RestController
public class PaisController {

    PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    @GetMapping
    List<Pais> buscarPaises (@RequestParam(required = false) final String cadena){
        return paisService.findPaises(cadena);
    }

    @GetMapping("/{codigoPais}")
    Pais pais(@PathVariable final String codigoPais){
        return  paisService.findPaisPorCodigo(codigoPais);
    }
}
