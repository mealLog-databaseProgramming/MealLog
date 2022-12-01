package controller;

import java.util.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.FoodDTO;
import model.dto.StatDTO;
import model.dto.UserDTO;

//import model.service.UserManager;
import model.service.RecommandManager;
import model.service.StatManager;

public class RecommController implements Controller {

	RecommandManager recommendManager;
	StatManager statManager;
	Date today = new Date();
	
	//오늘 영양소 통계 계산해서 보내기
	//음식 추천
	//오늘자 폴라로이드 정보 가져오기
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
		
		//취소, 기존 방법으로 진행(js)
//		FoodDTO food = recommendManager.recommendFood("재료", EER);
//		request.setAttribute("fName", food.getFname());
//		request.setAttribute("kcal", food.getKcal());
//		request.setAttribute("carb", food.getCarb());
//		request.setAttribute("protein", food.getProtein());
//		request.setAttribute("fat", food.getFat());
		
		StatDTO stat = recommendManager.getStatPerToday(today, EER); //그 날의 stat의 퍼센트 구해주는 메소드
		request.setAttribute("kcalPer", stat.getKcal());
		request.setAttribute("carbPer", stat.getCarb());
		request.setAttribute("proteinPer", stat.getProtein());
		request.setAttribute("fatPer", stat.getFat());
//		if(request.getMethod().equals("GET")){
//			//아직 manager 없음
//			StatManager manager = StatManager.getInstance();
//			
//			StatDTO stat = manager.getStatToday();
//			
//			//(받은 값 / 하루 필요량) 해서 퍼센트를 구한다
//			float carbPer = stat.getCarb() / EER;
//			float proteinPer = stat.getProtein() / EER;
//			float fatPer = stat.getFat() / EER;
//			float kcal = stat.getKcal();
//			
//			//setAttribute(변수명, 퍼센트값)
//			request.setAttribute("carb", carbPer);
//			request.setAttribute("protein", proteinPer);
//			request.setAttribute("fat", fatPer);
//			request.setAttribute("kcal", kcal);
//		}
		return "/index.jsp";
	}
	
	
}
