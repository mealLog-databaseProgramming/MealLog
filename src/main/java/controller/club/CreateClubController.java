package controller.club;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
import model.service.ClubManager;

public class CreateClubController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long userId = Long.parseLong(request.getParameter("userId"));
		
		ClubDTO club = new ClubDTO(0, request.getParameter("cname"),
				request.getParameter("goal"),
				request.getParameter("info"),  
				Integer.parseInt(request.getParameter("max_member")),  
				userId);	
		
		ClubManager clubManager = ClubManager.getInstance();

//		HashtagDTO hashtag = new HashtagDTO(Long.parseLong(request.getParameter("clubId")),
//				request.getParameter("hname"));
			try {
				request.setAttribute("club", club);
//				clubManager.create(club, hashtag);
			} catch(Exception e) {
				request.setAttribute("message", e.getMessage());
			}
			
			return "redirect:/mypage";
		
	
			}
	}
