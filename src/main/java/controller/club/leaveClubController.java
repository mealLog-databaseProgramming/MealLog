package controller.club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dto.BelongDTO;
import model.service.ClubManager;

public class leaveClubController implements Controller{
	//그룹 탈퇴
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {		
			long deleteId = Long.parseLong(request.getParameter("userId"));
			long clubId = Long.parseLong(request.getParameter("clubId"));
						
			ClubManager manager = ClubManager.getInstance();		
			manager.leaveClub(deleteId, clubId);
				
			return "redirect:/group";
		}
}
