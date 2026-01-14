package com.salesianos.dam.clinicflow.exceptions;

import com.salesianos.dam.clinicflow.exceptions.notFound.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ProblemDetail handleNotFoundException(NotFoundException ex) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());

        pd.setTitle("Recurso no encontrado");
        pd.setType(URI.create("about:blank"));

        return pd;
    }

    @ExceptionHandler(BadArgumentsException.class)
    public ProblemDetail handleBadArgumentsException(BadArgumentsException ex) {
        ProblemDetail pd = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());

        pd.setTitle("Argumentos inválidos");
        pd.setType(URI.create("about:blank"));

        return pd;
    }


}
