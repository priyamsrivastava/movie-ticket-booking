package in.capgemini.movieticketbookingapp.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capgemini.movieticketbookingapp.domain.TicketBooking;
/**
 * This interface extends CrudRepository and performs all the crud operations pertaining to the TicketBooking class
 * @author Provanjan
 *
 */
@Repository
public interface IBookingRepository extends CrudRepository<TicketBooking,Integer>{
//	public TicketBooking addBooking(TicketBooking booking);
//	public TicketBooking updateBooking(TicketBooking booking);
//	public void cancelBooking(TicketBooking booking);
//	public List<TicketBooking> showAllBooking(int movieId);
//	public List<TicketBooking> showAllBooking(LocalDate date);
//	public List<TicketBooking> showBooking(int showId);
//	public double calculateTotalCost(String ticketIdentifier);	
//	public Iterable<TicketBooking> findAllByDate(LocalDate date);
	TicketBooking findByTicketIdentifier(String ticketIdentifier);
}
