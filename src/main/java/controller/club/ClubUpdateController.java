package controller.club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.ClubDTO;
import model.service.ClubManager;

public class ClubUpdateController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub

		long clubId = Long.parseLong(request.getParameter("clubId"));
		String cname = request.getParameter("cname");
		String goal =  request.getParameter("goal");
		String info =  request.getParameter("info");
		int max_member = Integer.parseInt(request.getParameter("max_member"));
		long leader = Long.parseLong( request.getParameter("leader"));
		
		ClubManager clubManager = ClubManager.getInstance();
		ClubDTO club = new ClubDTO(clubId, cname, goal, info, max_member, leader);
		clubManager.update(club);
		System.out.println("clubUpdate " + club.getClubId());

		//String hashtag = request.getParameter("hashtag");
		
		//String members = request.getParameter("member");
		//System.out.println("this club members : " + members);
		
		try {
			System.out.println("try start");
			//clubManager.update(club);
			
		} catch(Exception e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "redirect:/group";
	}
}
