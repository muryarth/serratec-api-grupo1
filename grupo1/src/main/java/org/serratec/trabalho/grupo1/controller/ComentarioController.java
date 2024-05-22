package org.serratec.trabalho.grupo1.controller;

import org.serratec.trabalho.grupo1.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

}
