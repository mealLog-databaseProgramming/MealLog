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
import controller.UserSessionUtils;
import model.dto.BelongDTO;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
import model.dto.UserDTO;
import model.service.ClubManager;
import model.service.UserManager;
import model.dao.ClubDAO;
import model.service.UserManager;

public class ClubController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
		System.out.println("-----------------");
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		//hashMap
		List<ClubDTO> otherClubList = new ArrayList<>();
		List<ClubDTO> myClubList = new ArrayList<>();
		List<ClubDTO> joinedClubList = new ArrayList<>();
		
		HashMap<Long, String> hashtags = new HashMap<Long, String>();
		HashMap<Long, List<UserDTO>> members = new HashMap<Long, List<UserDTO>>();
		 
		ClubManager manager = ClubManager.getInstance();
		List<ClubDTO> clubList = new ArrayList<ClubDTO>();
		List<String> hashtagList = new ArrayList<String>();
	
		ClubDTO club;
		UserManager userManager = UserManager.getInstance();
	
		
		
		/**검색시도**/
		String searchHname = request.getParameter("tag");
		System.out.println("tag: "+ searchHname);
		if(searchHname != null) {//검색이면
			//hname으로 clubList 찾기
			
			List<Long> clubIdList = manager.findClubByHashtag(searchHname);
			System.out.println("clubIdList.size(): "+ clubIdList.size());
			for (int j = 0; j < clubIdList.size(); j++) {//클럽 아이디로 클럽 리스트 반환
				club = manager.findClub(clubIdList.get(j));
				//System.out.println("clubIdList.size(): "+ clubIdList.size());
				clubList.add(club);//측정 해시태그 가진 리스트 받아오기
			}
			//manager.searchClubList()
		} 
		else {//검색 아니면
			clubList = manager.findClubList();//전체 리스트 받아오기
		}
		
		/**클럽 정보**/
		for (int i = 0; i < clubList.size(); i++) {		
			long clubId = clubList.get(i).getClubId();
			
			if(userId == clubList.get(i).getLeader()) { //리더이면
				myClubList.add(clubList.get(i));}
			else {
				if(manager.isMember(userId, clubList.get(i).getClubId())) {//그룹원이면
						joinedClubList.add(clubList.get(i));
				}
				else //그룹원이 아니면
					otherClubList.add(clubList.get(i));
			}
			
			/**클럽아이디 + 해시태그**/
				List<HashtagDTO> hashTagList = new ArrayList<HashtagDTO>();
				hashtagList = manager.findHashtagbyClubId(clubId);
				
				String hashtag = String.join(", ", hashtagList);
				//System.out.println("string:" + hashtagList);
				hashtags.put(clubId, hashtag);
				
			/**클럽아이디 + 유저리스트**/
				List<UserDTO> memberList = new ArrayList<UserDTO>();
				List<Long> memberIdList = manager.findMembersByClubId(clubId);//그룹원 id리스트 받아옴
				
				long leaderId = clubList.get(i).getLeader();
				memberList.add(userManager.findUser(leaderId));//리더
				
				for (int j = 0; j < memberIdList.size(); j++) {
					UserDTO user = userManager.findUser(memberIdList.get(j));
					memberList.add(user);
				}

				members.put(clubId, memberList);
		}
		
		request.setAttribute("hashtags", hashtags);
		
		request.setAttribute("members", members);
		request.setAttribute("myClubList", myClubList);
		request.setAttribute("joinedClubList", joinedClubList);
		request.setAttribute("clubList", otherClubList);
	
		request.setAttribute("page", "group/groupList.jsp");
		return "/index.jsp";
	}
	
	
}

