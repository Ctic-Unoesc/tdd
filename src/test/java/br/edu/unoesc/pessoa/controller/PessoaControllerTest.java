package br.edu.unoesc.pessoa.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import br.edu.unoesc.pessoa.builder.PessoaBuilder;
import br.edu.unoesc.pessoa.model.Pessoa;
import br.edu.unoesc.pessoa.service.PessoaService;

@RunWith(SpringRunner.class)
@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WebClient webClient;

	@MockBean
	private PessoaService pessoaService;

	@Test
	public void testExample() throws Exception {

		Pessoa pessoa = new PessoaBuilder().comId(1l).comNome("Edivilson").build();

		BDDMockito.given(this.pessoaService.findOne(2l)).willReturn(pessoa);

		this.mvc.perform(
				get("/pessoa/find").param("id", "2")
				.accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

	@Test
	public void testIndex() throws Exception {
		Pessoa pessoa = new PessoaBuilder().comId(1l).comNome("Edivilson").build();
		BDDMockito.given(this.pessoaService.findOne(pessoa.getId())).willReturn(pessoa);

		HtmlPage page = this.webClient.getPage("/pessoa/index");

		Assert.assertThat(page.getTitleText(), Matchers.equalTo("Unoesc TDD"));
	}

}
