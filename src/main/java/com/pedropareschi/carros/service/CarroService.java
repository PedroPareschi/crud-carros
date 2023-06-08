package com.pedropareschi.carros.service;

import com.pedropareschi.carros.entity.Carro;
import com.pedropareschi.carros.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarroService {
    private final CarroRepository repository;

    public List<Carro> getCarros() {
        return repository.findAll();
    }

    public Carro getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));
    }

    public Carro createCarro(Carro carro) {
        return repository.save(carro);
    }

    public Carro updateCarro(Long id, Carro carro) {
        Carro carroRepo = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));
        carroRepo.setCor(carro.getCor());
        carroRepo.setModelo(carro.getModelo());
        carroRepo.setPlaca(carro.getPlaca());
        return repository.save(carroRepo);
    }

    public void deleteById(Long id) {
        Carro carro = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));
        repository.deleteById(id);
    }
}
