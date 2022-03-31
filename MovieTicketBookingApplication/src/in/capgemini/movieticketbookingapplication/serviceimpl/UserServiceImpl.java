package in.capgemini.movieticketbookingapplication.serviceimpl;

import in.capgemini.movieticketbookingapplication.domain.User;
import in.capgemini.movieticketbookingapplication.exception.UserIdException;
import in.capgemini.movieticketbookingapplication.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Override
	public User addNewUser(User user) {
		// TODO Auto-generated method stub
		
		try {
			customer.setUserId(booking.getUserId().toUpperCase());
			User user = new user();
			customer.setuser(user);
			
			

			return userRepository.save(user);
		} catch (Exception ex) {
			throw new UserIdException(
					"User Id: " + user.getUserId().toUpperCase() + " already exists");
		}

		
	}

	@Override
	public User signIn(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User signOut(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
