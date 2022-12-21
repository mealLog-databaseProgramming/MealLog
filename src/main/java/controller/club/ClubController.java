package controller.club;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
import model.service.ClubManager;
import model.service.UserManager;
import model.dao.ClubDAO;

public class ClubController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//hashMap
		List<Map> list = new ArrayList<Map>();
		//long userId = Long.parseLong(request.getParameter("userId"));
		//long clubId = Long.parseLong(request.getParameter("clubId"));
		//long leaderId = Long.parseLong(request.getParameter("leader"));
		//String tag = request.getParameter("tag");
		
		long userId = 1;
		long clubId = 1;
		long leaderId = 1;
		String tag = "diet";
		
		ClubManager manager = ClubManager.getInstance();
		List<ClubDTO> clubList = manager.findClubList();
		List<String> hashtagList;
		
		ClubDTO club;
		HashtagDTO hashtag;
				
		if (manager.isLeader(leaderId, clubId)){
			request.setAttribute("isLeader", true);
		}
		else if(manager.isMember(userId, clubId)) {
			request.setAttribute("joined", true);
		}
		
		//클럽정보 + 해시태그 정보 매핑해서 setAttribute하기
		for (int i = 0; i < clubList.size(); i++) {
			hashtagList = manager.findHashtagbyClubId(clubList.get(i).getClubId());

			Map data = new HashMap();
			data.put("clubList", clubList.get(i));
			data.put("hashtags", hashtagList);
			
			list.add(data);
		}
		request.setAttribute("list", list);
	
		request.setAttribute("page", "group/groupList.jsp");
		return "/index.jsp";
	}
	
	
}

