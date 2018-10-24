package br.com.cervejaria.brewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cervejaria.brewer.model.Cerveja;
import br.com.cervejaria.brewer.repository.Cervejas;

@Service
public class CadastroCervejaService {
	
	@Autowired
	private Cervejas cervejas;
	
	@Transactional
	public void save(Cerveja cerveja) {
		cervejas.save(cerveja);
	}
}
