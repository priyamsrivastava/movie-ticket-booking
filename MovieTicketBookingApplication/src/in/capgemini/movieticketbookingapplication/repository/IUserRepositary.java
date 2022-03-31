package in.capgemini.movieticketbookingapplication.repository;

import java.util.List;
import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.capgemini.movieticketbookingapplication.domain.Customer;
import in.capgemini.movieticketbookingapplication.domain.User;

@Repository
public interface IUserRepositary extends CrudRepository<User,Integer>{
	public User adduser(User customer);
	public User findByUserId(int userId);

}
