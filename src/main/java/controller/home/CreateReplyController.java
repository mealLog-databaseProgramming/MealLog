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
import model.service.ReplyManager;
import model.dto.FeedDTO;
import model.dto.ReplyDTO;

import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//파일 업로드 APIs 
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.disk.*;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
//파일 용량 초과에 대한 Exception 클래스를 FileUploadBase 클래스의 Inner 클래스로 처리
import org.apache.commons.fileupload.servlet.*;

public class CreateReplyController implements Controller{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReplyManager replyManager = new ReplyManager();
		FeedManager feedManager = new FeedManager();
		
		// 넘겨야 하는 정보
		// userId 
		// content 
		// feedId
		
		if(!UserSessionUtils.hasLogined(request.getSession())) return "redirect:/login"; // 로그인된 상태가 아니면 login으로
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		System.out.println("reply 관련 : " + userId);
		
		String content = request.getParameter("r_content");
		long feedId = Long.parseLong(request.getParameter("feedId"));

		ReplyDTO reply = new ReplyDTO(content, feedId, userId);
		 
		long replyId = replyManager.create(reply);
		
		return "redirect:/";
	}
}
