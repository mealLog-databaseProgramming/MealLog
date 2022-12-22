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
		System.out.println("cname: " +cname);
		String goal =  request.getParameter("goal");
		String info =  request.getParameter("info");
		//여까진 출력됨
		ClubManager clubManager = ClubManager.getInstance();
		ClubDTO club = new ClubDTO(clubId, cname, goal, info);

		//String hashtag = request.getParameter("hashtag");
		//clubManager.update(club);
		//String members = request.getParameter("member");
		//System.out.println("this club members : " + members);
		
		try {
			//System.out.println("try start");
			clubManager.update(club);
			
		} catch(Exception e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "redirect:/group";
	}
}
