package com.devsenai1a.ConversordeMoeda;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") 
public class ConversorController {

    private static final double DOLAR_PARA_REAL = 5.0;
    private static final double EURO_PARA_REAL = 5.5;

    @GetMapping("/converter")
    public String converter(@RequestParam double valor,
                            @RequestParam String origem,
                            @RequestParam String destino) {

        double valorEmReal;

        switch (origem.toLowerCase()) {
            case "real":
                valorEmReal = valor;
                break;
            case "dolar":
                valorEmReal = valor * DOLAR_PARA_REAL;
                break;
            case "euro":
                valorEmReal = valor * EURO_PARA_REAL;
                break;
            default:
                return "Moeda de origem inválida.";
        }

        double valorConvertido;

        switch (destino.toLowerCase()) {
            case "real":
                valorConvertido = valorEmReal;
                break;
            case "dolar":
                valorConvertido = valorEmReal / DOLAR_PARA_REAL;
                break;
            case "euro":
                valorConvertido = valorEmReal / EURO_PARA_REAL;
                break;
            default:
                return "Moeda de destino inválida.";
        }

        return String.format("Valor convertido: %.2f %s", valorConvertido, destino);
    }
}