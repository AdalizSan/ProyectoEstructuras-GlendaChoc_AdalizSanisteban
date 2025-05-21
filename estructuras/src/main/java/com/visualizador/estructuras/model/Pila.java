package com.visualizador.estructuras.model;

import java.util.LinkedList;

public class Pila {
    private LinkedList<Integer> elementos = new LinkedList<>();

    public void push(int valor) {
        elementos.push(valor);
    }

    public void pop() {
        if (!elementos.isEmpty()) elementos.pop();
    }

    public LinkedList<Integer> getElementos() {
        return elementos;
    }
}
