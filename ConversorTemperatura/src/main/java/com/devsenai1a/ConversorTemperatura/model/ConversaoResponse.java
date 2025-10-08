package com.devsenai1a.ConversorTemperatura.model;

public class ConversaoResponse {
    private double resultado;

    public ConversaoResponse(double resultado) {
        this.resultado = resultado;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }
}