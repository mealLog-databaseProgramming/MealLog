package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dao.*;
import model.dto.*;
import model.service.*;

public class SignupController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String userId = request.getParameter("id"); 
		String password = request.getParameter("password");
		//...
		
		UserManager userManager = UserManager.getInstance();
		UserDTO user;
		
		/*후에는 수정 필요함. 일단*/
		if (userId != null) { // 폼 받아왔으면
			try {
				//userManager.create(new UserDTO(...));
				
				return "/login";
			} catch(Exception e) {
				request.setAttribute("message", e.getMessage());
			}
		}
		
		request.setAttribute("page", "signup.jsp");
		return "/main.jsp";
	}
	
}