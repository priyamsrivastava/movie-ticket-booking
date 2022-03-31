package in.capgemini.movieticketbookingapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import in.capgemini.movieticketbookingapp.exception.TicketIdException;
import in.capgemini.movieticketbookingapp.exception.TicketIdExceptionResponse;
import in.capgemini.movieticketbookingapp.exception.TicketNotFoundException;
import in.capgemini.movieticketbookingapp.exception.TicketNotFoundExceptionResponse;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler
	public final ResponseEntity<Object> handleTicketIdExceptionResponse(TicketIdException ex,WebRequest request){
		TicketIdExceptionResponse exceptionResponse=new TicketIdExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public final ResponseEntity<Object> handleTicketNotFoundException(TicketNotFoundException ex,WebRequest request){
		TicketNotFoundExceptionResponse exceptionResponse=new TicketNotFoundExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler
	public final ResponseEntity<Object> handleSeatSequenceException(SeatSequenceException ex,WebRequest request){
		SeatSequenceExceptionResponse exceptionResponse=new SeatSequenceExceptionResponse(ex.getMessage());
		return new ResponseEntity<Object>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
}
