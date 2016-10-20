package br.edu.unoesc.pessoa.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.edu.unoesc.pessoa.builder.PessoaBuilder;
import br.edu.unoesc.pessoa.model.Pessoa;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PessoaRepositoryTest {

	@Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PessoaRepository repository;

    @Test
    public void testExample() throws Exception {
        Pessoa pes = new PessoaBuilder().comNome("Edivilson").build();
		entityManager.persist(pes);
        
        Pessoa pessoa = this.repository.findFirstByNome("Edivilson");
        
        assertThat(pessoa.getNome()).isEqualTo("Edivilson");
    }
}
