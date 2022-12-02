package controller;

import java.util.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.StatDTO;
import model.dto.UserDTO;

import model.service.RecommandManager;
import model.service.StatManager;

public class RecommController implements Controller {

	RecommandManager recommendManager;
	StatManager statManager;
	Date today = new Date();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("page", "recomm/recomm.jsp");
	
		recommendManager = RecommandManager.getInstance();
		statManager = StatManager.getInstance();
		
//		request.setAttribute("userId", UserSessionUtils.getLoginUserId(request.getSession()));
		long userId = 1234;
		request.setAttribute("userId", userId);
		
		//eer 받아오기
		float EER = (float) 0.0; //recommandManager.getUserEER(userId);
		request.setAttribute("EER", EER);	//검토를 위한 코드. 넘길필요X
		
		
		StatDTO stat = recommendManager.getStatPerToday(today, EER); //그 날의 stat의 퍼센트 구해주는 메소드
		request.setAttribute("kcalPer", stat.getKcal());
		request.setAttribute("carbPer", stat.getCarb());
		request.setAttribute("proteinPer", stat.getProtein());
		request.setAttribute("fatPer", stat.getFat());

		return "/index.jsp";
	}
	
	
}
