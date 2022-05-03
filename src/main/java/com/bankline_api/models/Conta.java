package com.bankline_api.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class Conta {

    @Column(name = "conta_numero")
    private long numero;

    @Column(name = "conta_saldo")
    private double saldo;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}