package br.edu.unoesc.pessoa.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.edu.unoesc.pessoa.builder.PessoaBuilder;
import br.edu.unoesc.pessoa.model.Pessoa;
import br.edu.unoesc.pessoa.service.PessoaService;

@RunWith(SpringRunner.class)
@WebMvcTest(PessoaController.class)
public class PessoaControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private PessoaService pessoaService;

	@Test
	public void testExample() throws Exception {

		Pessoa pessoa = new PessoaBuilder().comId(1l).comNome("Edivilson").build();

		given(this.pessoaService.findOne(pessoa.getId())).willReturn(pessoa);

		this.mvc.perform(
				get("/pessoa/find").param("id", pessoa.getId().toString()).accept(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk());
	}

}
