/*
 * package com.blogging_application.blog.exceptions; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.ExceptionHandler; import
 * org.springframework.web.bind.annotation.RestControllerAdvice; import
 * com.blogging.application.blog.model.BlogApiResponse;
 * 
 * 
 * //This is a global level exception class, managed by spring itself. //Just we
 * have to make the types of the exception classes, and then pass then name of
 * those exception classes in the @ExceptionalHandler
 * 
 * @RestControllerAdvice public class BlogAppGlobalExceptionHandler {
 * 
 * //Type1 --->Resource Not Found Exception.
 * 
 * @ExceptionHandler(ResourceNotFoundException.class)
 * 
 * public ResponseEntity<BlogApiResponse<String>>resourceNotFoundException(
 * ResourceNotFoundException ex){
 * 
 * BlogApiResponse<String> blogApiResponse = new BlogApiResponse<String>();
 * blogApiResponse.setMessage(ex.getMessage());
 * blogApiResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
 * blogApiResponse.setData("Resource not found!!"); return new
 * ResponseEntity<BlogApiResponse<String>>(blogApiResponse,HttpStatus.NOT_FOUND)
 * ; }
 * 
 * }
 */