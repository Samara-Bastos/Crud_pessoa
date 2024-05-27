package crud.pessoa.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import crud.pessoa.demo.dto.EnderecoAtualizaDTO;
import crud.pessoa.demo.dto.EnderecoDTO;
import crud.pessoa.demo.dto.ResponseEnderecoDTO;
import crud.pessoa.demo.models.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    ResponseEnderecoDTO enderecoToDTO(Endereco endereco);

    @Mapping(target = "cpf_pessoa", ignore = true) 
    Endereco dtoToEndereco(EnderecoDTO dto);

    @Mapping(target = "cpf_pessoa", ignore = true) 
    Endereco dtoAtualizaToEndereco(EnderecoAtualizaDTO dto);
    
}
