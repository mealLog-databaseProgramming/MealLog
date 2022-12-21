package controller.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
import model.service.ClubManager;

public class CreateClubController implements Controller {
	//프론트에서 해시태그를 리스트에 담아서 넘겨준다
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClubManager manager = ClubManager.getInstance();
		long userId = Long.parseLong(request.getParameter("userId"));
		String inputHashtagList = request.getParameter("hashtagList") ;//사용자가 입력한 해시태그값(string)의 리스트
		List<ClubDTO> clubList = manager.findClubList();
		List<HashtagDTO> hashtagList = null;
		
		ClubDTO club = new ClubDTO(0, request.getParameter("cname"),
				request.getParameter("goal"),
				request.getParameter("info"),  
				Integer.parseInt(request.getParameter("max_member")),  
				userId);	
		//ㄴ클럽 정보 받아와서 객체 만들기->쏘기
			
		//클럽정보 + 해시태그 정보 매핑해서 setAttribute하기
		for (int i = 0; i < 5; i++) {
			HashtagDTO hashtag = new HashtagDTO(		
					Long.parseLong(request.getParameter("clubId")),
					request.getParameter("hname"));
			hashtagList.add(hashtag);	
		}		
			manager.createHashtag(hashtagList);

			Map data = new HashMap();
			data.put("newClub", club);
			data.put("hashtags", hashtagList);
			
			try {
				request.setAttribute("newClubInfo", data);
			} catch(Exception e) {
				request.setAttribute("message", e.getMessage());
			}
			
			return "redirect:/group";
		
	
			}
	}
