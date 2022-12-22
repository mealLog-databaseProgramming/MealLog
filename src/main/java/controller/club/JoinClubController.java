package controller.club;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.BelongDTO;
import model.service.ClubManager;

public class JoinClubController implements Controller {
		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");	
		Date time = new Date();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			long joinId = UserSessionUtils.getLoginUserId(request.getSession());
			long clubId = Long.parseLong(request.getParameter("clubId"));
			System.out.println("joinId " + joinId + "clubId "+ clubId);
			
			String Date = format1.format(time);
			java.sql.Date joinDate= java.sql.Date.valueOf(Date);
			BelongDTO belong = new BelongDTO(joinId, clubId, joinDate);
			
			ClubManager manager = ClubManager.getInstance();		
			manager.joinClub(belong);		

			return "redirect:/group";
			
		}
}
