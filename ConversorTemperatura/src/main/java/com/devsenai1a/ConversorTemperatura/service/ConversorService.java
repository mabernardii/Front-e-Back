package com.devsenai1a.ConversorTemperatura.service;

import org.springframework.stereotype.Service;

@Service
public class ConversorService {

    public double converter(double valor, String de, String para) {
        double tempCelsius;

        switch (de) {
            case "C":
                tempCelsius = valor;
                break;
            case "F":
                tempCelsius = (valor - 32) * 5 / 9;
                break;
            case "K":
                tempCelsius = valor - 273.15;
                break;
            default:
                throw new IllegalArgumentException("Unidade inválida: " + de);
        }

        switch (para) {
            case "C":
                return Math.round(tempCelsius * 100.0) / 100.0;
            case "F":
                return Math.round((tempCelsius * 9 / 5 + 32) * 100.0) / 100.0;
            case "K":
                return Math.round((tempCelsius + 273.15) * 100.0) / 100.0;
            default:
                throw new IllegalArgumentException("Unidade inválida: " + para);
        }
    }
}