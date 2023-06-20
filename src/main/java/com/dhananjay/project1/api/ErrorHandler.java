package com.dhananjay.project1.api;

import com.dhananjay.project1.exception.ApplicationError;
import com.dhananjay.project1.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ApplicationError> handleCustomerNotFoundException(CustomerNotFoundException
                                                                              customerNotFoundException,
                                                                      WebRequest webRequest){
        ApplicationError applicationError = new ApplicationError();

        applicationError.setCode(404);
        applicationError.setMessage(customerNotFoundException.getMessage());
        return new ResponseEntity<>(applicationError, HttpStatus.NOT_FOUND);
    }

}
