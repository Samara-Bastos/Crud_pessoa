package crud.pessoa.demo.DTO;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTO(

    @NotBlank(message = "A rua não pode estar vazia")
    String rua,

    @NotNull
    int numero, 

    @NotBlank(message = "O bairro não pode estar vazio")
    String bairro, 

    @NotBlank(message = "A cidade não pode estar vazia")
    String cidade, 

    @NotBlank(message = "O estado não pode estar vazio")
    String estado, 

    @NotBlank(message = "O cep não pode estar vazio")
    @Pattern(regexp = "\\d {8}") // Anotação para exigir que meu campo "cep" tenha 8 digitos
    String cep,

    @CPF
    String cpf_pessoa
) {}
