package controller.club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.service.ClubManager;

public class DeleteClubController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long clubId = Long.parseLong(request.getParameter("clubId"));
		ClubManager manager = ClubManager.getInstance();
				
		System.out.println(clubId);
		manager.removeClubAll(clubId);
		
		return "redirect:/group";
	}
}
