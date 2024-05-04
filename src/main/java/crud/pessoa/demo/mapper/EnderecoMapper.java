package crud.pessoa.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import crud.pessoa.demo.DTO.EnderecoDTO;
import crud.pessoa.demo.models.Endereco;

@Mapper(componentModel = "spring")
public interface EnderecoMapper {
    
    // Obtem uma instância do mapeador através do método estático Mappers.getMapper
    EnderecoMapper INSTANCE = Mappers.getMapper(EnderecoMapper.class);

    EnderecoDTO enderecoToDTO(Endereco endereco);

    //@Mapping(target = "cpf_pessoa", ignore = true) 
    Endereco dtoToEndereco(EnderecoDTO dto);
    
}
