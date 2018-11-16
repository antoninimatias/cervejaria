package br.com.cervejaria.brewer.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cervejaria.brewer.model.Estilo;
import br.com.cervejaria.brewer.repository.EstilosRepository;
import br.com.cervejaria.brewer.service.exception.NomeEstiloJaCadastradoException;

@Service
public class EstilosService {

	@Autowired
	private EstilosRepository estiloRepository;

	@Transactional
	public Estilo save(Estilo estilo) {
		Optional<Estilo> estiloOptional = estiloRepository.findByNomeIgnoreCase(estilo.getNome());
		if (estiloOptional.isPresent()) {
			throw new NomeEstiloJaCadastradoException("Estilo já Cadastrado");
		}
		return estiloRepository.saveAndFlush(estilo);
	}
}
