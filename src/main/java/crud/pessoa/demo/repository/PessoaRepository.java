package crud.pessoa.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import crud.pessoa.demo.models.Pessoa;
import java.util.Optional;

//No JpaRepository <O primeiro parametro é a entidade especifica, o segundo parametro é o tipo da sua chave primaria>
@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    
    Optional<Pessoa> findByCpf(String cpf);
}
