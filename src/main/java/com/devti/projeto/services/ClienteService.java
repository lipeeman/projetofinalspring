package com.devti.projeto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.projeto.model.Cidade;
import com.devti.projeto.model.Cliente;
import com.devti.projeto.repositories.ClienteRepository;



@Service
public class ClienteService {
	@Autowired
	ClienteRepository rep;
	
	public List<Cliente> listarTodos(){
		return rep.findAll();
	}
public void excluir(Integer id) {
	Cliente clienteExcluir = rep.findById(id).get();
	if(clienteExcluir != null) {
		rep.delete(clienteExcluir);
	}
	
}

public Cliente incluir(Cliente c) {
	return rep.save(c);
}
public List<Cliente> buscarPorCidade(Cidade c){
	return rep.findByCidade(c);
}
	
public Cliente adiciona(Cliente c) {
	return rep.save(c);
}

public Cliente alterar(Cliente c) {
	return rep.save(c);
}

public List<Cliente> findByCidadeNome(String nome){
	return rep.findByCidadeNome(nome);
	}

}
