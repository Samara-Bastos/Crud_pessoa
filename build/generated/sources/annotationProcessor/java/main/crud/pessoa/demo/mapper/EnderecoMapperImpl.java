package crud.pessoa.demo.mapper;

import crud.pessoa.demo.dto.EnderecoAtualizaDTO;
import crud.pessoa.demo.dto.EnderecoDTO;
import crud.pessoa.demo.models.Endereco;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T14:05:26-0300",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoDTO enderecoToDTO(Endereco endereco) {
        if ( endereco == null ) {
            return null;
        }

        String rua = null;
        Integer numero = null;
        String bairro = null;
        String cidade = null;
        String estado = null;
        String cep = null;
        boolean principal = false;

        rua = endereco.getRua();
        numero = endereco.getNumero();
        bairro = endereco.getBairro();
        cidade = endereco.getCidade();
        estado = endereco.getEstado();
        cep = endereco.getCep();
        principal = endereco.isPrincipal();

        String cpf_pessoa = null;

        EnderecoDTO enderecoDTO = new EnderecoDTO( rua, numero, bairro, cidade, estado, cep, cpf_pessoa, principal );

        return enderecoDTO;
    }

    @Override
    public Endereco dtoToEndereco(EnderecoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setRua( dto.rua() );
        if ( dto.numero() != null ) {
            endereco.setNumero( dto.numero() );
        }
        endereco.setBairro( dto.bairro() );
        endereco.setCidade( dto.cidade() );
        endereco.setEstado( dto.estado() );
        endereco.setCep( dto.cep() );
        endereco.setPrincipal( dto.principal() );

        return endereco;
    }

    @Override
    public Endereco dtoAtualizaToEndereco(EnderecoAtualizaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setRua( dto.rua() );
        if ( dto.numero() != null ) {
            endereco.setNumero( dto.numero() );
        }
        endereco.setBairro( dto.bairro() );
        endereco.setCidade( dto.cidade() );
        endereco.setEstado( dto.estado() );
        endereco.setCep( dto.cep() );
        endereco.setPrincipal( dto.principal() );

        return endereco;
    }
}
