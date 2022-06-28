package daikfd.projects.goalsapp.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javassist.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleUserNotFoundException(NotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@Override
	@NonNull
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex
			,@NonNull  HttpHeaders headers,@NonNull  HttpStatus status,@NonNull  WebRequest request) {
		Map<String, String> errors = new HashMap<>();

		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			errors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		String getFormatErrorResponseMessage = String.valueOf(errors.values()).
				substring(1, String.valueOf(errors.values()).length() - 1);
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), getFormatErrorResponseMessage,
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,headers, HttpStatus.BAD_REQUEST);
	}

//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public ResponseEntity<ExceptionResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, WebRequest request) {
//
//	}
}