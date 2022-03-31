package in.capgemini.movieticketbookingapp.web;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.capgemini.movieticketbookingapp.domain.TicketBooking;
import in.capgemini.movieticketbookingapp.service.IBookingService;
import in.capgemini.movieticketbookingapp.serviceimpl.MapValidationErrorService;

@RestController
@RequestMapping("/api/ticketbooking")
public class TicketBookingController {

	@Autowired
	private IBookingService bookingService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("")
	public ResponseEntity<?> createNewBooking(@Valid @RequestBody TicketBooking booking,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		TicketBooking ticket=bookingService.addBooking(booking);
		return new ResponseEntity<TicketBooking> (ticket,HttpStatus.CREATED);
	}
	
	@PatchMapping("/update/{ticketIdentifier}")
	public ResponseEntity<?> updateBooking(@Valid @RequestBody TicketBooking booking,@PathVariable String ticketIdentifier,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		TicketBooking updatedBooking=bookingService.updateBooking(booking,ticketIdentifier);
		return new ResponseEntity<TicketBooking>(updatedBooking,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{ticketIdentifier}")
	public ResponseEntity<?> deleteBooking(@PathVariable String ticketIdentifier,@RequestBody TicketBooking booking){
		bookingService.cancelBooking(booking);
		return new ResponseEntity<String>("Ticket with the identifier "+booking.getTicketIdentifier().toUpperCase()+" Deleted successfully",HttpStatus.OK);
	}
	
	@GetMapping("/movie/{movieId}")
	public List<TicketBooking> getByMovieId(@PathVariable int movieId){
		return bookingService.showBookingByMovieId(movieId);
	}
	
	@GetMapping("/show/{showId}")
	public List<TicketBooking> getByShowId(@PathVariable int showId){
		return bookingService.showBooking(showId);	
	}
	
	@GetMapping("/{date}")
	public Iterable<TicketBooking> getByDate(@PathVariable String date){
		LocalDate dt=LocalDate.parse(date);
		return bookingService.showAllBooking(dt);
	}
	
	@GetMapping("/cost/{ticketIdentifier}")
	public ResponseEntity<?> getTotalCost(@PathVariable String ticketIdentifier) {
		double cost=bookingService.calculateTotalCost(ticketIdentifier);
		return new ResponseEntity<Double>(cost,HttpStatus.OK);
	}
}
