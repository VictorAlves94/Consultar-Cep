package com.apiexterna.consumindo.uma.api.externa.via.cep.repository;

import com.apiexterna.consumindo.uma.api.externa.via.cep.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
