package crud.pessoa.demo.exceptions;

public class CreatePessoaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public CreatePessoaException(String ex) {
        super(ex);
    }
}
