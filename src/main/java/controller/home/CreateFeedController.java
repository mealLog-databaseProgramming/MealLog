package controller.home;


import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import model.service.FeedManager;
import model.dto.FeedDTO;

import java.io.File;
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

public class CreateFeedController implements Controller{
	SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");	
	Date time = new Date();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

//		String content = null;
//		String file = null;
//		
//		boolean check = ServletFileUpload.isMultipartContent(request);
		
		String savePath = request.getSession().getServletContext().getRealPath("resources/feed");
		System.out.println(savePath);
		//MultipartRequest multi = new MultipartRequest(request, savePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());

		return "redirect:/";
		
		
		//String content = multi.getParameter("content");
				//System.out.println(content);
				/*long feedId = Long.parseLong(request.getParameter("feedId"));
				String photo = request.getParameter("photo");
				String Date = format1.format(time);
				java.sql.Date joinDate= java.sql.Date.valueOf(Date);
				long userId = Long.parseLong(request.getParameter("userId"));
				String content = request.getParameter("content");
				
				FeedDTO feed = new FeedDTO(feedId, photo, joinDate, userId, content );	
				
				FeedManager feedManager = FeedManager.getInstance();
				feedManager.create(feed);*/
	}
}
