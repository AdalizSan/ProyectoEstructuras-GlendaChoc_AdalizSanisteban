package com.visualizador.estructuras.model;

import java.util.LinkedList;

public class Cola {
    private LinkedList<Integer> elementos = new LinkedList<>();

    public void enqueue(int valor) {
        elementos.add(valor);
    }

    public void dequeue() {
        if (!elementos.isEmpty()) elementos.removeFirst();
    }

    public LinkedList<Integer> getElementos() {
        return elementos;
    }
}
