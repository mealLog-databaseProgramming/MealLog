package controller.home;


import java.util.Date;
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
		
		//넘겨야 하는 정보
		//userId v
		//imagePath v(imagePath)
		//content v
		//foodList 해결	name=food[]
		
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		System.out.println(userId);
		
		String savePath = request.getSession().getServletContext().getRealPath("resources/feed");
		//System.out.println(savePath);
		MultipartRequest multi = new MultipartRequest(request, savePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());

		String oldFileName = multi.getFilesystemName("file");
		File oldFile = new File(savePath +"/"+oldFileName);
		//System.out.println(oldFileName);
		
		//int pos = oldFileName.lastIndexOf(".");
		//String ext = oldFileName.substring(pos+1);
		
//		String newFileName = Long.toString(userId)+"."+ext;	//feedId필요
//	    File newFile = new File(savePath +"/"+newFileName);
//	    if(newFile.exists()) newFile.delete();	//있는 파일이면 취소
//	    
//	    oldFile.renameTo(newFile); 
		
		String content = multi.getParameter("content");
		String foodData = multi.getParameter("food[]");
		String imagePath = savePath + oldFileName;
		//System.out.println(foodData);
		
		//foodList를 food객체 리스트로 가공
		String[] foodList = foodData.split(",");
		for (int i = 0; i < foodList.length; i++) {
			
		}
		
		
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
