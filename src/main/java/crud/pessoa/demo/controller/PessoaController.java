package crud.pessoa.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.PessoaRepository;

//Anotação rest para indicar que essa classe é um controller
@RestController 
//Anotação para fazer o mapeamento da rota(dizer qual será a URL de acesso)
@RequestMapping("/pessoa") 
public class PessoaController {

    //Anotação para fazer com que o Spring forneça automaticamente uma instância para essa classe (também conhecido como injeção de dependência)
    @Autowired
    private PessoaRepository repository;

    //Anotação para indicar que a requisição será do tipo POST
    @PostMapping 
    //Anotação para indicar para o spring que esse json está vindo do corpo da requisição
    public void cadatrar(@RequestBody Pessoa pessoa){ 
        repository.save(pessoa);
    }








    

    // @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
	// 		produces = MediaType.APPLICATION_JSON_VALUE)
	// public Person create(@RequestBody Person person) {
	// 	return service.create(person);
	// }
    
}
