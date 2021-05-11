package ua.kpi.tef.controller;

import com.vaadin.flow.router.NotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ValidationException;

import ua.kpi.tef.exception.DepartmentExistsException;
import ua.kpi.tef.exception.ProfessorNotFountException;
import ua.kpi.tef.exception.SubjectNotFountException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = ValidationException.class)
    protected ResponseEntity<Object> handleValidation(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.PRECONDITION_FAILED, request);
    }

    @ExceptionHandler(value = {NotFoundException.class, ProfessorNotFountException.class,
            SubjectNotFountException.class, DepartmentExistsException.class})
    protected ResponseEntity<Object> handleNotFound(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
