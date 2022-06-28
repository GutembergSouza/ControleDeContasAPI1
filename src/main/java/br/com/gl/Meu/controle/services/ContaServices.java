package br.com.gl.Meu.controle.services;

import br.com.gl.Meu.controle.entities.Conta;
import br.com.gl.Meu.controle.interfaces.IContaRepository;
import br.com.gl.Meu.controle.interfaces.IContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ContaServices implements IContaService {
    IContaRepository repo;

    @Autowired
    public ContaServices(IContaRepository repo) {
        this.repo = repo;
    }


    @Override
    public Conta inserir(Conta conta) {
            conta.setEstaPaga(false);
            Conta contaSalva = repo.save(conta);
        return contaSalva;
    }

    @Override
    public Conta alterar(Conta conta) {
        Conta contaAlterada = repo.save(conta);
        return contaAlterada;
    }

    @Override
    public List<Conta> listarContasDoMes(Integer ano, Integer mes) {

        List<Conta> todasContas = repo.findAll()
                .stream()
                .filter(conta -> conta.getDataVencimento().getMonthValue() == mes
                        && conta.getDataVencimento().getYear() == ano)
                .toList(); //usando stream e filter() pa
        return todasContas;
    }

    @Override
    public List<Conta> listarTodasContas() {
        List<Conta> todasContas = repo.findAll();
        return todasContas;
    }

    @Override
    public String excluir(Long id) {
        repo.deleteById(id);

        return "Deletado Com Sucesso!";
    }
    @Override
    public List<Conta> listarPertoDeVencer(LocalDate dataDeHoje) {
        int diaAtual = dataDeHoje.getDayOfMonth();
        int mesAtual = dataDeHoje.getMonthValue();
        int anoAtual = dataDeHoje.getYear();

        List<Conta> contasDoMes = repo.findAll()
                .stream()
                .filter(conta -> conta.getDataVencimento().getMonthValue() == mesAtual
                              && conta.getDataVencimento().getYear() == anoAtual)
                .toList();

        return contasDoMes;
    }
    @Override
    public List<Conta> listarVencidas(LocalDate dataDeHoje) {
        int diaAtual = dataDeHoje.getDayOfMonth();
        int mesAtual = dataDeHoje.getMonthValue();
        int anoAtual = dataDeHoje.getYear();

        List<Conta> contasDoMes =
                listarContasDoMes(anoAtual, mesAtual)
                        .stream()
                        .filter(conta -> conta.getDataVencimento().getDayOfMonth() < diaAtual)
                        .toList();

        return contasDoMes;
    }

}
