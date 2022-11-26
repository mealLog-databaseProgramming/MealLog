package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.StatDTO;
import DTO.UserDTO;

public class RecommController implements Controller {

	//오늘 영양소 통계 계산해서 보내기
	//음식 추천
	//오늘자 폴라로이드 정보 가져오기
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		request.setAttribute("page", "recomm/recomm.jsp");
		
		//eer 받아오기
//		UserManager userManager = UserManager.getInstance();
//		String userId = request.getParameter("userId");
//		
//		float EER = userManager.getUserEER(userId);
//		
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
