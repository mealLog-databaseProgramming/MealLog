package controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.UserDTO;
import model.service.*;

public class UserInfoUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			String name = request.getParameter("name");
			String profile = request.getParameter("profile");
			String introduce = request.getParameter("introduce");
			
			UserManager userManager = UserManager.getInstance();
			long userId = UserSessionUtils.getLoginUserId(request.getSession());
			UserDTO user = userManager.findUser(userId);
			
			user.setUname(name);
			user.setProfile(profile);
			user.setIntroduce(introduce);
			
			userManager.update(user);
			
		} catch(Exception e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "redirect:/mypage";
	}

}
