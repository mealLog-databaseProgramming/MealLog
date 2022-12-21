package controller.mypage;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.StatDTO;
import model.dto.UserDTO;
import model.service.StatManager;
import model.service.UserManager;
import model.service.FeedManager;
import model.service.FoodManager;
import model.service.ReactManager;

public class MypageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
		
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		
		if(request.getParameter("uid") == null) return "redirect:/mypage?uid=" + userId;
		
		UserManager userManager = UserManager.getInstance();
		FeedManager feedManager = FeedManager.getInstance();
		StatManager statManager = StatManager.getInstance();
		FoodManager foodManager = FoodManager.getInstance();
		//ReactManager reactManager = ReactManager.getInstance();
		
		long uid = Long.valueOf(request.getParameter("uid"));
		UserDTO user = userManager.findUser(uid);
		
		/* 프로필 */
		if(user.getProfile() != null) request.setAttribute("profile", "/resources/profile/" + user.getProfile());
		request.setAttribute("uname", user.getUname());
		request.setAttribute("introduce", user.getIntroduce());
		
		/* 프로필 태그 */
		request.setAttribute("feedNum", feedManager.countFeedbyUser(uid));
		request.setAttribute("reactNum", feedManager.countPositiveReactbyUser(uid));
		
		/* statList */
		List<StatDTO> statList = statManager.read(uid);
		request.setAttribute("statList", statList);
		
		/* chart */
		String statData = "{";
		for(StatDTO stat:statList) {
			statData += "\'"+stat.getDate()+"\': "+stat.getWeight()+", ";
		}
		statData += "}";
		request.setAttribute("statData", statData);
		request.setAttribute("height", user.getHeight());
		
		float[] nutriList = feedManager.findSumFoodList(uid);
		String nutriData = "[" + nutriList[1] +","+nutriList[2]+","+ nutriList[0] + "]";
		request.setAttribute("nutriData", nutriData);
		
		/* feed */
		List<FeedDTO> feedList = feedManager.readByUserId(uid);
		HashMap<Long, List<FoodDTO>> foods = new HashMap<Long, List<FoodDTO>>();
		HashMap<Long, String> publishDates = new HashMap<Long, String>();
		HashMap<Long, Integer> positiveReacts = new HashMap<Long, Integer>();
		HashMap<Long, Integer> negativeReacts = new HashMap<Long, Integer>();
		
		for(FeedDTO feed: feedList) {
			long feedId = feed.getFeedId();
			foods.put(feedId, foodManager.findFoodList(feedId));
			
			String date = new SimpleDateFormat("yy-MM-dd a hh:mm", new Locale("en", "US")).format(feed.getPublishDate());
			publishDates.put(feedId, date.toLowerCase());
			positiveReacts.put(feedId, feedManager.countPositiveReact(feedId));
			negativeReacts.put(feedId, feedManager.countNegativeReact(feedId));
		}
		request.setAttribute("feedList", feedList);
		request.setAttribute("foods", foods);
		request.setAttribute("publishDates", publishDates);
		request.setAttribute("positiveReacts", positiveReacts);
		request.setAttribute("negativeReacts", negativeReacts);
		
		request.setAttribute("page", "mypage/mypage.jsp");
		return "/index.jsp";
	}

}
