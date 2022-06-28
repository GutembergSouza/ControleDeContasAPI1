package br.com.gl.Meu.controle.controllers;

import br.com.gl.Meu.controle.entities.Conta;
import br.com.gl.Meu.controle.services.ContaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/contas")
public class ContaController {

    ContaServices service;


    @Autowired
    public ContaController(ContaServices service) {
        this.service = service;
    }


    @PostMapping("/inserir")
    public String inserir(@RequestBody Conta conta){
        Conta contaSalve = service.inserir(conta);
        return contaSalve.toString();
    }

    @PutMapping("/alterar")
    public String alterar(@RequestBody Conta conta){ //>>> nao se esqueça de alterar pra passar o id
        Conta alterada = service.alterar(conta);
        return alterada.toString();
    }

    @DeleteMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id){
        return service.excluir(id);
    }

    @GetMapping("/todas")
    public List<Conta> listarContasDoMes(){
        return service.listarTodasContas();
    }

    @GetMapping("/doMes/{ano}/{mes}")
    public List<Conta> listarContasDoMes(@PathVariable Integer ano,@PathVariable Integer mes){
        return service.listarContasDoMes(ano, mes);
    }

    @GetMapping("/pertoDeVencer")
    public List<Conta> listarPertoDeVencer(){
        LocalDate hoje = LocalDate.now();
        return service.listarPertoDeVencer(hoje);
    }

    @GetMapping("/vencidas")
    public List<Conta> listarVencidas(){
        LocalDate hoje = LocalDate.now();
        return service.listarVencidas(hoje);
    }

}
