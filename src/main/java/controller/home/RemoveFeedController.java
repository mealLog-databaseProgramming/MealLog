package controller.home;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.FeedManager;

public class RemoveFeedController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		long feedId = (long) request.getAttribute("feedId");
//		System.out.println("Controller" + feedId);
//		
//		FeedManager manager = FeedManager.getInstance();
//				
//		manager.remove(feedId);
		System.out.println("Remove Feed Controller Test");
		
		return "redirect:/";
	}
}
