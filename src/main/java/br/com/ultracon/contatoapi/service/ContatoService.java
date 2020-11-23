package br.com.ultracon.contatoapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ultracon.contatoapi.model.Contato;
import br.com.ultracon.contatoapi.repository.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository contatoRepository;

	public Optional<Contato> findById(Long id) {

		return contatoRepository.findById(id);

	}

	public List<Contato> findAll() {
		return contatoRepository.findAll();

	}

	public void deleteById(Long id) {
		contatoRepository.deleteById(id);

	}

	public Contato save(Contato contato) {
		return contatoRepository.save(contato);

	}

	public void deleteAll() {
		contatoRepository.deleteAll();

	}
}
