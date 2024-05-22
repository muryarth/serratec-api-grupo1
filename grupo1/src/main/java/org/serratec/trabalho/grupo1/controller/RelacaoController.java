package org.serratec.trabalho.grupo1.controller;

import org.serratec.trabalho.grupo1.service.RelacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/relacoes")
public class RelacaoController {
    @Autowired
    private RelacaoService relacaoService;

}
