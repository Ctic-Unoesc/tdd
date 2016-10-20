package br.edu.unoesc.pessoa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.unoesc.pessoa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
