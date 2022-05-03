package com.bankline_api.controllers;

import com.bankline_api.dto.NovaMovimentacao;
import com.bankline_api.dto.NovoCorrentista;
import com.bankline_api.models.Correntista;
import com.bankline_api.models.Movimentacao;
import com.bankline_api.repository.CorrestistaRepository;
import com.bankline_api.repository.MovimentacaoRepository;
import com.bankline_api.service.CorrentistaService;
import com.bankline_api.service.MovimentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentacoes")

public class MovimentacaoController {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private MovimentacaoService service;

    @GetMapping
    public List<Movimentacao> findAll() {
        return repository.findAll();
    }
    @PostMapping
    public void save(@RequestBody NovaMovimentacao movimentacao) {
        service.save(movimentacao);
    }
}
