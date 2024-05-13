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


@RestController 
@RequestMapping("/endereco") 
public class EnderecoController {
    
    @Autowired
    private EnderecoService enderecoService;

    @Autowired
    private EnderecoMapper enderecoMapper;

    @PostMapping 
    public ResponseEntity<Endereco> cadatrar(@RequestBody @Valid EnderecoDTO enderecoDTO){ 

        Endereco endereco = enderecoMapper.dtoToEndereco(enderecoDTO);

        var result = enderecoService.create(endereco, enderecoDTO.cpf_pessoa()); 

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    @PutMapping("/{cpf}")
    public ResponseEntity<Endereco> atualizar(@PathVariable String cpf, @RequestBody EnderecoAtualizaDTO enderecoDTO) {
    
        Endereco endereco = enderecoMapper.dtoAtualizaToEndereco(enderecoDTO);
        
        var result = enderecoService.update(endereco, cpf); 

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{cpf}")
	public ResponseEntity<?> deletar(@PathVariable String cpf) {
		enderecoService.delete(cpf);
		return ResponseEntity.noContent().build();
	}

}
