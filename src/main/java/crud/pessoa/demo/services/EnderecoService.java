package crud.pessoa.demo.services;

import crud.pessoa.demo.dto.EnderecoAtualizaDTO;
import crud.pessoa.demo.dto.EnderecoDTO;
import crud.pessoa.demo.models.Endereco;

public interface EnderecoService {

    public Endereco create(EnderecoDTO enderecoDTO, String cpf);

    public Endereco update(EnderecoAtualizaDTO enderecoDTO, String cpf );
    
    public void delete(String cpf);
    
}
