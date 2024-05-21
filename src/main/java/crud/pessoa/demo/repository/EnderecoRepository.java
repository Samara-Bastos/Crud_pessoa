package crud.pessoa.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT e FROM Endereco e WHERE e.cpf_pessoa.cpf = :cpf")
    List<Endereco> findByEnderecoCpfPessoa(@Param("cpf") String cpf);
    
}