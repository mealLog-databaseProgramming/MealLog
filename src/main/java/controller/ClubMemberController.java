package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.ClubDTO;
import model.service.ClubManager;

public class ClubMemberController implements Controller{
	//그룹 create //그룹원 가입
	//그룹 remove //그룹원 remove(탈퇴)
	//그룹 update
	//그룹 search
	
	//매니저
	//create, remove, update, findClub, 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//로그인 되어있으면 그룹 가입->가입한 그룹 인포 화면
		ClubDTO club = new ClubDTO();		
        
		try {
			ClubManager manager = ClubManager.getInstance();
			manager.create(club);
			
			return "/groupInfo.jsp";
	        
		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("club", club);
			return "/community/creationForm.jsp";
		}
	}

	
	public String removeClub(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//로그인 되어있고 그 그룹 멤버면 탈퇴->그룹 인포 화면
		ClubDTO club = new ClubDTO();		
        
		try {
			ClubManager manager = ClubManager.getInstance();
			manager.create(club);
			
			return "/groupInfo.jsp";
	        
		} catch (Exception e) {		// 예외 발생 시 입력 form으로 forwarding
            request.setAttribute("creationFailed", true);
			request.setAttribute("exception", e);
			request.setAttribute("club", club);
			return "/community/creationForm.jsp";
		}
	}

}
