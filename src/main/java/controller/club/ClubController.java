package controller.club;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.BelongDTO;
import model.dto.ClubDTO;
import model.service.ClubManager;
import model.service.UserManager;
import model.dao.ClubDAO;

public class ClubController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
/**
		//long userId = Long.parseLong(request.getParameter("userId"));
		//long clubId = Long.parseLong(request.getParameter("clubId"));
		//long leaderId = Long.parseLong(request.getParameter("leader"));
		
		ClubManager manager = ClubManager.getInstance();
		List<ClubDTO> clubList = manager.findClubList();
        
		request.setAttribute("clubList", clubList);
		
		if (manager.isLeader(leaderId, clubId)){
			request.setAttribute("isLeader", true);
		}
		else if(manager.isMember(userId, clubId)) {
			request.setAttribute("joined", true);
		}
		*/
		request.setAttribute("page", "group/groupList.jsp");
		return "/index.jsp";
	}
	
	
}

