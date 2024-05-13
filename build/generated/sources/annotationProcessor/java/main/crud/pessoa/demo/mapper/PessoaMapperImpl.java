package crud.pessoa.demo.mapper;

import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.models.Pessoa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T14:05:26-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class PessoaMapperImpl implements PessoaMapper {

    @Override
    public PessoaDTO pessoaToDTO(Pessoa pessoa) {
        if ( pessoa == null ) {
            return null;
        }

        String nome = null;
        String nascimento = null;
        String cpf = null;

        nome = pessoa.getNome();
        if ( pessoa.getNascimento() != null ) {
            nascimento = DateTimeFormatter.ISO_LOCAL_DATE.format( pessoa.getNascimento() );
        }
        cpf = pessoa.getCpf();

        PessoaDTO pessoaDTO = new PessoaDTO( nome, nascimento, cpf );

        return pessoaDTO;
    }

    @Override
    public Pessoa dtoToPessoa(PessoaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pessoa pessoa = new Pessoa();

        pessoa.setNome( dto.nome() );
        if ( dto.nascimento() != null ) {
            pessoa.setNascimento( LocalDate.parse( dto.nascimento() ) );
        }
        pessoa.setCpf( dto.cpf() );

        return pessoa;
    }
}
