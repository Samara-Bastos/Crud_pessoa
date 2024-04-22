package crud.pessoa.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController //Anotação rest para indicar que essa classe é um controller
@RequestMapping("/pessoa") //Anotação para fazer o mapeamento da rota(dizer qual será a URL de acesso)
public class ExibicaoPessoa {
    
    @GetMapping //Anotação para indicar que a requisição será do tipo get
    public String teste(){
        return "Pessoa 1, Pessoa 2 ...";
    }
}
