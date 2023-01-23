package com.apiexterna.consumindo.uma.api.externa.via.cep.service;

import com.apiexterna.consumindo.uma.api.externa.via.cep.dto.CepDto;
import com.apiexterna.consumindo.uma.api.externa.via.cep.model.Pessoa;
import com.apiexterna.consumindo.uma.api.externa.via.cep.repository.PessoaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;
    private Pessoa pessoa;

    public Pessoa atualizar(Long id, Pessoa pessoa) {
        Pessoa pessoaSalva = buscarPessoaPeloCodigo(id);

        BeanUtils.copyProperties(pessoa, pessoaSalva, "codigo");
        return pessoaRepository.save(pessoaSalva);
    }

    private Pessoa buscarPessoaPeloCodigo(Long id) {
        Pessoa pessoaSalva = (Pessoa) pessoaRepository.findAllById(Collections.singleton(id));


        return pessoaSalva;
    }

    public CepDto consultaCep(String cep){
        return new RestTemplate().getForEntity("viacep.com.br/ws/" + cep + "/json/",CepDto.class).getBody();
    }
}
