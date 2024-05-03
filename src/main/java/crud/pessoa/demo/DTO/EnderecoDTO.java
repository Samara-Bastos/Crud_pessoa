package crud.pessoa.demo.DTO;

public record EnderecoDTO(
    String rua, 
    int numero, 
    String bairro, 
    String cidade, 
    String estado, 
    String cep,
    Long fk_pessoa
) {}
