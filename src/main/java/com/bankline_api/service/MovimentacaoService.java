package com.bankline_api.service;

import com.bankline_api.dto.NovaMovimentacao;
import com.bankline_api.models.Correntista;
import com.bankline_api.models.Movimentacao;
import com.bankline_api.models.MovimentacaoTipo;
import com.bankline_api.repository.CorrestistaRepository;
import com.bankline_api.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MovimentacaoService {
    @Autowired
    private MovimentacaoRepository repository;

    @Autowired
    private CorrestistaRepository correstistaRepository;
    public void save(NovaMovimentacao novaMovimentacao) {
        Movimentacao movimentacao = new Movimentacao();


        Double valor = novaMovimentacao.getTipo() == MovimentacaoTipo.RECEITA ? novaMovimentacao.getValor()
                : novaMovimentacao.getValor() * -1;

        movimentacao.setDataHora(LocalDateTime.now());
        movimentacao.setDescricao(novaMovimentacao.getDescricao());
        movimentacao.setIdConta(novaMovimentacao.getIdConta());
        movimentacao.setTipo(novaMovimentacao.getTipo());
        movimentacao.setValor(valor);

        Correntista correntista =   correstistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);

        if (correntista != null) {
            correntista.getConta().setSaldo(correntista.getConta().getSaldo() + valor);
            correstistaRepository.save(correntista);
        }

        repository.save(movimentacao);
    }
}
