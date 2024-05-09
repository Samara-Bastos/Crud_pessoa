package crud.pessoa.demo.exceptions;

public class FindPessoaException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    
    public FindPessoaException(String ex) {
        super(ex);
    }
}