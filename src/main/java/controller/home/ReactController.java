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

public class ReactController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReactManager man = new ReactManager();
		ReactDTO react = new ReactDTO(); // 임시
	//	구현 실패...	
		
	//	Ajax에서 값 받아오기
		
//		if (/*반응 없을 때*/) {
//		//  create React
//			man.create(react);
//		}
//		else {
//		// 	cancle React
//			man.remove(react);
//		}
		 	
		// redirect 하지 말고 ajax로..?
		return "";
	}

}
