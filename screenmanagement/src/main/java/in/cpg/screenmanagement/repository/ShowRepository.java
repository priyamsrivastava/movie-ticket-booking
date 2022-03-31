package in.cpg.screenmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import in.cpg.screenmanagement.domain.ShowsOnScreen;

@Repository
public interface ShowRepository extends CrudRepository<ShowsOnScreen, Long>{

	// TODO : 

	ShowsOnScreen findByShowName(String showName);
	
	List<ShowsOnScreen> findByTheatreId(int theatreId);
	
}

