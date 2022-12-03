package controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ClubManager;

public class RemoveFeedController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long feedTd = (long) request.getAttribute("feedTd");
		ClubManager manager = ClubManager.getInstance();
				
		manager.remove(feedTd);
		
		return "redirect:/home";
	}
}
