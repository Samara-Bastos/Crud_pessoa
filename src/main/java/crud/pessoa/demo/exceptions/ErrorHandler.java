package crud.pessoa.demo.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(NotFoundPessoaException.class)
    public ResponseEntity<String> handleErrorNotFoundPessoaException(NotFoundPessoaException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(NotFoundEnderecoException.class)
    public ResponseEntity<String> handleErrorNotFoundEnderecoException(NotFoundEnderecoException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(FindPessoaException.class)
    public ResponseEntity<String> handleErrorFindPessoaException(FindPessoaException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
