package br.com.ultracon.contatoapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.ultracon.contatoapi.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

	List<Contato> findByNome(String nome);

	

}
