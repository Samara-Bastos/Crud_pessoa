package crud.pessoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.dto.PessoaListDTO;
import crud.pessoa.demo.mapper.PessoaMapper;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.services.PessoaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController 
@RequestMapping("/pessoa") 
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaMapper pessoaMapper;


    @PostMapping 
    public ResponseEntity<Pessoa> cadatrar(@RequestBody @Valid PessoaDTO pessoaDTO){ 

        Pessoa pessoa = pessoaMapper.dtoToPessoa(pessoaDTO);

        var result = pessoaService.create(pessoa); 

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    
    @GetMapping()
    public Page<Object> exibirTodos(Pageable paginacao) {
		return pessoaService.findAll(paginacao);
	}


    @PutMapping("/{cpf}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable String cpf, @RequestBody PessoaDTO pessoaDTO) {
        Pessoa pessoa = pessoaMapper.dtoToPessoa(pessoaDTO);
        
        var result = pessoaService.update(cpf, pessoa); 

        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @DeleteMapping("/{cpf}")
	public ResponseEntity<?> deletar(@PathVariable String cpf) {
		pessoaService.delete(cpf);
		return ResponseEntity.noContent().build();
	}
}
