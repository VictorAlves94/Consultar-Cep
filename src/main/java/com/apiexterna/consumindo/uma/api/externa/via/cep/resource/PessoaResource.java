package com.apiexterna.consumindo.uma.api.externa.via.cep.resource;

import com.apiexterna.consumindo.uma.api.externa.via.cep.dto.CepDto;
import com.apiexterna.consumindo.uma.api.externa.via.cep.model.Pessoa;
import com.apiexterna.consumindo.uma.api.externa.via.cep.repository.PessoaRepository;
import com.apiexterna.consumindo.uma.api.externa.via.cep.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;

@RestController
@RequestMapping("/pessoa")
public class PessoaResource {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaService pessoaService;

    @ResponseBody
    @GetMapping(value = "/consulta_Cep/{cep}")
    public ResponseEntity<CepDto> consulta_Cep(@PathVariable("cep") String cep){
       CepDto cepDto = pessoaService.consultaCep(cep);
       return new ResponseEntity<CepDto>(cepDto, HttpStatus.OK);
    }

    public PessoaResource(PessoaRepository pessoaRepository, PessoaService pessoaService) {
        this.pessoaRepository = pessoaRepository;
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long id) {
        Pessoa pessoa = (Pessoa) pessoaRepository.findAllById(Collections.singleton(id));
        return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = pessoaService.atualizar(id, pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }
}
