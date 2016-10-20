package br.edu.unoesc.pessoa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoa.model.Pessoa;
import br.edu.unoesc.pessoa.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;

	public void save(Pessoa pessoa) {
		repository.save(pessoa);
	}
	
	public void remove(Pessoa pessoa) {
		repository.delete(pessoa);
	}
	
	public List<Pessoa> findAll() {
		return repository.findAll();
	}
	
	public Pessoa findOne(Long id) {
		return repository.findOne(id);
	}

}
