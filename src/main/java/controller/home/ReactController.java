package controller.home;

import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.ReactDTO;
import model.dto.ReplyDTO;
import model.service.FeedManager;
import model.service.ReactManager;

// 하트 저장
@ResponseBody
@RequestMapping(value = "/newreact")
public ReactDTO saveReact(@RequestParam long feedId, HttpSession session) {
	long userId = UserSessionUtils.getLoginUserId(request.getSession());
	ReactDTO react = new ReactDTO();
	
	react.setFeedId(feedId);
	react.setUserId(userId);
	react.setType('P');
	
	return react;
}

// 하트 해제
@ResponseBody
@RequestMapping(value = "/removereact") {
public int removeReact(@RequestParam long feedId, HttpSession session) {
	long userId = UserSessionUtils.getLoginUserId(request.getSession());
	ReactManager man = new ReactManager();
	
	int result = man.remove(feedId, userId);
	return result;
}
//public class ReactController implements Controller {
	
//	@Override
//	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		
		
		//		ReactManager man = new ReactManager();
//		ReactDTO react = new ReactDTO(); // 임시
//		
//	//	Ajax에서 값 받아오기
//		
//		if (/*반응 없을 때*/) {
//		//  create React
//			man.create(react);
//		}
//		else {
//		// 	cancle React
//			man.remove(react);
//		}
//		 	
//		// redirect 하지 말고 ajax로..?
//		return "";
