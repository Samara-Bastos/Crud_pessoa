package crud.pessoa.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;

import crud.pessoa.demo.dto.EnderecoAtualizaDTO;
import crud.pessoa.demo.dto.EnderecoDTO;
import crud.pessoa.demo.fixture.*;
import crud.pessoa.demo.repository.EnderecoRepository;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class EnderecoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private EnderecoDTO dto;

    String json;

    private EnderecoAtualizaDTO enderecoAtualizaDTO;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    ObjectMapper mapper;
    

    
    @Test
    @DisplayName("Deve ser possível criar um endereço")
    @SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = SqlProvider.insertPessoa),
        @Sql(executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD, scripts = SqlProvider.clearDB)
    })
    void cadatrarEnderecoTest() throws Exception{
        
        dto = EnderecoDTOFixture.EnderecoDTOValido();

        json = mapper.writeValueAsString(dto);

        mockMvc.perform(MockMvcRequestBuilders.post("/endereco")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.rua").value(dto.rua()));
    
    }
    
    
}
