package in.capgemini.movieticketbookingapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capgemini.movieticketbookingapp.domain.Ticket;
/**
 * This interface extends CrudRepository to implement the crud functions related to the Ticket class
 * @author Provanjan
 *
 */
@Repository
public interface ITicketRepository extends CrudRepository<Ticket,Integer>{
	Ticket findByTicketIdentifier(String ticketIdentifier);
}
