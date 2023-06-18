package com.pedropareschi.carros.service;

import com.pedropareschi.carros.entity.Carro;
import com.pedropareschi.carros.repository.CarroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CarroService {
    private final CarroRepository repository;

    public List<Carro> listarCarrosComFiltro(String modelo, Date dataInicial, Date dataFinal, Double valorMinimo, Double valorMaximo) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dataInicialStr = "";
        String dataFinalStr = "";
        if(dataInicial != null) {
            dataInicialStr = formatter.format(dataInicial);
        }
        if (dataFinal != null) {
            dataFinalStr = formatter.format(dataFinal);
        }
        return repository.listarCarrosComFiltro(modelo, dataInicialStr, dataFinalStr, valorMinimo, valorMaximo);
    }

    public Carro getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));
    }

    public Carro createCarro(Carro carro) {
        return repository.save(carro);
    }

    public Carro updateCarro(Long id, Carro carro) {
        Carro carroRepo = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));
        carroRepo.setValor(carro.getValor());
        carroRepo.setModelo(carro.getModelo());
        carroRepo.setPlaca(carro.getPlaca());
        return repository.save(carroRepo);
    }

    public void deleteById(Long id) {
        Carro carro = repository.findById(id).orElseThrow(() -> new RuntimeException("Erro não encontrado"));
        repository.deleteById(id);
    }
}
