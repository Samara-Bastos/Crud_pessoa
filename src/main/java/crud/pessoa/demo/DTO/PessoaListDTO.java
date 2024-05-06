package crud.pessoa.demo.DTO;

import java.util.List;

import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;

public record PessoaListDTO(

    String nome,

    String nascimento, 

    String cpf,

    List<Endereco> enderecos

) {
    public PessoaListDTO(Pessoa pessoa){
        this(pessoa.getNome(),pessoa.getNascimento(), pessoa.getCpf(), pessoa.getEnderecos());
    }
}
