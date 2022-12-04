package controller.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.ReactDTO;
import model.dto.ReplyDTO;
import model.service.FeedManager;
import model.service.FoodManager;
import model.service.ReplyManager;

public class HomeController implements Controller {

	FeedManager feedManager = new FeedManager();
	FoodManager foodManager = new FoodManager();
	ReplyManager replyManager = new ReplyManager();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//hashMap
		List<Map> list = new ArrayList<Map>();
		
		
		List<FeedDTO> feedList = new ArrayList<FeedDTO>();
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		List<ReplyDTO> replyList = new ArrayList<ReplyDTO>();
		List<ReactDTO> reactList = new ArrayList<ReactDTO>();
		
		feedList = feedManager.read();
		for (int i = 0; i < feedList.size(); i++) {
			
			foodList = foodManager.findFoodList(feedList.get(i).getFeedId());
			replyList = replyManager.display(feedList.get(i).getFeedId());
					
			Map data = new HashMap();
			data.put("feed", feedList.get(i));
			data.put("food", foodList);
			data.put("reply", replyList);
		
			list.add(data);
		}
		
		request.setAttribute("list", list);
		
		request.setAttribute("page", "home/home.jsp");
		return "/index.jsp";
		
		//임시테스트
//		List<FeedDTO> feedList = new ArrayList<FeedDTO>();
//		
//		Date date = new Date(0);
//		FeedDTO f1 = new FeedDTO(100, 200, date, "내용1", "http1");
//		FeedDTO f2 = new FeedDTO(101, 201, date, "내용2", "http2");
//		FeedDTO f3 = new FeedDTO(102, 202, date, "내3", "http3");
//		
//		feedList.add(f1);
//		feedList.add(f2);
//		feedList.add(f3);
//		request.setAttribute("page", "home/home.jsp");
//		return "/index.jsp";
	}

}
