package br.com.ultracon.contatoapi.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.ultracon.contatoapi.controller.dto.ContatoDTO;
import br.com.ultracon.contatoapi.controller.form.ContatoForm;
import br.com.ultracon.contatoapi.model.Contato;
import br.com.ultracon.contatoapi.repository.ContatoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "ContatoController", consumes = "application/json", produces = "application/json", description = "Trazer uma lista de cpf e cnpj")
@RestController
@RequestMapping(value = "/contato")
public class ContatoController {

	@Autowired
	ContatoRepository contatoRepository;

	public ContatoController(ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;

	}

	@ApiOperation(value = "Lista de contatos", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso|OK"),
			@ApiResponse(code = 400, message = "Requisição invalida"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") })

	@GetMapping
	public List<ContatoDTO> listarContato(String nome) {
		List<ContatoDTO> contatos;
		if (nome != null) {
			contatos = contatoRepository.findByNome(nome).stream().map(ContatoDTO::new).collect(Collectors.toList());

		} else {
			contatos = contatoRepository.findAll().stream().map(ContatoDTO::new).collect(Collectors.toList());
		}

		return contatos;
	}

	@ApiOperation(value = "Cadastra contatos", response = ContatoDTO.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Sucesso|OK"),
			@ApiResponse(code = 400, message = "Requisição invalida"),
			@ApiResponse(code = 500, message = "Erro interno no servidor") })

	@PostMapping
	@Transactional
	public ResponseEntity<ContatoDTO> cadastraContato(@RequestBody @Valid ContatoForm form, UriComponentsBuilder builder){
		Contato contato = form.converter(contatoRepository);
		contatoRepository.save(contato);
		URI uri = builder.path("/contato/{id}").buildAndExpand(contato.getId()).toUri();

		return ResponseEntity.created(uri).body(new ContatoDTO(contato));
	}

	@ApiOperation(value = "Altera nome, cpf e cnpj do contato ", response = ContatoDTO.class)
	@ApiResponses(value = { 
            @ApiResponse(code = 202, message = "Sucesso|ok"),
            @ApiResponse(code = 400, message = "Requisição inválida"),
            @ApiResponse(code = 500, message = "Erro interno no servidor") })
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContatoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ContatoForm form){
	
	Optional<Contato> contatoOptional = contatoRepository.findById(id);
	if (contatoOptional.isPresent()) {
		Contato contato = form.atualizar(id, contatoRepository);
		return ResponseEntity.ok(new ContatoDTO(contato));
		
	}
	return ResponseEntity.notFound().build();
}
	public ResponseEntity<Contato> delete(@PathVariable Long id) {
		Optional<Contato> contatoOptional = contatoRepository.findById(id);
		if (contatoOptional.isPresent()) {
			contatoRepository.deleteById(id);
			return ResponseEntity.ok().build();

		}
		return ResponseEntity.notFound().build();
	}
}
