package crud.pessoa.demo.services;

import java.util.Optional;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.pessoa.demo.DTO.PessoaListDTO;
import crud.pessoa.demo.exceptions.CreatePessoaException;
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

        // Optional<Pessoa> pessoaReturn = findByPessoaCpf(pessoa.getCpf());
        
        // if(pessoaReturn.isPresent()){
        //     throw new CreatePessoaException("Já existe uma pessoa cadastrada com esse CPF");
            
        // }
    
        return repository.save(pessoa);
    }

  
    public Optional<Pessoa> findByPessoaCpf(String cpf){
        return repository.findByCpf(cpf);
    }


    public List<PessoaListDTO> findAll() {
        logger.info("Pessoas cadastradas");
		return repository.findAll().stream().map(PessoaListDTO::new).toList();
	}

    public Pessoa findById(Long id) {
		logger.info("Pessoa");
        return repository.findById(id).orElseThrow(() -> new CreatePessoaException("Pessoa não encontrada")); 
	}
}
