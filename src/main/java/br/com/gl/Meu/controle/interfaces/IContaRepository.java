package br.com.gl.Meu.controle.interfaces;

import br.com.gl.Meu.controle.entities.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContaRepository extends JpaRepository<Conta, Long> {

}
