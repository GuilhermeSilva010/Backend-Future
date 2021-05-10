package br.com.drummond.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.drummond.model.Cliente;
import br.com.drummond.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired 
	private final ClienteService clienteService;

	
	
	public ClienteController(ClienteService clienteService) {
		this.clienteService= clienteService;
	}


	// Obter todos os clientes
	@GetMapping()
	public ResponseEntity getAll() {
		return clienteService.getAll();
	}


	// Obter cliente por id
	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable("id") Integer id) {
		return clienteService.getById(id);
	}


	// Adicionar cliente
	@PostMapping
	public ResponseEntity addClient(@RequestBody Cliente cliente) {
		return clienteService.addClient(cliente);
	}


	// Atualizar cliente por id
	@PutMapping("/{id}")
	public ResponseEntity updateClient(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
		return clienteService.updateClient(id, cliente);
	}
}