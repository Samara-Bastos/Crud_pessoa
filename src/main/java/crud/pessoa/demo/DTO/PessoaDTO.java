package crud.pessoa.demo.DTO;

import org.hibernate.validator.constraints.br.CPF;
import jakarta.validation.constraints.NotBlank;

public record PessoaDTO(

    //Anotação para determinar que o valor enviado não esteja vazio (funciona apenas para string)
    @NotBlank(message = "O nome não pode estar vazio") 
    String nome,

    @NotBlank(message = "A data de nascimento deve conter apenas números") 
    String nascimento, 

    @CPF 
    String cpf

){}
