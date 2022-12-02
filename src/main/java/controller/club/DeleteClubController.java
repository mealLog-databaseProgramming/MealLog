package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.service.ClubManager;

public class DeleteClubController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		long clubId = (long) request.getAttribute("clubId");
		ClubManager manager = ClubManager.getInstance();
				
		if(request.getParameter("isLeader") != null) {
			manager.remove(clubId);
		}
		return "redirect:/gourp";
	}
}
