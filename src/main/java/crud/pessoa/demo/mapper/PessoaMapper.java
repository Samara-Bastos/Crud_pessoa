package crud.pessoa.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.models.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO pessoaToDTO(Pessoa pessoa);

    Pessoa dtoToPessoa(PessoaDTO dto); // Mapeia um DTO PessoaDTO para uma entidade Pessoa
}
