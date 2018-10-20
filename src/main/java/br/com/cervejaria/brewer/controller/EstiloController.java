package br.com.cervejaria.brewer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.cervejaria.brewer.model.Cerveja;

@Controller
public class EstiloController {

	@RequestMapping(value = "/estilo/novo")
	public String novo(Cerveja cerveja) {
		return "estilo/CadastroEstilo";
	}
}
