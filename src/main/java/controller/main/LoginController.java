package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.*;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("id"); 
		String password = request.getParameter("password");
		
		// UserManager userManager = UserManager.getInstance();
		
		if (userId != null) {
			try {
				if (userId == "" || password == "") 
					throw new Exception("아이디와 비밀번호를 입력하세요.");

				// userManager.login(userId, password);
				
				return "redirect:/";
			} catch(UserNotFoundException e) {
				request.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
			} catch(Exception e) {
				request.setAttribute("message", e.getMessage());
			}
		}
		
		request.setAttribute("page", "login.jsp");
		return "/main.jsp";
	}

}
