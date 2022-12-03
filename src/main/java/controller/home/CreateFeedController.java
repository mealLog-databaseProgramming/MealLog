package controller.home;


import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.FeedManager;
import model.dto.FeedDTO;

public class CreateFeedController implements Controller{
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");	
	Date time = new Date();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long feedId = Long.parseLong(request.getParameter("feedId"));
		String photo = request.getParameter("photo");
		String Date = format1.format(time);
		java.sql.Date joinDate= java.sql.Date.valueOf(Date);
		long userId = Long.parseLong(request.getParameter("userId"));
		String content = request.getParameter("content");
		
		FeedDTO feed = new FeedDTO(feedId, photo, joinDate, userId, content );	
		
		FeedManager feedManager = FeedManager.getInstance();
		feedManager.create(feed);
		
		return "redirect:/home";
	}
}
