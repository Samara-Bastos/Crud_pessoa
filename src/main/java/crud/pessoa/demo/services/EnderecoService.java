package crud.pessoa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.pessoa.demo.exceptions.CreatePessoaException;
import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EnderecoService {


    private Logger logger = Logger.getLogger(EnderecoService.class.getName());

    //Anotação para fazer com que o Spring forneça automaticamente uma instância para essa classe (também conhecido como injeção de dependência)
    @Autowired
    private EnderecoRepository repository;
 
    @Autowired
    private PessoaService pessoaService;

    @Transactional
    public Endereco create(Endereco endereco, String cpf){
        logger.info("Inserção de um endereço");

        Optional<Pessoa> pessoa = pessoaService.findByPessoaCpf(cpf);
        
        if(pessoa.isEmpty()){
            throw new CreatePessoaException("Pessoa não encontrada");
            
        }
        
        endereco.setCpfPessoa(pessoa.get());
        return repository.save(endereco);
    }


}