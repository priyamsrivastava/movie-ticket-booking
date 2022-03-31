package in.capgemini.movieticketbookingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capgemini.movieticketbookingapp.domain.Seat;

/**
 * This interface extends CrudReopository to perform all crud operations pertaining to Seat class
 * @author Provanjan
 *
 */
@Repository
public interface ISeatRepository extends CrudRepository<Seat,Integer>{
//	public Seat bookSeat(Seat seat);
//	public void cancelSeatBooking(Seat seat);
//	public Seat blockSeat(Seat seat);
	Seat findBySeatSequence(String seatSequence);
}
