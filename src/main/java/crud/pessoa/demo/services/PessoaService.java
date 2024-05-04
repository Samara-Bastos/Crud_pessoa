package crud.pessoa.demo.services;

import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.PessoaRepository;
import jakarta.transaction.Transactional;

@Service
public class PessoaService {


    private Logger logger = Logger.getLogger(PessoaService.class.getName());

    //Anotação para fazer com que o Spring forneça automaticamente uma instância para essa classe (também conhecido como injeção de dependência)
    @Autowired
    private PessoaRepository repository;
 
    @Transactional //Anotação para fazer uma ligação direta com o banco de dados
    public Pessoa create(Pessoa pessoa){
        logger.info("Inserção de uma pessoa");
        return repository.save(pessoa);
    }

    @Transactional
    public Optional<Pessoa> findByPessoaCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    
}
