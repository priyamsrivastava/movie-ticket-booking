package in.cpg.screenmanagement.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.cpg.screenmanagement.domain.Screen;
import in.cpg.screenmanagement.domain.ShowsOnScreen;
import in.cpg.screenmanagement.repository.ScreenRepository;
import in.cpg.screenmanagement.repository.ShowRepository;
import in.cpg.screenmanagement.service.ScreenService;

@Service
public class ScreenServiceImpl implements ScreenService{

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private ScreenRepository screenRepository;
	
	/**
	 * String showName, 
	 * @param showsOnScreen
	 * @return
	 */
	@Override
	public Screen addShowsOnScreen(Screen screen) {
		
		/**
		 * 
		 * Exception: Show not found.
		 * ShowsOnScreen  to  be added to a specific show , show != null, screen exists
		 * Set the screen to showsonscreen
		 * we want our projectsequence to be like Morning-001
		 * Update the screen sequence
		 * add sequence to screen
		 * initial priority when priority is null
		 * initial  status when status is null
		 * 
		 */
		
//		// 1.  ShowsOnScreen  to  be added to a specific show , show != null, screen exists
//		Screen screen = screenRepository.findByShowName(showName);
//		
//		// 2.Set the screen to showsonscreen
//		showsOnScreen.setScreen(screen);
//		
//		// 3.We want our projectsequence to be like Morning-001
//		Integer screenSequence = screen.getpTSequence();
//		
//		// 4.Update the screen sequence.
//		screenSequence++;
//		
//		// 5.Add sequence to showsonscreen
//		showsOnScreen.setScreenSequence(showName + "-" + screenSequence);
//		
//		//6. Initial priority when priority is null.
//		if(showsOnScreen.getPriority() == null) {
//			showsOnScreen.setPriority(3);
//		}
//		
//		//7. Initial  status when status is null
//		if(showsOnScreen.getStatus() == null) {
//			showsOnScreen.setStatus("TODO: ");
//		}
		
		return screenRepository.save(screen);
	}
	
}
