package controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dto.BelongDTO;
import model.dto.ClubDTO;
import model.service.ClubManager;
import model.service.UserManager;
import model.dao.ClubDAO;

public class ClubController implements Controller {
//	Excute - findClubList -
//	Create - 
//	Update
//	Remove
//	joinClub
//	leaveClub
//	findClubByName
//	findClubByHashtag
	
	//관리자
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");
			
	Date time = new Date();
	
	public static final String USER_SESSION_KEY = "userId";
	
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//모든 그룹 리스트를 받아오는 메소드
		ClubManager manager = ClubManager.getInstance();
		List<ClubDTO> clubList = manager.findClubList();
        
		request.setAttribute(("clubList"), clubList);
		
		request.setAttribute("page", "group/groupList.jsp");
		return "/index.jsp";
	}//완


	public String create(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//시퀀스는 어떻게 처리해야하는가
	
		ClubDTO club = new ClubDTO(0, request.getParameter("cname"),
				request.getParameter("goal"),
				request.getParameter("info"),  
				Integer.parseInt(request.getParameter("max_member")),  
				Integer.parseInt(request.getParameter("leader")));	
				
			request.setAttribute("club", club);
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
	
	public String updateClub(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClubDTO club;	
		//관리자면 그룹 수정 가능
		long leader = Long.parseLong(request.getParameter("leader"));			
		ClubManager manager = ClubManager.getInstance();		
		if(Long.parseLong(request.getParameter("userId")) == leader) {
			
			if (request.getMethod().equals("GET")) {// GET request: 회원정보 수정 form 요청
				//수정하려는 그룹의 아이디 가져오기
	    		long updateId = Long.parseLong(request.getParameter("clubId"));
	    		//이 값을 폼에 뿌려줘야함->객체 반환
	    		//여기 다시---------------------------------------------------
	    		//ClubDTO updateClub = manager.???();	
				//request.setAttribute("clubInfo", updateClub);	
			}
			//관리자면 그룹 정보 수정->수정된 정보 보여주는 인포화면으로
			// POST request (회원정보가 parameter로 전송됨)
	    	ClubDTO updateUser = new ClubDTO(
	    		Long.parseLong(request.getParameter("clubId")),
	    		request.getParameter("cname"),
	    		request.getParameter("goal"),
	    		request.getParameter("info"),
	    		Integer.parseInt(request.getParameter("max_member")),
	    		Long.parseLong(request.getParameter("leader")));
	    	
	    	//manager.update(club);
    	}
		return "/groupInfo.jsp";
	        
		
	}
	
	public String removeClub(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//관리자면 그룹 삭제->그룹 목록 화면으로
		long leader = Long.parseLong(request.getParameter("leader"));
		ClubManager manager = ClubManager.getInstance();
				
		//if 관리자라면
		if(Long.parseLong(request.getParameter("userId")) == leader) {
			manager.remove(Long.parseLong(request.getParameter("clubId")));
			//매니저 호츨^
		}
		return "/groupList.jsp";
	}
	
	//그룹 가입
	public String joinClub(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//이미 로그인되어있고 = 컨트롤러
		//정원초과 아니고 && 이미 가입된 그룹 아니면 가입 = 매니저
		long joinId = Long.parseLong(request.getParameter("userId"));
		long clubId = Long.parseLong(request.getParameter("clubId"));
		String Date = format1.format(time);
		java.sql.Date joinDate= java.sql.Date.valueOf(Date);
		BelongDTO belong = new BelongDTO(joinId, clubId, joinDate);
		
		ClubManager manager = ClubManager.getInstance();		
		HttpSession session = request.getSession();	
		
		if (UserSessionUtils.isLoginUser(joinId, session)){
			manager.joinClub(belong);		
		}
		return "/groupInfo.jsp"; 
		
	}
	
	//그룹 탈퇴
	public String leaveClub(HttpServletRequest request, HttpServletResponse response) throws Exception {		
		//이미 로그인되어있고 = 컨트롤러
		//이미 가입된 그룹 아니면 가입 = 매니저
		long deleteId = Long.parseLong(request.getParameter("userId"));
		long leaderId = Long.parseLong(request.getParameter("leader"));
		long clubId = Long.parseLong(request.getParameter("clubId"));
		
		BelongDTO belong = new BelongDTO(deleteId, clubId);
		
		ClubManager manager = ClubManager.getInstance();		
		HttpSession session = request.getSession();	
	
		
		if ((UserSessionUtils.isLoginUser(leaderId, session) ) 	// 로그인한 사용자가 관리자이고 	
			   || 												// 또는 
			(UserSessionUtils.isLoginUser(deleteId, session))) { // 로그인한 사용자가 삭제 대상인 경우 (자기 자신을 삭제)
				
			manager.remove(deleteId);				// 사용자 정보 삭제	
		}
			
		return "/groupInfo.jsp";
	}
	/*
	public String findByName(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClubDTO club = new ClubDTO();		
		ClubManager manager = ClubManager.getInstance();
		manager.findByName(club);
		
		return "/groupList.jsp";
	}
	
	public String findByHashtag(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ClubDTO club = new ClubDTO();		
		ClubManager manager = ClubManager.getInstance();
		manager.findByHashtag(club);
		
		return "/groupList.jsp";
	}*/
}

