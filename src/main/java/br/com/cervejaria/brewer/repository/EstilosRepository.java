package br.com.cervejaria.brewer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cervejaria.brewer.model.Estilo;

@Repository
public interface EstilosRepository extends JpaRepository<Estilo, Long> {

	public Optional<Estilo> findByNomeIgnoreCase(String nome);
}
