package controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.FeedManager;

public class RemoveFeedController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long feedId = (long) request.getAttribute("feedId");
		FeedManager manager = FeedManager.getInstance();
				
		manager.remove(feedId);
		
		return "redirect:/";
	}
}
