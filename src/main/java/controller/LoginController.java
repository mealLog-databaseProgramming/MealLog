package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String userId = request.getParameter("id"); 
		String password = request.getParameter("password");
		
		if (userId != null) {
			try {
				if (userId == "" || password == "") 
					throw new Exception("아이디와 비밀번호를 입력하세요.");
				
				if (!existence_userId(userId))
					throw new Exception("존재하지 않는 아이디입니다.");
				
				if (!matching_password(password))
					throw new Exception("비밀번호가 틀렸습니다.");
				
				return "redirect:/";
			} catch(Exception e) {
				request.setAttribute("message", e.getMessage());
			}
		}
		
		request.setAttribute("page", "login.jsp");
		return "/main.jsp";
	}
	
	boolean existence_userId(String userId) {
		return true;
	}
	
	boolean matching_password(String password) {
		return true;
	}

}
