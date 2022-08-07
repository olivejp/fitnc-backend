package nc.deveo.fitncbackend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice(basePackages = "nc.deveo.fitncbackend.controller")
public class ErrorHandlerRestController {

    public static final int BAD_REQUEST_STATUS_CODE = 400;
    public static final String ERROR = "error";

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Map<String, String> handleNoRequestBodyExceptions(HttpMessageNotReadableException ex) {
        var errors = new HashMap<String, String>();
        errors.put(ERROR, "Le corps de la requête est soit incorrecte soit vide.");
        return errors;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public Map<String, Object> handleServiceExceptions(NotFoundException ex) {
        var errors = new HashMap<String, Object>();
        errors.put(ERROR, ex.getMessage());
        errors.put("status", BAD_REQUEST_STATUS_CODE);
        errors.put("trace", ex.getStackTrace());
        errors.put("type", ex.getClass());
        return errors;
    }
}

