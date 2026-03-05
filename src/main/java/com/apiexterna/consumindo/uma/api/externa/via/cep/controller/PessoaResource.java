package com.apiexterna.consumindo.uma.api.externa.via.cep.controller;

import com.apiexterna.consumindo.uma.api.externa.via.cep.dto.CepDto;
import com.apiexterna.consumindo.uma.api.externa.via.cep.entity.Pessoa;
import com.apiexterna.consumindo.uma.api.externa.via.cep.repository.PessoaRepository;
import com.apiexterna.consumindo.uma.api.externa.via.cep.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
    private final PessoaRepository pessoaRepository;
    private final PessoaService pessoaService;

    public PessoaResource(PessoaRepository pessoaRepository, PessoaService pessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaService = pessoaService;
    }

    @GetMapping("/cep/{cep}")
    public ResponseEntity<CepDto> consultarCep(@PathVariable String cep){
        CepDto cepDto = pessoaService.consultaCep(cep);
        return ResponseEntity.ok(cepDto);
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long id) {

        Optional<Pessoa> pessoa = pessoaRepository.findById(id);

        return pessoa.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {

        Pessoa pessoaSalva = pessoaService.atualizar(id, pessoa);

        return ResponseEntity.ok(pessoaSalva);
    }
    }

