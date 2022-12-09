package com.devti.projeto.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devti.projeto.model.Cidade;
import com.devti.projeto.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByCidade(Cidade c);
	
	List<Cliente> findByCidadeNome(String nome);
	
	

}
