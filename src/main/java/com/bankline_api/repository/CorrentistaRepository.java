package com.bankline_api.repository;

import com.bankline_api.models.Correntista;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
