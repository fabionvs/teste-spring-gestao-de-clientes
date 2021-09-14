package com.teste.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.entity.Clientes;
import com.teste.entity.Email;
import com.teste.entity.Telefone;
import com.teste.model.ClienteRequest;
import com.teste.model.EmailRequest;
import com.teste.model.TelefoneRequest;
import com.teste.repository.ClientesRepository;
import com.teste.repository.EmailRepository;
import com.teste.repository.TelefoneRepository;

@RestController
public class ClienteController {

	@Autowired
	ClientesRepository clientesRepository;
	
	@Autowired
	TelefoneRepository telefoneRepository;
	
	@Autowired
	EmailRepository emailRepository;


	Logger logger = LoggerFactory.getLogger(ClienteController.class);

	@CrossOrigin
	@GetMapping("/clientes")
	public ResponseEntity<List<Clientes>> getAllClientes() {
		try {
			List<Clientes> clientes = new ArrayList<Clientes>();

			clientesRepository.findAll().forEach(clientes::add);

			if (clientes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Clientes> getClientesById(@PathVariable("id") long id) {
		Optional<Clientes> clientesData = clientesRepository.findById(id);

		if (clientesData.isPresent()) {
			return new ResponseEntity<>(clientesData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@PostMapping(value="/clientes", consumes="application/json", produces="application/json")
	public ResponseEntity<ClienteRequest> createClientes(@RequestBody ClienteRequest clienteRequest) {
		try {
			Clientes cliente = new Clientes();
			cliente.setBairro(clienteRequest.getBairro());
			cliente.setCep(clienteRequest.getCep());
			cliente.setCidade(clienteRequest.getCidade());
			cliente.setCpf(clienteRequest.getCpf());
			cliente.setLogradouro(clienteRequest.getLogradouro());
			cliente.setUf(clienteRequest.getUf());
			cliente.setNome(clienteRequest.getNome());
			cliente.setComplemento(clienteRequest.getComplemento());
			
			Clientes _Clientes = clientesRepository.save(cliente);
			
			for(TelefoneRequest d : clienteRequest.getTelefones()) {
				String n = d.getNumero().replaceAll("[^\\d.]", "");
				Telefone tele = new Telefone(n, d.getTipo(), cliente);
				Telefone telefone = telefoneRepository.save(tele);
			}
			
			for(EmailRequest d : clienteRequest.getEmails()) {
				Email e = new Email(d.getEmail(), cliente);
				Email email = emailRepository.save(e);
			}
			
			return new ResponseEntity<>(clienteRequest, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Clientes> updateClientes(@PathVariable("id") long id, @RequestBody Clientes Clientes) {
		Optional<Clientes> ClientesData = clientesRepository.findById(id);

		if (ClientesData.isPresent()) {
			Clientes _Clientes = ClientesData.get();
//			_Clientes.setTitle(Clientes.getTitle());
//			_Clientes.setDescription(Clientes.getDescription());
//			_Clientes.setPublished(Clientes.isPublished());
			return new ResponseEntity<>(clientesRepository.save(_Clientes), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<HttpStatus> deleteClientes(@PathVariable("id") long id) {
		try {
			clientesRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@DeleteMapping("/clientes")
	public ResponseEntity<HttpStatus> deleteAllClientes() {
		try {
			clientesRepository.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	

}