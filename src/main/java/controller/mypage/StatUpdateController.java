package controller.mypage;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.service.*;

public class StatUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		
		try {
			String[] statList = request.getParameterValues("statList");

			StatManager statManager = StatManager.getInstance();
			statManager.updateStatList(userId, statList);
			
		} catch(Exception e) {
			System.out.println(e);
		}
		
		return "redirect:/mypage";
	}

}
