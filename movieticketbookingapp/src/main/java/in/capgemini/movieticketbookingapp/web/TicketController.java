package in.capgemini.movieticketbookingapp.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
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

import in.capgemini.movieticketbookingapp.service.ISeatService;
import in.capgemini.movieticketbookingapp.serviceimpl.MapValidationErrorService;
import in.capgemini.movieticketbookingapp.domain.Seat;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

	@Autowired
	private ISeatService seatService;
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	
	@PostMapping("/{ticket_id}")
	public ResponseEntity<?> addSeatToTicket(@Valid @RequestBody Seat seat, BindingResult result,@PathVariable String ticket_id){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null) return errorMap;
		seatService.bookSeat(ticket_id, seat);
					
		return new ResponseEntity<String> ("Ticket confirmed",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{ticketIdentifier}/{seatSequence}")
	public ResponseEntity<?> deleteSeat(@PathVariable String ticketIdentifier,@PathVariable String seatSequence,Seat seat){
		seatService.cancelSeatBooking(seat);
		return new ResponseEntity<String> ("Seat has been canceled successfully !",HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public Iterable<Seat> getAllSeats(){
		return seatService.getAllSeats();
	}
	
	@GetMapping("/ticketIdentity/{ticketIdentifier}")
	public List<Seat> findByTicketIdentifier(@PathVariable String ticketIdentifier) {
		return seatService.findByTicketIdentifier(ticketIdentifier);
	}
	
	@PatchMapping("/update/{seatSequence}")
	public ResponseEntity<?> updateSeat(@Valid @PathVariable String seatSequence,@RequestBody Seat seat,BindingResult result){
		ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
		if(errorMap!=null)return errorMap;
		seatService.update(seatSequence,seat);
		return new ResponseEntity<String>("Seat details updated !",HttpStatus.CREATED);
	}
}
