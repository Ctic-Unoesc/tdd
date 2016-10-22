package br.edu.unoesc.pessoa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.unoesc.pessoa.model.Venda;

@Service
public class FolhaDePagamentoService {

	public Float calcularComissaoDeVendas(List<Venda> vendas) {
		Float total = 0f;
		for (Venda venda : vendas) {
			total += venda.valor;
		}
		if (total > 1 && total <= 100) {
			return total * 0.1f;
		}
		
		if (total > 100 && total <= 200) {
			return total * 0.2f;
		}
		
		if (total > 200) {
			return total * 0.3f;
		}
		return 0.0f;
	}

}
