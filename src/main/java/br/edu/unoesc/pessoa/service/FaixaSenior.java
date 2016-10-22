package br.edu.unoesc.pessoa.service;

import br.edu.unoesc.pessoa.model.Faixa;

public class FaixaSenior implements Faixa {

	@Override
	public Float calcular(Float valor) {
		return (float) (valor  * 0.3);
	}

}
