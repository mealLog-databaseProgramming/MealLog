package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.service.*;
import util.PasswordSecureHashGenerator;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String loginId = request.getParameter("loginId"); 
		String password = request.getParameter("password");
		
		if (loginId != null) {
			try {
				//if(password.equals(password.toUpperCase())) throw new Exception("유효하지 않은 비밀번호입니다.");
				
				UserManager userManager = UserManager.getInstance();
				password = PasswordSecureHashGenerator.encrypt(password);
				UserSessionUtils.login(userManager.login(loginId, password), request.getSession());
				
				return "redirect:/";
			} catch(Exception e) {
				request.setAttribute("message", e.getMessage());
			}
		}
		request.setAttribute("page", "login.jsp");
		return "/main.jsp";
	}
}
