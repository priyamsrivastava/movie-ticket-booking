package in.cpg.screenmanagement.serviceimpl;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import in.cpg.screenmanagement.domain.Screen;
import in.cpg.screenmanagement.domain.ShowsOnScreen;
import in.cpg.screenmanagement.exception.ShowNameException;
import in.cpg.screenmanagement.repository.ScreenRepository;
import in.cpg.screenmanagement.repository.ShowRepository;
import in.cpg.screenmanagement.service.ShowService;

/**
 * We write these annotations so that our beans must understand that it is a Service layer.
 * @author PRIYAM
 *
 */
@Service
public class ShowServiceImpl implements ShowService{

	@Autowired
	private ShowRepository showRepository;
	
	
	
	
	@Override
	public ShowsOnScreen saveOrUpdate(ShowsOnScreen show) {
		//Biz logic.
		/**
		 * 1. When screen is created, show must be created.
		 * 2 When screen is updated, show must not be null.
		 * 
		 */
		try {
			
			
//			// 1. When screen is created, show must be created.
//			if(show.getId() == null) {
//				Screen screen = new Screen();
//				
////				screen.setShowList(show);
//			}
//			// 2 When screen is updated, show must not be null.
//			if(show.getId() != null) {
//				
//			}
			
			return showRepository.save(show);
		}
		catch (Exception ex) {
			throw new ShowNameException("Show Name already exists with name : " + show.getShowName());
		}
		
	}

	@Override
	public ShowsOnScreen findShowByShowName(String showName) {
		ShowsOnScreen show = showRepository.findByShowName(showName);
		if(show == null) {
			throw new ShowNameException("Show Name not available with name : " + showName);
		}
		return show;
	}
	
	@Override
	public List<ShowsOnScreen> findShowByTheatreId(int theatreId) {
		
		List<ShowsOnScreen> list =  showRepository.findByTheatreId(theatreId);
		return list;
	}


	@Override
	public Iterable<ShowsOnScreen> findAllShows() {
		return showRepository.findAll();
	}


	@Override
	public void deleteShowByShowName(String showName) {
		ShowsOnScreen show = showRepository.findByShowName(showName);
		if(show == null) {
			throw new ShowNameException("Show Name not available with name : " + showName);
		}
		showRepository.delete(show);		
	}
	
}
