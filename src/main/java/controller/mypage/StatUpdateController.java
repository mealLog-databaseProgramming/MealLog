package controller.mypage;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.*;

public class StatUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long userId = (long) request.getAttribute("userId");
		Date date =  (Date) request.getAttribute("date");
		float weight = (float) request.getAttribute("weight");
		
		StatManager statManager = StatManager.getInstance();
		
		try {
			//statManager.(userId, date, weight);
			
		} catch(Exception e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "redirect:/mypage";
	}

}
