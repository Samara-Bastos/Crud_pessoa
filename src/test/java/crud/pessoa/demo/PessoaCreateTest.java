package crud.pessoa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import crud.pessoa.demo.dto.PessoaDTO;
import crud.pessoa.demo.models.Pessoa;
import crud.pessoa.demo.repository.PessoaRepository;
import crud.pessoa.demo.services.PessoaService;


@ExtendWith(MockitoExtension.class)
public class PessoaCreateTest {
    
    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    private Pessoa pessoa;

    @BeforeEach
    public void personSetup() {
        pessoa = new Pessoa("Aurora", "20040514", "37491502814");
    }

    @Test
    @DisplayName("Deve inserir pessoa no banco")
    void createPerson() {
        when(pessoaRepository.findByCpf(anyString())).thenReturn(Optional.empty());
        when((pessoaRepository.save(pessoa))).thenReturn(pessoa);

        Pessoa pessoaCriada = pessoaService.create(pessoa);

        assertEquals(pessoaCriada.getNome(), "Aurora");
        assertEquals(pessoaCriada.getNascimento(), "20040514");
        assertEquals(pessoaCriada.getCpf(), "37491502814");
    }
}