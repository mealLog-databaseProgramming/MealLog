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

public class TempClubController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로

		//long userId = UserSessionUtils.getLoginUserId(request.getSession());
		//hashMap
		List<Map> otherClubList = new ArrayList<Map>();
		List<Map> myClubList = new ArrayList<Map>();
		List<Map> joinedClubList = new ArrayList<Map>();
		
		List<Map> hashtags = new ArrayList<Map>();
		List<Map> members = new ArrayList<Map>();
		 
		ClubManager manager = ClubManager.getInstance();
		List<ClubDTO> clubList = new ArrayList<ClubDTO>();
		List<String> hashtagList = new ArrayList<String>();
		//List<BelongDTO> memberList = new ArrayList<BelongDTO>();
		//정보 연결하려면 belong이 아니라 userDTO여야할듯..
		List<Long> memberIdList = new ArrayList<Long>();
		
		
		ClubDTO club;
		HashtagDTO hashtag;
		
		UserManager userManager = UserManager.getInstance();
		
		clubList.add(new ClubDTO(//test
					3,
					"작심 3달22",
					"식단 초보",
					"식단 초보입니다.\n3개월동안 식단 봐주면서 건강해지실 분들 찾아요.",
					10, 8
				));
	
		//clubList = manager.findClubList();//왜 null이지
			
		//클럽 정보 매핑
		/**만약 그룹원이다->근데 리더다->mygroup에 저장
		//           ->리더는 아니다->joingroup에 저장
		//속한 그룹이 아니다->그냥 그룹 리스트에 저장**/
		//System.out.println("테스트1");
		for (int i = 0; i < clubList.size(); i++) {
			//System.out.print("테스트");
			Map myClubData = new HashMap();
			Map joinedClubData = new HashMap();
			Map otherClubData = new HashMap();
			//long clubId = clubList.get(i).getClubId();
			long clubId = 1;
			long userId = 9;
			
			if(manager.isMember(userId, clubList.get(i).getClubId())) {//그룹원이면
				if(manager.isLeader(userId, clubId)) {//리더이면
					myClubData.put(clubId, clubList.get(i));
					myClubList.add(myClubData);
				}
				else {//리더가 아니면
					joinedClubData.put(clubId, clubList.get(i));
					joinedClubList.add(joinedClubData);
				}
			}
			else {//그룹원이 아니면
				otherClubData.put(clubId, clubList.get(i));
				otherClubList.add(otherClubData);
			}	
			
			//클럽아이디 + 해시태그 매핑
			//ㄴ클럽아이디가 @인 클럽의 해시태그 리스트 받아오기->리스트 매핑
			//기존 hashtagDTO 객체 -> 수정 그냥 string list
				//List<HashtagDTO> hashTagList = new ArrayList<HashtagDTO>();
				hashtagList = manager.findHashtagbyClubId(clubId);
				hashtagList.add("식사");//test
				hashtagList.add("배아파");//test
				
				Map hashtahData = new HashMap();
				hashtahData.put(clubId, hashtagList);
				hashtags.add(hashtahData);
			
			//클럽아이디 + 유저리스트 매핑
				//한번 꺾어야함..
				List<UserDTO> memberList = new ArrayList<UserDTO>();
				//memberIdList = manager.findMembersByClubId(clubId);//그룹원 id 받아옴
				memberIdList.add(clubId);//test
				//System.out.println(memberIdList.get(0));
				
				for (int j = 0; j < memberIdList.size(); j++) {//j < clubList.size();
					UserDTO user = userManager.findUser(memberIdList.get(j));
					memberList.add(user);
				}
				Map memberData = new HashMap();
				memberData.put(clubId, memberList);
				members.add(memberData);
		}
		
		request.setAttribute("myClubList", myClubList);
		request.setAttribute("joinedClubList", joinedClubList);
		request.setAttribute("clubList", otherClubList);
		request.setAttribute("hashTags", hashtags);
		request.setAttribute("members", members);
		request.setAttribute("page", "group/groupList.jsp");
		return "/index.jsp";
	}
	
	
}

