package com.bankline_api.service;


import com.bankline_api.dto.NovoCorrentista;
import com.bankline_api.models.Conta;
import com.bankline_api.models.Correntista;
import com.bankline_api.repository.CorrestistaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CorrentistaService {

    private CorrestistaRepository repository;
    public void save (NovoCorrentista novoCorrentista) {
        Conta conta = new Conta();
        conta.setNumero(new Date().getTime());
        conta.setSaldo(0.0);

        Correntista correntista = new Correntista();
        correntista.setCpf(novoCorrentista.getCpf());
        correntista.setNome(novoCorrentista.getNome());
        correntista.setConta(conta);

        repository.save(correntista);
    }
}
