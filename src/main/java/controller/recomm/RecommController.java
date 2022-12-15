package controller.recomm;

import java.util.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.StatDTO;
import model.dto.UserDTO;
import model.service.FoodManager;
import model.service.RecommandManager;
import model.service.StatManager;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.text.ParseException;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class RecommController implements Controller {

	RecommandManager recommendManager;
	FoodManager foodManager;
	StatManager statManager;
	Date today = new Date();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
		long userId = UserSessionUtils.getLoginUserId(request.getSession());

//		JSONParser parser = new JSONParser();
//		
//		try {
//			FileReader reader = new FileReader("resources/js/recomm/foodData.js");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		
	
		recommendManager = RecommandManager.getInstance();
		foodManager = FoodManager.getInstance();
		
		float EER = recommendManager.getUserEER(userId);
		request.setAttribute("EER", EER);

		//얘기 필요 유저가 하루 먹은 음식리스트 이거 어떻게 받지?
//		StatDTO stat = recommendManager.getStatPerToday(today, EER); //그 날의 stat의 퍼센트 구해주는 메소드
//		request.setAttribute("kcalPer", stat.getKcal());
//		request.setAttribute("carbPer", stat.getCarb());
//		request.setAttribute("proteinPer", stat.getProtein());
//		request.setAttribute("fatPer", stat.getFat());

		request.setAttribute("page", "recomm/recomm.jsp");
		return "/index.jsp";
	}
	
	
}
