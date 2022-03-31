package in.capgemini.movieticketbookingapplication.repository;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capgemini.movieticketbookingapplication.domain.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer,Integer>{
	public Customer addcustomer(Customer customer);
	public Customer updatecustomer(Customer customer);
	public void cancelcustomer(Customer customer);
	public List<Customer> showAllcustomer(int movieId);
	public List<Customer> showcustomer(int showId);
	public Customer findByCustomerIdentifier(String customerIdentifier);
	public Iterable<Customer> findAllByDate(LocalDate date);

}
