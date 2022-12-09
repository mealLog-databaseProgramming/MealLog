package controller.main;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.ClubDTO;
import model.dto.UserDTO;
import model.service.UserManager;

public class ClubTestController implements Controller {
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
		
		/*임시 dto*/
		
		UserManager userManager = UserManager.getInstance();
		UserDTO user1 = userManager.findUser(7);
		UserDTO user2 = userManager.findUser(8);
		
		/* hashmap */
		HashMap<Long, String> hashtags = new HashMap<Long, String>();
		HashMap<Long, List<UserDTO>> members = new HashMap<Long, List<UserDTO>>();
		
		/* 내가 만든 거 */
		List<ClubDTO> myClubList = new ArrayList<>();
		
		for(long i = 1; i <= 2; i++) {
			myClubList.add(new ClubDTO(
					i,
					"작심 3달",
					"식단 초보의 3달 도전기",
					"식단 초보입니다.\n3개월동안 식단 봐주면서 건강해지실 분들 찾아요.",
					10, 8
				));
			
			String hashtag = "식단, 단기, 다이어트";
			hashtags.put(i, hashtag);
			
			List<UserDTO> member = new ArrayList<>();
			member.add(user1); member.add(user2); member.add(user2);
			members.put(i, member);
		}
		
		/* 내가 가입한 거 */
		List<ClubDTO> joinedClubList = new ArrayList<>();
		
		for(long i = 3; i <= 4; i++) {
			joinedClubList.add(new ClubDTO(
					i,
					"작심 3달",
					"식단 초보의 3달 도전기",
					"식단 초보입니다.\n3개월동안 식단 봐주면서 건강해지실 분들 찾아요.",
					10, 8
				));
			
			String hashtag = "식단, 단기, 다이어트";
			hashtags.put(i, hashtag);
			
			List<UserDTO> member = new ArrayList<>();
			member.add(user1); member.add(user2); member.add(user2);
			members.put(i, member);
		}
		
		/* 나머지 */
		List<ClubDTO> clubList = new ArrayList<>();
		
		for(long i = 5; i <= 14; i++) {
			clubList.add(new ClubDTO(
					i,
					"작심 3달",
					"식단 초보의 3달 도전기",
					"식단 초보입니다.\n3개월동안 식단 봐주면서 건강해지실 분들 찾아요.",
					10, 8
				));
			
			String hashtag = "식단, 단기, 다이어트, ss, hh, jj, dd";
			hashtags.put(i, hashtag);
			
			List<UserDTO> member = new ArrayList<>();
			member.add(user1); member.add(user2); member.add(user2);
			members.put(i, member);
		}
		
		request.setAttribute("hashtags", hashtags);
		request.setAttribute("members", members);
		request.setAttribute("myClubList", myClubList);
		request.setAttribute("joinedClubList", joinedClubList);
		request.setAttribute("clubList", clubList);
		
		request.setAttribute("page", "group/groupList.jsp");
		return "/index.jsp";
	}
	
	
}