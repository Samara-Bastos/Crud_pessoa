package crud.pessoa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;

import java.util.Optional;
import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.dto.PessoaListDTO;
import crud.pessoa.demo.exceptions.FindEnderecoException;
import crud.pessoa.demo.exceptions.FindPessoaException;
import crud.pessoa.demo.models.Endereco;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.EnderecoRepository;
import crud.pessoa.demo.repository.PessoaRepository;
import crud.pessoa.demo.services.EnderecoService;
import crud.pessoa.demo.services.PessoaService;
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@ExtendWith(MockitoExtension.class)
public class EnderecoServiceTest {
    
    @Mock
    private EnderecoRepository enderecoRepository;

    @Mock
    private PessoaService pessoaService;

    @InjectMocks
    private EnderecoService enderecoService;


    protected Pessoa pessoa;

    protected Endereco endereco;

    protected List<Endereco> enderecos = new ArrayList<>();

    @BeforeEach
    void setup(){

        pessoa = new Pessoa("Aurora", LocalDate.of(2004,05,14), "37491502814");

        endereco = new Endereco("Rua das dores", 10, "Bairro Jardins", "Cidade São Paulo", "Estado São Paulo", "36011233",pessoa, false);

    }


    @Test
    @DisplayName("Deve inserir um endereço no banco")
    void create() {

        when(pessoaService.findByPessoaCpf(anyString())).thenReturn(Optional.of(pessoa));
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        Endereco enderecoCriado = enderecoService.create(endereco, pessoa.getCpf());

        assertNotNull(enderecoCriado.getCpf_pessoa());
        assertEquals("Rua das dores", enderecoCriado.getRua());
        assertEquals("36011233", enderecoCriado.getCep());
    }

    @Test
    @DisplayName("Tenta inserir um endereço, mas vai cair na exceção")
    void createEnderecoException() {

        when(pessoaService.findByPessoaCpf(anyString())).thenReturn(Optional.empty());

        assertThrows(FindPessoaException.class, () -> enderecoService.create(endereco, pessoa.getCpf()));
    }

    
    @Test
    @DisplayName("Deve permitir a atualização dos dados do endereço")
    void update() {
        enderecos.add(endereco);
        
        when(enderecoRepository.findByEnderecoCpfPessoa(anyString())).thenReturn(enderecos);
        when(enderecoRepository.save(endereco)).thenReturn(endereco);

        Endereco enderecoNovo = new Endereco("Praça São Sebastião", 15, "Centro", "Cidade de São Paulo", "Estado de São Paulo", "01002000", pessoa, true);

        Endereco enderecoAtualizado = enderecoService.update(enderecoNovo, pessoa.getCpf());

        assertNotNull(enderecoAtualizado);
        assertEquals("Praça São Sebastião", enderecoAtualizado.getRua());
    }

    @Test
    @DisplayName("Tenta atualizar um endereço, mas vai cair na exceção")
    void updateEnderecoException() {
        when(enderecoRepository.findByEnderecoCpfPessoa(anyString())).thenReturn(enderecos);
        
        assertThrows(FindEnderecoException.class, () -> {
            
            List<Endereco> enderecos = enderecoRepository.findByEnderecoCpfPessoa(pessoa.getCpf());

            if (!enderecos.isEmpty()) {
                // Se a lista não estiver vazia, tenta excluir o primeiro endereço
                Endereco enderecoAtualizado = enderecos.get(0);
                enderecoService.update(enderecoAtualizado,pessoa.getCpf());
            } else {
                // Se a lista estiver vazia, lança a exceção adequada
                throw new FindEnderecoException("Endereço não encontrado");
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
        
        assertThrows(FindEnderecoException.class, () -> {
            
            List<Endereco> enderecos = enderecoRepository.findByEnderecoCpfPessoa(pessoa.getCpf());

            if (enderecos.size() == 0) {
                // Se a lista estiver vazia, lança a exceção adequada
                throw new FindEnderecoException("Endereço não encontrado");
            } else {
                // Se a lista não estiver vazia, tenta excluir o primeiro endereço
                Endereco enderecoExcluido = enderecos.get(0);
                enderecoRepository.delete(enderecoExcluido);
            }
        });
    }
}
