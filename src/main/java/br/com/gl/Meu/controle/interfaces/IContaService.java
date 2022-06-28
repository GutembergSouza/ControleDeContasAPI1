package br.com.gl.Meu.controle.interfaces;

import br.com.gl.Meu.controle.entities.Conta;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IContaService {

    public Conta inserir(Conta conta);
    public Conta alterar(Conta conta);
    public String excluir(Long id);

    public List<Conta>listarContasDoMes(Integer ano, Integer mes);
    public List<Conta>listarTodasContas();
    public List<Conta> listarPertoDeVencer(LocalDate data);
    public List<Conta> listarVencidas(LocalDate dataDeHoje);
}

