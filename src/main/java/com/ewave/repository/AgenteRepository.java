package com.ewave.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ewave.domain.Agente;
import com.ewave.service.projections.AgenteProjection;

public interface AgenteRepository extends JpaRepository<Agente, Long> {

	@Query(value = "select regiao from agente group by regiao", nativeQuery = true)
	public List<AgenteProjection> findGroupByRegiao();
	
	@Query(value = "select codigo, data, regiao, geracao, compra, preco_medio precoMedio"
			+ " from agente WHERE regiao = ?1 ", nativeQuery = true)
	public List<AgenteProjection> buscarPorRegiao(String regiao);
}
