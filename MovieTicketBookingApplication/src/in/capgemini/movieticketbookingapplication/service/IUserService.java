package in.capgemini.movieticketbookingapplication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.capgemini.movieticketbookingapplication.domain.Customer;
import in.capgemini.movieticketbookingapplication.domain.User;
/**
 * This interface has all the methods implementing the business logic
 * @author Prashant
 *
 */
@Service
public interface IUserService {
	/**
	 * This method will add a User
	 * @param user
	 * @return
	 */
	public User addNewUser(User user);
	/**
	 * This method will sign in a user
	 * @param user
	 */
	public User signIn(User user);
	/**
	 * This method will sign out a user
	 * @param user
	 */
	public User signOut(User user);

}
