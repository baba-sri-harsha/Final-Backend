package com.payingguest.Exceptions;

import java.util.*;

import com.payingguest.model.ApiErrors;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.*;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Method not allowed");
        String error= ex.getMessage();
        List<String> messages= Arrays.asList(error,"Method not supported");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","Media type not Supported");
        String error= ex.getMessage();
        List<String> messages= Arrays.asList(error,"Invalid Media type");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);

    }


    @Override
    protected ResponseEntity<Object> handleMissingPathVariable(MissingPathVariableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc","path variable is missing");
        String error= ex.getMessage();
        List<String> messages= Arrays.asList(error,"Missing Path variable");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);

    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc" , "request param is missing");
        String error=ex.getMessage();
        List<String>  messages= Arrays.asList(error, "Missing request params");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @Override
    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        headers.add("desc" , "Invalid datatype");
        String error=ex.getMessage();
        List<String>  messages= Arrays.asList(error, "Invalid datatype");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),status,status.value(),error,messages);
        return ResponseEntity.status(status).headers(headers).body(apiErrors);
    }

    @ExceptionHandler(PayingGuestNotFoundException.class)
    public ResponseEntity<Object>handlePayingGuestNotFound(Exception ex){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc" , "PayingGuest Not Found");
        String error=ex.getMessage();
        List<String>  messages= Arrays.asList(error, "PayingGuest Not Found");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);

    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<Object>handleBookingNotFound(Exception ex){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc" , "Booking Not Found");
        String error=ex.getMessage();
        List<String>  messages= Arrays.asList(error, "Booking Not Found");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);

    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object>handleOther(Exception ex){
        HttpHeaders headers= new HttpHeaders();
        headers.add("desc" , "Other Exception");
        String error=ex.getMessage();
        List<String>  messages= Arrays.asList(error, "Other Exception");
        ApiErrors apiErrors= new ApiErrors(LocalDateTime.now(),HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.value(),error,messages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).headers(headers).body(apiErrors);
    }
}
