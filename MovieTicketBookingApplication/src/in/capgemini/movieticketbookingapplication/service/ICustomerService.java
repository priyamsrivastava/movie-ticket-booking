package in.capgemini.movieticketbookingapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.capgemini.movieticketbookingapplication.domain.Customer;
/**
 * This interface has all the methods implementing the business logic
 * @author Prashant
 *
 */
@Service
public interface ICustomerService {
	/**
	 * This method will add a customer
	 * @param customer
	 * @return
	 */
	public Customer addCustomer(Customer customer);
	/**
	 * This method will update an existing booking 
	 * @param customer
	 * @param customerId
	 * @return
	 */
	public Customer updateCustomer(Customer customer,int customerId);
	/**
	 * This method will delete Customer
	 * @param customer
	 */
	public void deleteCustomer(Customer customer);
	/**
	 * This method will view customer by customer id
	 * @param customerId
	 * @return
	 */
	public List<Customer> viewCustomer(int customerId);
	
	
	
}
