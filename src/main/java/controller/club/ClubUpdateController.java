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
		System.out.println("clubId: " +clubId);
		String cname = request.getParameter("cname");
		System.out.println("cname: " +cname);
		String goal =  request.getParameter("goal");
		System.out.println("goal: " +goal);
		String info =  request.getParameter("info");
		int max_member = Integer.parseInt(request.getParameter("max_member"));
		long leader = Long.parseLong( request.getParameter("leader"));
		//여까진 출력됨
		ClubManager clubManager = ClubManager.getInstance();
		ClubDTO club = new ClubDTO(clubId, cname, goal, info, max_member, leader);
		System.out.println("before: " +cname);
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
