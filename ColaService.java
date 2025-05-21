package com.visualizador.estructuras.service;

import com.visualizador.estructuras.model.Cola;
import com.visualizador.estructuras.util.GraphvizUtil;
import java.util.List;

public class ColaService {
    private final Cola cola = new Cola();

    public void procesar(String operacion, String valor, int paso) throws Exception {
        switch (operacion.toLowerCase()) {
            case "insertar" -> cola.enqueue(Integer.parseInt(valor));
            case "eliminar" -> cola.dequeue();
        }
        String dot = GraphvizUtil.generarDotParaCola("Cola", cola.getElementos());
        GraphvizUtil.generarImagen(dot, "cola_" + paso);
    }
}
