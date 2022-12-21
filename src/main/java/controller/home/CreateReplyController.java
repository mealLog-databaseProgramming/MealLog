package controller.home;

import java.sql.Date;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import controller.UserSessionUtils;
import model.service.FeedManager;
import model.service.FoodManager;
import model.service.ReplyManager;
import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.ReactDTO;
import model.dto.ReplyDTO;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateReplyController implements Controller {
	FeedManager feedManager = new FeedManager();
	ReplyManager replyManager = new ReplyManager();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		long feedId = (long) request.getAttribute("feedId");
		String content = request.getParameter("content");
		System.out.println(userId + feedId);
		
		ReplyDTO reply = new ReplyDTO(userId, feedId, content);
		
		request.setAttribute("page", "home/home.jsp");
		return "/index.jsp";
		
		//임시테스트
//		List<FeedDTO> feedList = new ArrayList<FeedDTO>();
//		
//		Date date = new Date(0);
//		FeedDTO f1 = new FeedDTO(100, 200, date, "내용1", "http1");
//		FeedDTO f2 = new FeedDTO(101, 201, date, "내용2", "http2");
//		FeedDTO f3 = new FeedDTO(102, 202, date, "내3", "http3");
//		
//		feedList.add(f1);
//		feedList.add(f2);
//		feedList.add(f3);
//		request.setAttribute("page", "home/home.jsp");
//		return "/index.jsp";
	}
}
