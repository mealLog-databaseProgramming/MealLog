package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.ClubDTO;
import model.service.ClubManager;
import model.Community;
import model.User;
import model.dao.ClubDAO;

public class ClubController implements Controller {
	//그룹 생성해서 정보 보여주기 
	//그룹 삭제 
	//그룹 정보 수정하면 수정된 화면 보여주기
	//그룹 검색시 검색된 그룹 리스트 보여주기
	
	//그룹원 가입
	//그룹원 remove(탈퇴)
	
	//clubDAO에서 그룹 말고 유저 지우는거
	
	
	
	@Override//리스트 출력으로 해야함
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//로그인되어있으면 그룹 생성->인포화면으로
		ClubDTO club = new ClubDTO(0, request.getParameter("cname"),
				request.getParameter("goal"),
				request.getParameter("info"),  
				Integer.parseInt(request.getParameter("max_member")),  
				Integer.parseInt(request.getParameter("leader")));	
		
		//setAttribute(변수명, 퍼센트값)
		
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
	/**그룹의 관리자인지 확인하는 메소드
	public boolean isLeader(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//리더아이디 받아와서 유저아이디와 비교
		long leader = Long.parseLong(request.getParameter("leader"));
		ClubManager manager = ClubManager.getInstance();
		
		//if 관리자라면
		if(Long.parseLong(request.getParameter("userId")) == leader) {
			return true;
		}
		return false;
	}**/
	
	
	public String updateClub(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ClubDTO club;	//기존 정보 받아와야함	
		//관리자면 그룹 수정 가능
		long leader = Long.parseLong(request.getParameter("leader"));			
		ClubManager manager = ClubManager.getInstance();		
		//if 관리자라면
		if(Long.parseLong(request.getParameter("userId")) == leader) {
			manager.update(club);
			//매니저 호츨^
		}
		
		if (request.getMethod().equals("GET")) {	
    		// GET request: 회원정보 수정 form 요청
			
			//수정하려는 그룹의 아이디 가져오기
    		long updateId = Long.parseLong(request.getParameter("clubId"));
    		//이 값을 폼에 뿌려줘야함->객체 반환
    		ClubDTO updateClub = manager.findClub(updateId);	// 커뮤니티 리스트 검색
			request.setAttribute("clubInfo", updateClub);	
			
		}
		//관리자면 그룹 정보 수정->수정된 정보 보여주는 인포화면으로
		// POST request (회원정보가 parameter로 전송됨)
    	ClubDTO updateUser = new User(
    		request.getParameter("userId"),
    		request.getParameter("password"),
    		request.getParameter("name"),
    		request.getParameter("email"),
    		request.getParameter("phone"),
			Integer.parseInt(request.getParameter("commId")));
    	
		return "/groupInfo.jsp";
	        
		
	}
	
	public String removeClub(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
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
	
	
	
	//검색시 그룹 리스트 보여줌
	public String clubList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ClubManager manager = ClubManager.getInstance();
		List<ClubDTO> clubList = manager.findClubList();
        
		request.setAttribute(("clubList"), clubList);
			
		return "/groupList.jsp";
	        
		}
	
	
}

