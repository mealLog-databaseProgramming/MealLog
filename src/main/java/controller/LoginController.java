package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.*;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String loginId = request.getParameter("loginId"); 
		String password = request.getParameter("password");
		
		if (loginId != null) {
			try {
				UserManager userManager = UserManager.getInstance();
				request.getSession().setAttribute("userId", userManager.login(loginId, password));
				return "redirect:/";
			} catch(Exception e) {
				request.setAttribute("message", e.getMessage());
			}
		}
		
		request.setAttribute("page", "login.jsp");
		return "/main.jsp";
	}

}
