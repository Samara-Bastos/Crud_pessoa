package crud.pessoa.demo.exceptions;

public class NotFoundPessoaException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public NotFoundPessoaException(String ex) {
        super(ex);
    }
}
