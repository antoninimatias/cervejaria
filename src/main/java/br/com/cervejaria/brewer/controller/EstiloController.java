package br.com.cervejaria.brewer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cervejaria.brewer.model.Estilo;
import br.com.cervejaria.brewer.service.EstiloService;

@Controller
public class EstiloController {

	@Autowired
	private EstiloService estiloService;

	@RequestMapping(value = "/estilo/novo")
	public ModelAndView novo(Estilo estilo) {
		ModelAndView mv = new ModelAndView("/estilo/CadastroEstilo");
		return mv;
	}

	@RequestMapping(value = "/estilo/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Estilo estilo, BindingResult result, Model model,
			RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(estilo);
		}
		estiloService.save(estilo);
		attributes.addFlashAttribute("mensagem", "Estilo salvo com sucesso!");
		return new ModelAndView("redirect:/estilo/novo");
	}
}
