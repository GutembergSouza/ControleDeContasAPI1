package br.com.gl.Meu.controle.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;

@Entity
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column
    String nome;

    @Column
    LocalDate dataVencimento;

    @Column
    boolean estaPaga;

    @Column
    Double valor;


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate data) {
        this.dataVencimento = data;
    }

    public boolean isEstaPaga() {
        return estaPaga;
    }

    public void setEstaPaga(boolean estaPaga) {
        this.estaPaga = estaPaga;
    }


    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataVencimento=" + dataVencimento +
                ", estaPaga=" + estaPaga +
                ", valor=" + valor +
                '}';
    }
}
