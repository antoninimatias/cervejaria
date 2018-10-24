package br.com.cervejaria.brewer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cervejaria.brewer.model.Cerveja;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Long> {

}
