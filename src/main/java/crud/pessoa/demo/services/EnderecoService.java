package crud.pessoa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.EnderecoRepository;
import jakarta.transaction.Transactional;

@Service
public class EnderecoService {
    //Anotação para fazer com que o Spring forneça automaticamente uma instância para essa classe (também conhecido como injeção de dependência)
    @Autowired
    private EnderecoRepository repository;
 
    @Transactional
    public Endereco create(Endereco endereco){
        return repository.save(endereco);
    }
}