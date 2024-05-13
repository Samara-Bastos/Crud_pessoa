package crud.pessoa.demo.dto;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotBlank;

public record PessoaDTO(

    @NotBlank(message = "O nome não pode estar vazio") 
    String nome,

    @NotBlank(message = "A data de nascimento deve conter apenas números") 
    String nascimento, 

    @CPF 
    String cpf

){}
