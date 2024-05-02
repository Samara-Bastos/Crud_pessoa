package crud.pessoa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.PessoaRepository;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {

    //Anotação para fazer com que o Spring forneça automaticamente uma instância para essa classe (também conhecido como injeção de dependência)
    @Autowired
    private PessoaRepository repository;
 
    @Transactional
    public Pessoa create(Pessoa pessoa){
        return repository.save(pessoa);
    }
}
