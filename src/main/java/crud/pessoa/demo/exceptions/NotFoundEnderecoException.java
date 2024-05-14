package crud.pessoa.demo.exceptions;

public class NotFoundEnderecoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public NotFoundEnderecoException(String ex) {
        super(ex);
    }
}
