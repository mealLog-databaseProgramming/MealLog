package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.FeedDTO;
import model.service.FeedManager;

public class HomeController implements Controller {

	FeedManager feedManager = new FeedManager();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
//		List<FeedDTO> feedList = new ArrayList<FeedDTO>();
//		feedList = feedManager.read();
//		request.setAttribute("feedList", feedList);
		request.setAttribute("page", "home/home.jsp");
		return "/index.jsp";
	}

}
