package controller;

import java.util.ArrayList;
import java.sql.Date;
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
//		request.setAttribute("page", "home/home.jsp");
//		return "/index.jsp";
		
		List<FeedDTO> feedList = new ArrayList<FeedDTO>();
		
		Date date = new Date(0);
		FeedDTO f1 = new FeedDTO(100, 200, date, "내용1", "http1");
		FeedDTO f2 = new FeedDTO(101, 201, date, "내용2", "http2");
		FeedDTO f3 = new FeedDTO(102, 202, date, "내3", "http3");
		
		feedList.add(f1);
		feedList.add(f2);
		feedList.add(f3);
		
		request.setAttribute("feedList", feedList);
		request.setAttribute("page", "home/home.jsp");
		return "/index.jsp";
	}

}
