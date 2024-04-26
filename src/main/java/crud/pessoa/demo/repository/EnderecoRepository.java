package crud.pessoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import crud.pessoa.demo.models.Endereco;

//No JpaRepository <O primeiro parametro é a entidade especifica, o segundo parametro é o tipo da sua chave primaria>
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
    
}