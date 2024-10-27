package com.blogging_application.blog.exceptions;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import com.blogging_application.blog.model.ErrorObject;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice 
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorObject> handleExpenseNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request) {
		System.out.println("GlobalExceptionHandler.handleGeneralException()");
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ItemExistsException.class)
	public ResponseEntity<ErrorObject> handleItemExistsException(ItemExistsException ex, WebRequest request) {
		
		ErrorObject errorObject = new ErrorObject();
		
		errorObject.setStatusCode(HttpStatus.CONFLICT.value());
		
		errorObject.setMessage(ex.getMessage());
		
		errorObject.setTimestamp(new Date());
		
		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.CONFLICT);
	}
	
	//This will be used for checking the validations in the Request Body of the Method
	//@ExceptionHandler(MethodArgumentNotValidException.class)
	
	/**
	 * 
	 * @param ex
	 * @param headers
	 * @param status
	 * @param request
	 * @return
	 */
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpServletRequest request) {
		
		Map<String, Object> body = new HashMap<String, Object>();
		
		body.put("statusCode", HttpStatus.BAD_REQUEST.value());
		
		
		 List<String> errors = ex.getBindingResult() .getFieldErrors() .stream()
		 .map(x -> x.getDefaultMessage()) .collect(Collectors.toList());
		 
		
		/*
		 * ex.getBindingResult().getAllErrors().forEach((error)->{ String objectName =
		 * error.getObjectName(); String message = error.getDefaultMessage();
		 * body.put(objectName, message); });
		 */
		
		body.put("messages", errors);
		
		body.put("timestamp", new Date());
		
		return new ResponseEntity<Object>(body, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(TransactionSystemException.class)
		public ResponseEntity<ErrorObject>handleTransactionSystemException(TransactionSystemException ex,HttpServletRequest request){
		ErrorObject errorObject = new ErrorObject();
	
		errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
		errorObject.setMessage(ex.getMessage());
		errorObject.setTimestamp(new Date());
		//body.put("messages", errors);
				
		return ResponseEntity.badRequest().body(errorObject);
		}
		
	}
	
