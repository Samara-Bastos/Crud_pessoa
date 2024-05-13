package crud.pessoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import crud.pessoa.demo.dto.EnderecoAtualizaDTO;
import crud.pessoa.demo.dto.EnderecoDTO;
import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.mapper.EnderecoMapper;
import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.services.EnderecoService;
import jakarta.validation.Valid;

//Anotação rest para indicar que essa classe é um controller
@RestController 
//Anotação para fazer o mapeamento da rota(dizer qual será a URL de acesso)
@RequestMapping("/endereco") 
public class EnderecoController {
    
    //Anotação para fazer com que o Spring forneça automaticamente uma instância para essa classe (também conhecido como injeção de dependência)
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    //Anotação para indicar que a requisição será do tipo POST
    @PostMapping 
    //Anotação para indicar para o spring que esse json está vindo do corpo da requisição
    public ResponseEntity<Endereco> cadatrar(@RequestBody @Valid EnderecoDTO enderecoDTO){ 

        // Converte EnderecoDTO para Endereco usando o mapper
        Endereco endereco = enderecoMapper.dtoToEndereco(enderecoDTO);

        //Chama a função para salvar no banco
        var result = enderecoService.create(endereco, enderecoDTO.cpf_pessoa()); 

        //Retorna um status de criação, a partir de uma requisição no corpo da página
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Endereco> atualizar(@PathVariable String cpf, @RequestBody EnderecoAtualizaDTO enderecoDTO) {
        // Converte PessoaDTO para Pessoa usando o mapper
        Endereco endereco = enderecoMapper.dtoAtualizaToEndereco(enderecoDTO);
        
        //Chama a função para aualizar no banco
        var result = enderecoService.update(endereco, cpf); 

        //Retorna um status de criação, a partir de uma requisição no corpo da página
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{cpf}")
    //Anotação para passar um parametro na url, no caso um cpf
	public ResponseEntity<?> deletar(@PathVariable String cpf) {
		enderecoService.delete(cpf);
		return ResponseEntity.noContent().build();
	}

}
