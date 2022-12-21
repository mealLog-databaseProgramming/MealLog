package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.UserDTO;
import model.service.PasswordSecureHashGenerator;
import model.service.UserManager;
import model.service.exception.ExistingUserException;

public class KakaoSyncController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String loginId = (String) request.getAttribute("loginId"); 
		
		if(loginId == null) {
			loginId = (String) request.getParameter("loginId"); 
			String password = (String) request.getParameter("password");
			String emailAddress = (String) request.getParameter("emailAddress");
			int gender = Integer.parseInt(request.getParameter("gender"));
			
			request.setAttribute("loginId", loginId);
			request.setAttribute("password", password);
			request.setAttribute("emailAddress", emailAddress);
			request.setAttribute("gender", gender);
		}
		
		String name = request.getParameter("name");
		if ( name != null ) {
			try {
				String password = request.getParameter("password");
				String emailAddress = request.getParameter("emailAddress");
				int gender = Integer.parseInt(request.getParameter("gender"));
				int age =  Integer.parseInt(request.getParameter("age"));
				float height = Float.parseFloat(request.getParameter("height"));
				float weight = Float.parseFloat(request.getParameter("weight"));
				int activeRank = Integer.parseInt(request.getParameter("activeRank"));
				
				UserDTO user = new UserDTO();
				user.setLoginId(loginId);
				user.setPassword(PasswordSecureHashGenerator.encrypt(password));
				user.setEmailAddress(emailAddress);
				
				user.setUname(name);
				user.setGender(gender);
				user.setAge(age);
				user.setHeight(height);
				user.setWeight(weight);
				user.setActiveRank(activeRank);
				
				UserManager userManager = UserManager.getInstance();
				userManager.create(user);
				
				return "redirect:/login";
			} catch(ExistingUserException e) {
				request.setAttribute("message", e.getMessage());
			} catch(Exception e) {
				request.setAttribute("message", "회원가입에 실패했습니다. 다시 시도해주세요.");
			}
		}
		
		request.setAttribute("page", "kakao_signup.jsp");
		return "/main.jsp";
	}
}
