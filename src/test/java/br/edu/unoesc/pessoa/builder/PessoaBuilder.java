package br.edu.unoesc.pessoa.builder;

import br.edu.unoesc.pessoa.model.Pessoa;

public class PessoaBuilder {
	private Pessoa pessoa;

	public PessoaBuilder() {
		pessoa = new Pessoa();
	}

	public PessoaBuilder comId(Long id) {
		pessoa.setId(id);
		return this;
	}

	public PessoaBuilder comNome(String nome) {
		pessoa.setNome(nome);
		return this;
	}

	public Pessoa build() {
		return pessoa;
	}

}
