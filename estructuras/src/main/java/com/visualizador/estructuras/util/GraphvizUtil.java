package com.visualizador.estructuras.util;

import java.io.*;

public class GraphvizUtil {
    public static void generarImagen(String dot, String nombreArchivo) throws IOException, InterruptedException {
        File imagesDir = new File("images");
        if (!imagesDir.exists()) imagesDir.mkdirs();

        File dotFile = new File("images/" + nombreArchivo + ".dot");
        FileWriter fw = new FileWriter(dotFile);
        fw.write(dot);
        fw.close();

        ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", dotFile.getAbsolutePath(), "-o", "images/" + nombreArchivo + ".png");
        pb.start().waitFor();
    }

    public static String generarDotParaPila(String nombre, java.util.List<Integer> elementos) {
        StringBuilder sb = new StringBuilder("digraph G {\nrankdir=LR;\nnode [shape=box];\n");
        for (int i = 0; i < elementos.size(); i++) {
            sb.append(String.format("n%d [label=\"%d\"];\n", i, elementos.get(i)));
            if (i > 0) sb.append(String.format("n%d -> n%d;\n", i, i - 1));
        }
        sb.append("}");
        return sb.toString();
    }

    public static String generarDotParaCola(String nombre, java.util.List<Integer> elementos) {
        StringBuilder sb = new StringBuilder("digraph G {\nrankdir=LR;\nnode [shape=box];\n");
        for (int i = 0; i < elementos.size(); i++) {
            sb.append(String.format("n%d [label=\"%d\"];\n", i, elementos.get(i)));
            if (i < elementos.size() - 1) sb.append(String.format("n%d -> n%d;\n", i, i + 1));
        }
        sb.append("}");
        return sb.toString();
    }
}
