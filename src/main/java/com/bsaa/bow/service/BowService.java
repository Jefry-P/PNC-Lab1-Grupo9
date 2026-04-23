package com.bsaa.bow.service;

import com.bsaa.bow.model.Bow;
import com.bsaa.bow.repository.BowRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BowService {
    private final BowRepository repository;

    public BowService(BowRepository repository) {
        this.repository = repository;
    }

    public List<Bow> filtrarPorVirus(String virus) {
        return repository.findAll().stream()
                .filter(b -> b.getVirusBase().equalsIgnoreCase(virus))
                .collect(Collectors.toList());
    }

    public List<Bow> filtrarPorEstado(String estado) {
        return repository.findAll().stream()
                .filter(b -> b.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public List<String> virusActivosSinRepetir() {
        return repository.findAll().stream()
                .filter(b -> b.getEstado().equalsIgnoreCase("En libertad"))
                .map(Bow::getVirusBase)
                .distinct()
                .collect(Collectors.toList());
    }

}
