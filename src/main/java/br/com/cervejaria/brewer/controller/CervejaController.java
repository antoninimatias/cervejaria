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

import br.com.cervejaria.brewer.model.Cerveja;
import br.com.cervejaria.brewer.model.Origem;
import br.com.cervejaria.brewer.model.Sabor;
import br.com.cervejaria.brewer.repository.Estilos;

@Controller
public class CervejaController {

	@Autowired
	private Estilos estilos;

	@RequestMapping(value = "/cervejas/novo")
	public ModelAndView novo(Cerveja cerveja) {
		ModelAndView mv = new ModelAndView("cerveja/CadastroCerveja");
		mv.addObject("sabores", Sabor.values());
		mv.addObject("estilos", estilos.findAll());
		mv.addObject("origens", Origem.values());
		return mv;
	}

	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
		/*if (result.hasErrors()) {
			return novo(cerveja);
		}*/
		attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
		System.out.println(">>>Sku: " + cerveja.getSku());
		System.out.println(">>>Sku: " + cerveja.getSabor());
		System.out.println(">>>Sku: " + cerveja.getNome());
		System.out.println(">>>Sku: " + cerveja.getOrigem());
		System.out.println(">>>Sku: " + cerveja.getDescricao());
		return new ModelAndView("redirect:/cervejas/novo");
	}
}
