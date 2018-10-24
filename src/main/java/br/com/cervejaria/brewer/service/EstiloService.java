package br.com.cervejaria.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cervejaria.brewer.model.Estilo;
import br.com.cervejaria.brewer.repository.EstiloRepository;

@Service
public class EstiloService {

	@Autowired
	private EstiloRepository estiloRepository;

	@Transactional
	public void save(Estilo estilo) {
		estiloRepository.save(estilo);
	}
}
