package crud.pessoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import crud.pessoa.demo.DTO.PessoaDTO;
import crud.pessoa.demo.DTO.PessoaListDTO;
import crud.pessoa.demo.mapper.PessoaMapper;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.services.PessoaService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


//Anotação rest para indicar que essa classe é um controller
@RestController 
//Anotação para fazer o mapeamento da rota(dizer qual será a URL de acesso)
@RequestMapping("/pessoa") 
public class PessoaController {

    //Anotação para fazer com que o Spring forneça automaticamente uma instância para essa classe (também conhecido como injeção de dependência)
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaMapper pessoaMapper;


    //Anotação para indicar que a requisição será do tipo POST
    @PostMapping 
    //Anotação para indicar para o spring que esse json está vindo do corpo da requisição
    public ResponseEntity<Pessoa> cadatrar(@RequestBody @Valid PessoaDTO pessoaDTO){ 

        // Converte PessoaDTO para Pessoa usando o mapper
        Pessoa pessoa = pessoaMapper.dtoToPessoa(pessoaDTO);

        //Chama a função para salvar no banco
        var result = pessoaService.create(pessoa); 

        //Retorna um status de criação, a partir de uma requisição no corpo da página
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        
    }

    
    @GetMapping("path")
    public List<PessoaListDTO> exibirTodos() {
		return pessoaService.findAll();
	}








    

    // @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	// 		produces = MediaType.APPLICATION_JSON_VALUE)
	// public Person create(@RequestBody Person person) {
	// 	return service.create(person);
	// }
    
}
