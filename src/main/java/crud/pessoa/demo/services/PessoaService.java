package crud.pessoa.demo.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.dto.ResponsePessoaDTO;
import crud.pessoa.demo.models.Pessoa;

public interface PessoaService {

    public ResponsePessoaDTO create(PessoaDTO pessoaDTO);

    public Page<Object> findAll(Pageable paginacao);
    
    public Pessoa update(String cpf, PessoaDTO pessoaDTO);

    public void delete(String cpf); 
}
