package crud.pessoa.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.pessoa.demo.exceptions.CreatePessoaException;
import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.EnderecoRepository;
import jakarta.transaction.Transactional;

import java.util.List;
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
        
        endereco.setCpf_pessoa(pessoa.get());
        return repository.save(endereco);
    }


    @Transactional
    public Endereco update(Endereco endereco, String cpf ) {

        List<Endereco> enderecos = repository.findByEnderecoCpfPessoa(cpf);
        
        if(enderecos.size() == 0){
            throw new CreatePessoaException("Endereço não encontrado");      
        }
        
        Endereco enderecoNovo = enderecos.get(0);

        enderecoNovo.setRua(endereco.getRua());
        enderecoNovo.setNumero(endereco.getNumero());
        enderecoNovo.setBairro(endereco.getBairro());
        enderecoNovo.setCidade(endereco.getCidade());
        enderecoNovo.setEstado(endereco.getEstado());
        enderecoNovo.setCep(endereco.getCep());
        enderecoNovo.setPrincipal(endereco.isPrincipal());

        return repository.save(enderecoNovo);
    }

    
    @Transactional
    public void delete(String cpf) {
        List<Endereco> enderecos = repository.findByEnderecoCpfPessoa(cpf);

        if (enderecos.size() == 0) {
            throw new CreatePessoaException("Endereço não encontrado ");
        }

        Endereco endereco = enderecos.get(0);
        repository.delete(endereco);
    }
}