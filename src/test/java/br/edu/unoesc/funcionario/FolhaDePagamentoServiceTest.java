package br.edu.unoesc.funcionario;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.unoesc.pessoa.model.Venda;
import br.edu.unoesc.pessoa.service.FolhaDePagamentoService;

@RunWith(SpringRunner.class)
public class FolhaDePagamentoServiceTest {

	//public Float calcularComissaoPorCargo(List<Venda> vendas) {
	
	private FolhaDePagamentoService folhaDePagamentoService = new FolhaDePagamentoService();
	
	@Test
	public void deveRetorno0CasoSemVenda() {
		List<Venda> vendas = Collections.EMPTY_LIST;
		Float comissao = folhaDePagamentoService.calcularComissaoDeVendas(vendas);
		
		Assert.assertThat(comissao, Matchers.equalTo(0.0f));
	}
	
	@Test
	public void deveAplicar10PorcentoNaFaixade1a100() {
		List<Venda> vendas = Arrays.asList(new Venda(10.0f), 
				new Venda(70.0f), 
				new Venda(20.0f));

		Float total = 0.0f;
		for (Venda venda : vendas) {
			total += venda.valor;
		}
		total = total * 0.1f;
		
		Float comissao = this.folhaDePagamentoService.calcularComissaoDeVendas(vendas);
		
		Assert.assertThat(comissao, Matchers.equalTo(total));
	}
	
	@Test
	public void deveAplicar20PorcentoNaFaixade101a200() {
		List<Venda> vendas = Arrays.asList(new Venda(10.0f), 
				new Venda(70.0f), 
				new Venda(50.0f));

		Float total = 0.0f;
		for (Venda venda : vendas) {
			total += venda.valor;
		}
		total = total * 0.2f;
		
		Float comissao = this.folhaDePagamentoService.calcularComissaoDeVendas(vendas);
		
		Assert.assertThat(comissao, Matchers.equalTo(total));
	}
	
	@Test
	public void deveAplicar30PorcentoAcimaDe200() {
		List<Venda> vendas = Arrays.asList(new Venda(200.0f), 
				new Venda(70.0f), 
				new Venda(50.0f));

		Float total = 0.0f;
		for (Venda venda : vendas) {
			total += venda.valor;
		}
		total *= 0.3f;
		
		Float comissao = this.folhaDePagamentoService.calcularComissaoDeVendas(vendas);
		
		Assert.assertThat(comissao, Matchers.equalTo(total));
	}
}
