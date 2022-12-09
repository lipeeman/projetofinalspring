package com.devti.projeto.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devti.projeto.model.Cidade;






@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
	
	List<Cidade> findByUf(String uf);

}
