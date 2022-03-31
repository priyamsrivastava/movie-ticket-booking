package in.capgemini.movieticketbookingapp.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.capgemini.movieticketbookingapp.domain.Seat;
import in.capgemini.movieticketbookingapp.domain.Ticket;
import in.capgemini.movieticketbookingapp.exception.SeatSequenceException;
import in.capgemini.movieticketbookingapp.exception.TicketNotFoundException;
import in.capgemini.movieticketbookingapp.repository.ISeatRepository;
import in.capgemini.movieticketbookingapp.repository.ITicketRepository;
import in.capgemini.movieticketbookingapp.service.ISeatService;

@Service
public class SeatServiceImpl implements ISeatService {

	@Autowired
	private ITicketRepository ticketRepository;
	@Autowired
	private ISeatRepository seatRepository;

	@Override
	public Seat bookSeat(String ticketIdentifier, Seat seat) {
		try {

			Ticket ticket = ticketRepository.findByTicketIdentifier(ticketIdentifier.toUpperCase());
			seat.setTicket(ticket);
			Integer ticketSequence = ticket.getTSequence();
			ticketSequence++;
			ticket.setTSequence(ticketSequence);
			seat.setSeatSequence(ticketIdentifier + "-" + ticketSequence);
			if (seat.getType().equalsIgnoreCase("gold")) {
				seat.setPrice(400.0);
			}
			if (seat.getType().equalsIgnoreCase("silver")) {
				seat.setPrice(200.0);
			}
			if (seat.getType().equalsIgnoreCase("basic")) {
				seat.setPrice(100.0);
			}
			seat.getTicket().setBookingStatus(true);
			int seatCount=ticket.getNoOfSeats();
			seatCount++;
			ticket.setNoOfSeats(seatCount);
			ticket.getTicketBooking().setTotalCost(ticket.getTicketBooking().getTotalCost()+seat.getPrice());
			seat.getTicket().getTicketBooking().setTransactionStatus("Paid");
			seat.setTicketIdentifier(ticketIdentifier);
			return seatRepository.save(seat);

		} catch (Exception ex) {
			throw new TicketNotFoundException("Ticket Not Found");
		}
	}

	@Override
	public void cancelSeatBooking(Seat seat) {
		Seat s = seatRepository.findBySeatSequence(seat.getSeatSequence());
		if (s == null) {
			throw new TicketNotFoundException("No tickets found");
		} else {
			Ticket ticket = s.getTicket();
			ticket.setNoOfSeats(ticket.getNoOfSeats()-1);
			ticket.getTicketBooking().setTotalCost(ticket.getTicketBooking().getTotalCost()-s.getPrice());
			List<Seat> seats = ticket.getSeatNumber();
			seats.remove(s);
			ticketRepository.save(ticket);
			seatRepository.delete(s);
		}

	}

	@Override
	public Seat blockSeat(Seat seat) {
		return seatRepository.save(seat);
	}
	
	@Override
	public Iterable<Seat> getAllSeats(){
		return seatRepository.findAll();
	}
	
	@Override
	public List<Seat> findByTicketIdentifier(String ticketIdentifier) {
		Iterable<Seat> seats=seatRepository.findAll();
		List<Seat> foundList=new ArrayList<>();
		for(Seat seat:seats) {
			if(seat.getTicketIdentifier().equalsIgnoreCase(ticketIdentifier))
				foundList.add(seat);
		}
		return foundList;
	}

	@Override
	public Seat update(String seatSequence, Seat updatedSeat) {
		Seat seat=seatRepository.findBySeatSequence(seatSequence);
		if(seat==null)
			throw new SeatSequenceException("No seat found with the sequence :"+seatSequence);
		else {
			seat.setSeatNumber(updatedSeat.getSeatNumber());
			seat.getTicket().getTicketBooking().setTotalCost(seat.getTicket().getTicketBooking().getTotalCost()-seat.getPrice());
			if(updatedSeat.getType().equalsIgnoreCase("basic")) {
				seat.setPrice(100);
			}
			if(updatedSeat.getType().equalsIgnoreCase("silver")) {
				seat.setPrice(200);
			}
			if(updatedSeat.getType().equalsIgnoreCase("gold")) {
				seat.setPrice(400);
			}
			seat.getTicket().getTicketBooking().setTotalCost(seat.getTicket().getTicketBooking().getTotalCost()+seat.getPrice());
			return seatRepository.save(seat);
		}
		
	}

}
