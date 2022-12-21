package controller.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controller.Controller;
import controller.UserSessionUtils;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
import model.dto.UserDTO;
import model.service.ClubManager;

public class CreateClubController implements Controller {
	//프론트에서 해시태그를 리스트에 담아서 넘겨준다


	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClubManager manager = ClubManager.getInstance();
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		System.out.println("createClub 관련 : " + userId);
		
		String inputHashtagList = request.getParameter("hashtagList") ;//사용자가 입력한 해시태그값(string)의 리스트
		List<ClubDTO> clubList = manager.findClubList();
		List<HashtagDTO> hashtagList = null;
		
		//ClubDTO club = new ClubDTO("1", "1", "2", 10, 9);
		
		ClubDTO club = new ClubDTO(request.getParameter("cname"),
				request.getParameter("goal"),
				request.getParameter("info"),  
				Integer.parseInt(request.getParameter("max_member")),  
				userId);
		System.out.println(club.getCname());
		long clubId = manager.create(club);
			/**
		for (int i = 0; i < 5; i++) {
			HashtagDTO hashtag = new HashtagDTO(		
				Long.parseLong(request.getParameter("clubId")),
				request.getParameter("hname"));
				hashtagList.add(hashtag);	
		}		
		manager.createHashtag(hashtagList);**/
			
		return "redirect:/group";
		
	
		}
	}
