package com.visualizador.estructuras.model;

public class Operacion {
    private String campo1;
    private String campo2;

    // Constructor vacío (requerido por Spring o frameworks)
    public Operacion() {}

    // Constructor con parámetros
    public Operacion(String campo1, String campo2) {
        this.campo1 = campo1;
        this.campo2 = campo2;
    }

    // Getters y Setters
    public String getCampo1() {
        return campo1;
    }

    public void setCampo1(String campo1) {
        this.campo1 = campo1;
    }

    public String getCampo2() {
        return campo2;
    }

    public void setCampo2(String campo2) {
        this.campo2 = campo2;
    }
}
