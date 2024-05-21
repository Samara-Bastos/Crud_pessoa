package crud.pessoa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;

import java.util.Optional;

import crud.pessoa.demo.dto.EnderecoAtualizaDTO;
import crud.pessoa.demo.dto.EnderecoDTO;
import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.dto.PessoaListDTO;
import crud.pessoa.demo.exceptions.NotFoundEnderecoException;
import crud.pessoa.demo.exceptions.NotFoundPessoaException;
import crud.pessoa.demo.exceptions.NotFoundPessoaException;
import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.EnderecoRepository;
import crud.pessoa.demo.repository.PessoaRepository;
import crud.pessoa.demo.services.EnderecoServiceImpl;
import crud.pessoa.demo.services.PessoaServiceImpl;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import static org.mockito.ArgumentMatchers.any;


@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTest {
    
    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private PessoaServiceImpl pessoaService;

    @InjectMocks
    private EnderecoServiceImpl enderecoService;

    private EnderecoDTO enderecoDTO;

    private EnderecoAtualizaDTO enderecoAtualizaDTO;
    
    private Pessoa pessoa;

    private Endereco endereco;

    private List<Endereco> enderecos = new ArrayList<>();

    @BeforeEach
    void setup(){

        pessoa = new Pessoa("Aurora", LocalDate.of(2004,05,14), "37491502814");

        endereco = new Endereco("Rua das dores", 10, "Bairro Jardins", "Cidade São Paulo", "Estado São Paulo", "36011233",pessoa, true);

        enderecoDTO = mock(EnderecoDTO.class);

        enderecoAtualizaDTO = mock(EnderecoAtualizaDTO.class);

    }


    @Test
    @DisplayName("Deve inserir um endereço no banco")
    void create() {

        when(pessoaService.findByPessoaCpf(anyString())).thenReturn(Optional.of(pessoa));
        when(enderecoRepository.save(ArgumentMatchers.any(Endereco.class))).thenReturn(endereco);

        Endereco enderecoCriado = enderecoService.create(enderecoDTO, pessoa.getCpf());

        assertNotNull(enderecoCriado.getCpf_pessoa());
        assertEquals("Rua das dores", enderecoCriado.getRua());
        assertEquals("36011233", enderecoCriado.getCep());
    }

    @Test
    @DisplayName("Tenta inserir um endereço, mas vai cair na exceção")
    void createEnderecoException() {

        when(pessoaService.findByPessoaCpf(anyString())).thenReturn(Optional.empty());

        assertThrows(NotFoundPessoaException.class, () -> enderecoService.create(enderecoDTO, pessoa.getCpf()));
    }

    
    @Test
    @DisplayName("Deve permitir a atualização dos dados do endereço")
    void update() {
        enderecos.add(endereco);

        when(enderecoRepository.findByEnderecoCpfPessoa(anyString())).thenReturn(enderecos);
        when(enderecoRepository.save(ArgumentMatchers.any(Endereco.class))).thenReturn(endereco);
        when(enderecoAtualizaDTO.rua()).thenReturn("Rua Teste");

        Endereco enderecoAtualizado = enderecoService.update(enderecoAtualizaDTO, pessoa.getCpf());

        assertNotNull(enderecoAtualizado);
        assertEquals("Rua Teste", enderecoAtualizado.getRua());
    }

    @Test
    @DisplayName("Tenta atualizar um endereço, mas vai cair na exceção")
    void updateEnderecoException() {
        when(enderecoRepository.findByEnderecoCpfPessoa(anyString())).thenReturn(enderecos);
        
        assertThrows(NotFoundEnderecoException.class, () -> {
            
            List<Endereco> enderecos = enderecoRepository.findByEnderecoCpfPessoa(pessoa.getCpf());

            if (!enderecos.isEmpty()) {
                enderecoService.update(enderecoAtualizaDTO,pessoa.getCpf());
            } else {
                throw new NotFoundEnderecoException("Endereço não encontrado");
            }
        }); 
    }

    @Test
    @DisplayName("Deve permitir a exclusão do endereço")
    void delete() {
        enderecos.add(endereco);

        Endereco enderecoExcluido = enderecos.get(0);
        enderecoRepository.delete(enderecoExcluido);

        verify(enderecoRepository, times(1)).delete(enderecoExcluido);
    }

    @Test
    @DisplayName("Tenta excluir um endereço, mas vai cair na exceção")
    void deleteEnderecoException() {
        when(enderecoRepository.findByEnderecoCpfPessoa(anyString())).thenReturn(enderecos);
        
        assertThrows(NotFoundEnderecoException.class, () -> {
            
            List<Endereco> enderecos = enderecoRepository.findByEnderecoCpfPessoa(pessoa.getCpf());

            if (enderecos.size() == 0) {
                throw new NotFoundEnderecoException("Endereço não encontrado");
            } else {
                Endereco enderecoExcluido = enderecos.get(0);
                enderecoRepository.delete(enderecoExcluido);
            }
        });
    }
}
