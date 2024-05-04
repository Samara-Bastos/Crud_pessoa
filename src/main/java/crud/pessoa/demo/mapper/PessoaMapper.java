package crud.pessoa.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import crud.pessoa.demo.DTO.PessoaDTO;
import crud.pessoa.demo.models.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {

    // Obtem uma instância do mapeador através do método estático Mappers.getMapper
    PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);

    PessoaDTO pessoaToDTO(Pessoa pessoa);

    // @Mapping(target = "enderecos", ignore = true) // Ignora o mapeamento do atributo enderecos
    Pessoa dtoToPessoa(PessoaDTO dto); // Mapeia um DTO PessoaDTO para uma entidade Pessoa
}
