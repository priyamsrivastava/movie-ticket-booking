package in.capgemini.movieticketbookingapp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import in.capgemini.movieticketbookingapp.domain.TicketBooking;
/**
 * This interface has all the methods implementing the business logic
 * @author Provanjan
 *
 */
@Service
public interface IBookingService {
	/**
	 * This method will add a booking and implement the required business logic
	 * @param booking
	 * @return
	 */
	public TicketBooking addBooking(TicketBooking booking);
	/**
	 * This method will update an existing booking 
	 * @param booking
	 * @param ticketIdentifier
	 * @return
	 */
	public TicketBooking updateBooking(TicketBooking booking,String ticketIdentifier);
	/**
	 * This method will cancel a booking
	 * @param booking
	 */
	public void cancelBooking(TicketBooking booking);
	/**
	 * This method will display a list of bookings based on movieId
	 * @param movieId
	 * @return
	 */
	public List<TicketBooking> showBookingByMovieId(int movieId);
	/**
	 * This method will display a list of bookings based on dates of shows
	 * @param date
	 * @return
	 */
	public Iterable<TicketBooking> showAllBooking(LocalDate date);
	/**
	 * This method will display all the shows based on the showId
	 * @param showId
	 * @return
	 */
	public List<TicketBooking> showBooking(int showId);
	/**
	 * This method will display the total amount to be paid
	 * @param ticketIdentifier
	 * @return
	 */
	public double calculateTotalCost(String ticketIdentifier);
}
