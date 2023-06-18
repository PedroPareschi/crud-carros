package com.pedropareschi.carros.controller;

import com.pedropareschi.carros.entity.Carro;
import com.pedropareschi.carros.exceptions.ResourceNotFoundException;
import com.pedropareschi.carros.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/carros")
@AllArgsConstructor
public class CarroController {
    private final CarroService service;

    @GetMapping()
    public ResponseEntity<List<Carro>> listarCarrosComFiltro(
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataInicial,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataFinal,
            @RequestParam(required = false) Double valorMinimo,
            @RequestParam(required = false) Double valorMaximo
    ) {
        List<Carro> carros = service.listarCarrosComFiltro(modelo, dataInicial, dataFinal, valorMinimo, valorMaximo);
        return ResponseEntity.ok().body(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable Long id) {
        try {
            Carro carro = service.getById(id);
            return ResponseEntity.ok().body(carro);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Carro não encontrado");
        }
    }

    @PostMapping()
    public ResponseEntity<Carro> createCarro(@RequestBody Carro carro) {
        return ResponseEntity.ok().body(service.createCarro(carro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> updateCarro(@PathVariable Long id, @RequestBody Carro carro) {
        try {
            Carro carroUpdated = service.updateCarro(id, carro);
            return ResponseEntity.ok().body(carroUpdated);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Carro não encontrado");
        }
    }

    @DeleteMapping("{id}")
    public void deleteCarro(@PathVariable Long id) {
        try {
            service.deleteById(id);
        } catch (RuntimeException e) {
            throw new ResourceNotFoundException("Carro não encontrado");
        }
    }
}
