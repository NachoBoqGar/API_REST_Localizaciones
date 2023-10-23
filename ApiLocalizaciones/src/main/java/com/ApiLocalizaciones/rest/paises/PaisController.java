package com.ApiLocalizaciones.rest.paises;

import com.ApiLocalizaciones.rest.ciudades.Ciudad;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("paises")
@RestController
public class PaisController {

    PaisService paisService;

    public PaisController(PaisService paisService) {
        this.paisService = paisService;
    }

    //utilizamos term como nombre de parametro ya que AJAX lo utiliza por defecto y así no lo configuramos en nuestra aplicación para utiliza otro
    @GetMapping
    List<Pais> buscarPaises (@RequestParam(required = false) final String term){
        return paisService.findPaises(term);
    }

    @GetMapping("/{codigoPais}")
    Pais pais(@PathVariable final String codigoPais){
        return  paisService.findPaisPorCodigo(codigoPais);
    }
}
