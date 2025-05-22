package com.visualizador.estructuras.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.*;

public class CSVService {

    private final PilaService pilaService = new PilaService();
    private final ColaService colaService = new ColaService();

    public void procesarCSV(MultipartFile file) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
        String linea;
        int paso = 0;
        br.readLine(); 

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length >= 2) {
                String estructura = partes[0].trim();
                String operacion = partes[1].trim();
                String valor = partes.length == 3 ? partes[2].trim() : "";

                paso++;
                switch (estructura.toLowerCase()) {
                    case "pila" -> pilaService.procesar(operacion, valor, paso);
                    case "cola" -> colaService.procesar(operacion, valor, paso);
                }
            }
        }
    }
}
