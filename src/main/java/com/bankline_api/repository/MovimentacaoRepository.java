package com.bankline_api.repository;

import com.bankline_api.models.Movimentacao;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
    List<Movimentacao> findByIdConta (Integer idConta);

}
