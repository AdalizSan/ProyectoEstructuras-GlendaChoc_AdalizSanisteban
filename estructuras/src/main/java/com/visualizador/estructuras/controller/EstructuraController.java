package com.visualizador.estructuras.controller;

import com.visualizador.estructuras.service.CSVService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/estructura")
public class EstructuraController {

    private final CSVService csvService = new CSVService();

    @PostMapping("/procesar")
    public ResponseEntity<String> procesarArchivo(@RequestParam("file") MultipartFile file) {
        try {
            csvService.procesarCSV(file);
            return ResponseEntity.ok("Archivo procesado y estructuras generadas.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
