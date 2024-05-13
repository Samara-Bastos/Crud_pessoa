package crud.pessoa.demo.exceptions;

public class FindEnderecoException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    
    public FindEnderecoException(String ex) {
        super(ex);
    }
}
