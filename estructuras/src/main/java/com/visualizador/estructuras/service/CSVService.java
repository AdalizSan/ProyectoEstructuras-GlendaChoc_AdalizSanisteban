package com.visualizador.estructuras.service;

import com.visualizador.estructuras.model.Operacion;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {

    public List<Operacion> procesarCSV(MultipartFile archivo) throws Exception {
        List<Operacion> operaciones = new ArrayList<>();

        // Validar extensión del archivo
        if (archivo == null || archivo.isEmpty()) {
            throw new Exception("El archivo está vacío o no se ha enviado.");
        }

        String nombreArchivo = archivo.getOriginalFilename();
        if (nombreArchivo == null || !nombreArchivo.toLowerCase().endsWith(".csv")) {
            throw new Exception("El archivo no tiene una extensión válida (.csv).");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(archivo.getInputStream()))) {
            String linea;
            int fila = 0;
            while ((linea = br.readLine()) != null) {
                fila++;
                String[] datos = linea.split(",");
                if (datos.length != 2) {
                    throw new Exception("Formato inválido en la línea " + fila + ". Se esperaban 2 columnas.");
                }
                operaciones.add(new Operacion(datos[0].trim(), datos[1].trim()));
            }
        } catch (Exception e) {
            throw new Exception("Error al leer el archivo CSV: " + e.getMessage());
        }

        System.out.println("Archivo CSV procesado correctamente.");
        return operaciones;
    }
}

