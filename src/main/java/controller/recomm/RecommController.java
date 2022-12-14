package controller.recomm;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.StatDTO;
import model.dto.UserDTO;
import model.service.FeedManager;
import model.service.FoodManager;
import model.service.RecommandManager;
import model.service.StatManager;
import model.service.UserManager;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

public class RecommController implements Controller {

	RecommandManager recommendManager;
	FeedManager feedManager = new FeedManager();
	FoodManager foodManager;
	StatManager statManager;
	UserManager userManager = new UserManager();
	RecommandManager recommManager = new RecommandManager();
	Date today = new Date();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
		long userId = UserSessionUtils.getLoginUserId(request.getSession());		
	
		foodManager = FoodManager.getInstance();
		
		float EER = recommManager.getUserEER(userId);
		request.setAttribute("EER", EER);
		
		//영양소 총합 가져오기
		float[] nutriList = new float[4];
		nutriList = recommManager.findSumFoodListToday(userId);
		request.setAttribute("kcalSum", nutriList[0]);
		request.setAttribute("proteinSum", nutriList[1]);
		request.setAttribute("carbSum", nutriList[2]);
		request.setAttribute("fatSum", nutriList[3]);
		
		//오늘자 피드리스트 가져오기
		List<FeedDTO> feedList = recommManager.findFeedListToday(userId);
		List<Map> list = new ArrayList<Map>();	
		
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		for (int i = 0; i < feedList.size(); i++) {
			//리스트를 반환하는건데 왜 하나씩 입력하는가
			foodList = foodManager.findFoodList(feedList.get(i).getFeedId());
					
			Map data = new HashMap();
			data.put("feed", feedList.get(i));
			data.put("food", foodList);
		
			list.add(data);
		}
		request.setAttribute("list", list);
		
		//유저이름 구하기
		UserDTO user = userManager.findUser(userId);
		request.setAttribute("uname", user.getUname());
		
		request.setAttribute("page", "recomm/recomm.jsp");
		return "/index.jsp";
	}
	
	
}
