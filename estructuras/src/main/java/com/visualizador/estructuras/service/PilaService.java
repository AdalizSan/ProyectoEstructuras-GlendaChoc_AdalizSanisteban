package com.visualizador.estructuras.service;

import com.visualizador.estructuras.model.Pila;
import com.visualizador.estructuras.util.GraphvizUtil;
import java.util.List;

public class PilaService {
    private final Pila pila = new Pila();

    public void procesar(String operacion, String valor, int paso) throws Exception {
        switch (operacion.toLowerCase()) {
            case "insertar" -> pila.push(Integer.parseInt(valor));
            case "eliminar" -> pila.pop();
        }
        String dot = GraphvizUtil.generarDotParaPila("Pila", pila.getElementos());
        GraphvizUtil.generarImagen(dot, "pila_" + paso);
    }
}
