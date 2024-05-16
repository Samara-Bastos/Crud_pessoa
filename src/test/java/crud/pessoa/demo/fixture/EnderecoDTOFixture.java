package crud.pessoa.demo.fixture;

import crud.pessoa.demo.dto.EnderecoDTO;

public class EnderecoDTOFixture {
     
    public static EnderecoDTO EnderecoDTOValido() {
        return new EnderecoDTO("Rua A", 123, "Centro", "Cidade A", "Estado A", "12345678", "12345678901", true);
    }

    public static EnderecoDTO EnderecoDTOInvalido() {
        return new EnderecoDTO("", 123, "Centro", "Cidade A", "Estado A", "12345678", "12345678901", true);
    }
}
