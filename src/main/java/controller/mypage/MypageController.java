package controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;

import model.dao.UserDAO;
import model.dto.StatDTO;
import model.dto.UserDTO;
import model.service.StatManager;
import model.service.UserManager;

public class MypageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub		
		if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
	
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		
		if(request.getParameter("uid") == null) return "redirect:/mypage?uid=" + userId;
		
		
		long uid = Long.valueOf(request.getParameter("uid"));
		UserManager userManager = UserManager.getInstance();
		UserDTO user = userManager.findUser(uid);
		
		/* 프로필 */
		if(user.getProfile() != null) request.setAttribute("profile", "/resources/profile/" + user.getProfile());
		request.setAttribute("uname", user.getUname());
		request.setAttribute("introduce", user.getIntroduce());
		
		/* statList */
		if(uid == userId) {
			StatManager statManager = StatManager.getInstance();
			List<StatDTO> statList = statManager.read(userId);
			request.setAttribute("statList", statList);
		}
		
		request.setAttribute("page", "mypage/mypage.jsp");
		return "/index.jsp";
	}

}
