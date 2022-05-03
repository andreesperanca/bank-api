package com.bankline_api.controllers;

import com.bankline_api.dto.NovoCorrentista;
import com.bankline_api.models.Correntista;
import com.bankline_api.repository.CorrestistaRepository;
import com.bankline_api.service.CorrentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {
    @Autowired
    private CorrestistaRepository repository;

    @Autowired
    private CorrentistaService service;

    @GetMapping
    public List<Correntista> findAll() {
        return repository.findAll();
    }

    @PostMapping
    public void save(@RequestBody NovoCorrentista correntista) {
        service.save(correntista);

    }
}
