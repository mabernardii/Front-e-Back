package com.devsenai1a.ConversorTemperatura.controller;

import com.devsenai1a.ConversorTemperatura.model.ConversaoRequest;
import com.devsenai1a.ConversorTemperatura.model.ConversaoResponse;
import com.devsenai1a.ConversorTemperatura.service.ConversorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") 
public class ConversorController {

    private final ConversorService service;

    public ConversorController(ConversorService service) {
        this.service = service;
    }

    @PostMapping("/converter")
    public ConversaoResponse converter(@RequestBody ConversaoRequest request) {
        double resultado = service.converter(request.getValor(), request.getDe(), request.getPara());
        return new ConversaoResponse(resultado);
    }
}