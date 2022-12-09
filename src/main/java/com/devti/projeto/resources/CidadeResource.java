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
import com.devti.projeto.services.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;



@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;
	
	@DeleteMapping("/{id}")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade excluida com sucesso"),
			@ApiResponse(code = 403, message = "Erro - Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
			@ApiResponse(code = 204, message = "Erro - Requisição vazia"),
			@ApiResponse(code = 404, message = "Erro - Não encontrado"),
	})
	public void excluir(@PathVariable("id")int id) {
		service.excluir(id);
	}
	
	
	@PutMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade editada com sucesso"),
			@ApiResponse(code = 403, message = "Erro - Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
			@ApiResponse(code = 204, message = "Erro - Requisição vazia"),
			@ApiResponse(code = 404, message = "Erro - Não encontrado"),
	})
	public Cidade alterar(@RequestBody Cidade c, @RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	
	@PostMapping
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cidade cadastrada com sucesso"),
			@ApiResponse(code = 403, message = "Erro - Permissão negada"),
			@ApiResponse(code = 500, message = "Erro interno do servidor"),
			@ApiResponse(code = 204, message = "Erro - Requisição vazia"),
			@ApiResponse(code = 404, message = "Erro - Não encontrado"),
	})
	public Cidade inserirCidade(@RequestBody Cidade c) {
		return service.incluir(c);
	}
	
	@GetMapping
	@ApiOperation(value = "Serviço de listagem de cidades")
	public List<Cidade> listarTodas(){
		return service.listarTodas();
	}
	
	@GetMapping("/buscaruf/{uf}")
	@ApiOperation(value = "Serviço de busca por UF")
	public List<Cidade> buscarPorUf(@PathVariable("uf")String uf){
		return service.buscarPorUf(uf);
	}
	
	

}
