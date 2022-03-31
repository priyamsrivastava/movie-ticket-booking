package in.cpg.screenmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.cpg.screenmanagement.domain.Screen;
import in.cpg.screenmanagement.domain.ShowsOnScreen;

@Repository
public interface ScreenRepository extends CrudRepository<ShowsOnScreen, Long> {

	Screen findByShowName(String showName);

	Screen save(Screen screen);
	
}
