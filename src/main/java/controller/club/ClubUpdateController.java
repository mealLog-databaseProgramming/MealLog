package controller.club;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
import model.dto.UserDTO;
import model.service.ClubManager;
import model.service.UserManager;
import util.TagifyParser;

public class ClubUpdateController implements Controller {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<HashtagDTO> hashtagList = new ArrayList<HashtagDTO>();
		long userId = UserSessionUtils.getLoginUserId(request.getSession());

		long clubId = Long.parseLong(request.getParameter("clubId"));
		String cname = request.getParameter("cname");
		System.out.println("cname: " +cname);
		String goal =  request.getParameter("goal");
		String info =  request.getParameter("info");
		
		ClubManager clubManager = ClubManager.getInstance();
		ClubDTO club = new ClubDTO(clubId, cname, goal, info);
		//hashtag
		String inputHashtagList = request.getParameter("hname") ;//사용자가 입력한 해시태그값(string)의 리스트
		clubManager.removeHashtag(clubId);
		List<String> hlist = TagifyParser.parseStrings(inputHashtagList);
		for (int i = 0; i < hlist.size(); i++) {
			HashtagDTO hashtag = new HashtagDTO(clubId, hlist.get(i));
			hashtagList.add(hashtag);	
		}		
		
		clubManager.createHashtag(hashtagList);
		
		UserManager userManager = UserManager.getInstance();
		/**클럽아이디 + 유저리스트**/		
		//List<UserDTO> memberList = new ArrayList<UserDTO>();
		List<Long> oldMemberIdList = clubManager.findMembersByClubId(clubId);//그룹원 id리스트 받아옴-DB저장된애
		for (int j = 0; j < oldMemberIdList.size(); j++) {
			System.out.println("memberIdList " + oldMemberIdList.get(j));
		}
		List<Long> neweMemberIdList = TagifyParser.parseIds(request.getParameter("member"));
		for (int j = 0; j < neweMemberIdList.size(); j++) {
			System.out.println("updateMemberIdList " + neweMemberIdList.get(j));
		}
		oldMemberIdList.removeAll(neweMemberIdList);
		System.out.println("removeAll " + oldMemberIdList.toString());

		for (int j = 0; j < oldMemberIdList.size(); j++) {
			clubManager.removeClubMember(oldMemberIdList.get(j), clubId);
		}
		
		try {
			System.out.println("try start");
			clubManager.update(club);
			
		} catch(Exception e) {
			request.setAttribute("message", e.getMessage());
		}
		
		return "redirect:/group";
	}
}
