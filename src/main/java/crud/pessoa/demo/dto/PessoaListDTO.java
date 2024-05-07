package crud.pessoa.demo.dto;

import java.util.List;

import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;

public record PessoaListDTO(

    Long id,

    String nome,

    String nascimento, 

    String cpf,

    List<Endereco> enderecos

) {
    public PessoaListDTO(Pessoa pessoa){
        this(pessoa.getId(), pessoa.getNome(),pessoa.getNascimento(), pessoa.getCpf(), pessoa.getEnderecos());
    }
}
