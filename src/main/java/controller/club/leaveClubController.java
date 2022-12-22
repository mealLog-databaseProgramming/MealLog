package controller.club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.BelongDTO;
import model.service.ClubManager;

public class leaveClubController implements Controller{
	//그룹 탈퇴
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		long leaveId = UserSessionUtils.getLoginUserId(request.getSession());
		long clubId = Long.parseLong(request.getParameter("clubId"));
		
			System.out.println(leaveId);
			ClubManager manager = ClubManager.getInstance();		
			manager.leaveClub(leaveId, clubId);
				
			return "redirect:/group";
		}
}
