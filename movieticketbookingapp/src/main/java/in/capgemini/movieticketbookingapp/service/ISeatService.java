package in.capgemini.movieticketbookingapp.service;



import java.util.List;

import org.springframework.stereotype.Service;

import in.capgemini.movieticketbookingapp.domain.Seat;
/**
 * This interface has all the methods which implements the business logic related to Seat booking
 * @author PURNENDU
 *
 */
@Service
public interface ISeatService {
	/**
	 * This method will book a seat for the user based on the ticket Identifier
	 * @param ticketIdentifier
	 * @param seat
	 * @return
	 */
	public Seat bookSeat(String ticketIdentifier,Seat seat);
	/**
	 * This method will cancel a seat for a customer
	 * @param seat
	 */
	public void cancelSeatBooking(Seat seat);
	/**
	 * This method will block a seat a for the customer
	 * @param seat
	 * @return
	 */
	public Seat blockSeat(Seat seat);
	/**
	 * This method will return all the seats that has been booked
	 * @return
	 */
	public Iterable<Seat> getAllSeats();
	/**
	 * This method will find a list of seats based on ticketIdentifier
	 * @param ticketIdentifier
	 * @return
	 */
	public List<Seat> findByTicketIdentifier(String ticketIdentifier);
	/**
	 * This method will update details of a particular seat
	 * @param seatSequence
	 * @param seat
	 * @return
	 */
	public Seat update(String seatSequence,Seat seat);
}
