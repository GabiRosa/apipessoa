package one.digitalinnovation.apipessoa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import one.digitalinnovation.apipessoa.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
