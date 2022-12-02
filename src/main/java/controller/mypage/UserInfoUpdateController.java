package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.*;

public class UserInfoUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		long userId = (long) request.getAttribute("userId");
		String name = (String) request.getAttribute("profile");
		String profile = (String) request.getAttribute("profile");
		String introduce = (String) request.getAttribute("introduce");
		
		UserManager userManager = UserManager.getInstance();
		
		try {
			//userManager.updateInfo(userId, name, profile, introduce);
		} catch(Exception e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "redirect:/mypage";
	}

}
