package com.apiexterna.consumindo.uma.api.externa.via.cep.repository;

import com.apiexterna.consumindo.uma.api.externa.via.cep.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    Optional<Pessoa> findByCpf(String cpf);

    boolean existsByCpf(String cpf);
}
