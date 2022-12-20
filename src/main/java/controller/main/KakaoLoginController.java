package controller.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.UserDTO;
import model.service.UserManager;
import model.service.exception.ExistingUserException;

public class KakaoLoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String email = request.getParameter("emailAddress");
		
		if(id != null) {
			try {
				UserManager userManager = UserManager.getInstance();
				if(userManager.existingLoginId(id)) {
					UserSessionUtils.login(userManager.login(id, email), request.getSession());
					return "redirect:/";
				}
				String gender = request.getParameter("gender");
				
				request.setAttribute("loginId", id);
				request.setAttribute("password", email);
				request.setAttribute("emailAddress", email);
				request.setAttribute("gender", gender);
				
				request.setAttribute("page", "kakao_signup.jsp");
				return "/main.jsp";
				
			} catch(ExistingUserException e) {
				request.setAttribute("message", "로그인에 실패했습니다! 관리자에게 문의해주시길 바랍니다.");
			} catch(Exception e) {
				request.setAttribute("message", "로그인에 실패했습니다! 잠시후 다시 시도해주세요.");
				System.out.println(e);
			}
		}

		return "redirect:/login";
	}
}
