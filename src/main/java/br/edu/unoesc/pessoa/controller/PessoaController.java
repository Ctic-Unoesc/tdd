package br.edu.unoesc.pessoa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.unoesc.pessoa.model.Pessoa;
import br.edu.unoesc.pessoa.service.PessoaService;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@GetMapping("/index")
	public ModelAndView index(Pessoa pessoa) {
		return new ModelAndView("pessoa/index");
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Pessoa pessoa, BindingResult result) {

		if (result.hasErrors()) {
			return index(pessoa);
		}

		pessoaService.save(pessoa);

		return new ModelAndView("redirect:/pessoa/index");
	}

	@GetMapping(value = "/find", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pessoa> findOne(@RequestParam(value = "id") Long id) {
		Pessoa pessoa = pessoaService.findOne(id);
		if (pessoa == null) {
			return new ResponseEntity<Pessoa>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}

}
