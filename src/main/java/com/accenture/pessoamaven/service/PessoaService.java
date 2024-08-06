package com.accenture.pessoamaven.service;

import com.accenture.pessoamaven.model.Pessoa;
import com.accenture.pessoamaven.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository repository;

    public void post(Pessoa pessoa) {
        repository.save(pessoa);
    }

    public List<Pessoa> findAll() {
        return repository.findAll();
    }

    public Optional<Pessoa> getById(Long id) {
        return repository.findById(id);
    }

    public Pessoa Put(long id, Pessoa newPessoa) throws Exception {
        Optional<Pessoa> oldPessoa = repository.findById(id);
        if(oldPessoa.isPresent()){
            Pessoa pessoa = oldPessoa.get();
            pessoa.setNome(newPessoa.getNome());
            return repository.save(pessoa);
        }
        else
            throw new Exception("Pessoa não encontrada");
    }

    public void delete(long id) throws Exception {
        Optional<Pessoa> pessoa = repository.findById(id);
        if(pessoa.isPresent()){
            repository.delete(pessoa.get());
        } else {
            throw new Exception("Pessoa não encontrada");
        }
    }


}
