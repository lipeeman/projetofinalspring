package com.devti.projeto.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devti.projeto.model.Cidade;
import com.devti.projeto.model.Cliente;
import com.devti.projeto.services.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService service;
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta cliente cadastrado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente excluido com sucesso"),
			@ApiResponse(code = 403, message = "Erro - Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
			@ApiResponse(code = 204, message = "Erro - Requisição vazia"),
			@ApiResponse(code = 404, message = "Erro - Não encontrado"),
	})
	public void excluir(@PathVariable ("id") int id) {
		service.excluir(id);
	}
	
	@PutMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente editada com sucesso"),
			@ApiResponse(code = 403, message = "Erro - Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
			@ApiResponse(code = 204, message = "Erro - Requisição vazia"),
			@ApiResponse(code = 404, message = "Erro - Não encontrado"),
	})
	public Cliente alterar(@RequestBody Cliente c, @RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@PostMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente cadastrado com sucesso"),
			@ApiResponse(code = 403, message = "Erro - Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
			@ApiResponse(code = 204, message = "Erro - Requisição vazia"),
			@ApiResponse(code = 404, message = "Erro - Não encontrado"),
	})
	public Cliente incluir(@RequestBody Cliente c) {
		return service.incluir(c);
	}
	
	@GetMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente listados com sucesso"),
			@ApiResponse(code = 403, message = "Erro - Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
			@ApiResponse(code = 204, message = "Erro - Requisição vazia"),
			@ApiResponse(code = 404, message = "Erro - Não encontrado"),
	})
	public List<Cliente> listarTodos(){
		return service.listarTodos();
	}
	
	@GetMapping("/buscacidade/{cidade}")
	@ApiOperation(value = "Serviço de busca por ID")
	public List<Cliente> buscaPorId(@PathVariable("cidade") Cidade  c){
		return service.buscarPorCidade(c); 
	}
	
	@GetMapping("/buscacidadenome/{nome}")
	@ApiOperation(value = "Serviço de busca por nome")
	public List<Cliente> buscaPorNomeCidades(@PathVariable("nome") String  nome){
		return service.findByCidadeNome(nome); 
	}
	
}
