package in.cpg.screenmanagement.service;

import java.util.List;

import in.cpg.screenmanagement.domain.ShowsOnScreen;

public interface ShowService {
	
	public ShowsOnScreen saveOrUpdate(ShowsOnScreen show);
	
	public ShowsOnScreen findShowByShowName(String showName);
	
	public List<ShowsOnScreen> findShowByTheatreId(int theatreId);
	
	public Iterable<ShowsOnScreen> findAllShows();
	
	public void deleteShowByShowName(String showName);
	
}

