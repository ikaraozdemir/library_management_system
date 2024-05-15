package com.patika.cohort3.library.exception;

import com.patika.cohort3.library.exception.NotFoundException;
import com.patika.cohort3.library.result.Result;
import com.patika.cohort3.library.result.ResultData;
import com.patika.cohort3.library.utilities.ResultHelper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Result> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(ResultHelper.notFoundError(e.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CategoryAlreadyExistsException.class})
    public ResponseEntity<Result> handleCategoryAlreadyExistsException(CategoryAlreadyExistsException e) {

        return new ResponseEntity<>(ResultHelper.alreadyExist(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({PublisherAlreadyExistsException.class})
    public ResponseEntity<Result> handlePublisherAlreadyExistsException(PublisherAlreadyExistsException e) {

        return new ResponseEntity<>(ResultHelper.alreadyExist(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BookAlreadyExistsException.class})
    public ResponseEntity<Result> handleBookAlreadyExistsException(BookAlreadyExistsException e) {

        return new ResponseEntity<>(ResultHelper.alreadyExist(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({AuthorAlreadyExistsException.class})
    public ResponseEntity<Result> handleAuthorAlreadyExistsException(AuthorAlreadyExistsException e) {

        return new ResponseEntity<>(ResultHelper.alreadyExist(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResultData<List<String>>> handleValidationErrors(MethodArgumentNotValidException e) {
        List<String> validationErrorList = e.getBindingResult().getFieldErrors().stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.toList());

        return new ResponseEntity<>(ResultHelper.validateError(validationErrorList), HttpStatus.BAD_REQUEST);
    }

}
