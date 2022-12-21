package controller.home;


import java.sql.Timestamp;
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
import model.dto.FeedDTO;
import model.dto.FoodDTO;

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
//	SimpleDateFormat format1 = new SimpleDateFormat ("yyyy-MM-dd");	
//	String now = format1.format(new java.util.Date());
//	java.sql.Date publishDate = java.sql.Date.valueOf(now);
	
	FeedManager feedManager = new FeedManager();
	FoodManager foodManager = new FoodManager();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//넘겨야 하는 정보
		//userId v
		//imagePath v(imagePath)
		//content v
		//foodList 해결	name=food[]
		
		long userId = UserSessionUtils.getLoginUserId(request.getSession());
		System.out.println(userId);
		
		String savePath = request.getSession().getServletContext().getRealPath("resources/feed");
		File dir = new File(savePath);			
					
		if (!dir.exists()) dir.mkdir();  // 전송된 파일을 저장할 폴더 생성
		
		MultipartRequest multi = new MultipartRequest(request, savePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());

		String oldFileName = multi.getFilesystemName("file");
		File oldFile = new File(savePath +"/"+oldFileName); 
		
		String content = multi.getParameter("content");
		String foodData = multi.getParameter("food[]");
		String imageName = oldFileName;
//		System.out.println(userId);
//		System.out.println(imagePath);
//		System.out.println(publishDate);
		System.out.println(content);
		
		FeedDTO feed = new FeedDTO(imageName, userId, content);
		
		//imagePath가 너무 길다. 파일 이름만 남기고 저장해야할듯(식별값
		long feedId = feedManager.create(feed);
		
		//foodList를 food객체 리스트로 가공
		System.out.println(feedId);
		String[] foodList = foodData.split(",");
		for (int i = 0; i < foodList.length; i++) {
			String[] foodInfo = foodList[i].split("/");
			
			String fName = foodInfo[0];
			float kcal = Float.parseFloat(foodInfo[1]);
			float carb = Float.parseFloat(foodInfo[2]);
			float protein = Float.parseFloat(foodInfo[3]);
			float fat = Float.parseFloat(foodInfo[4]);
			System.out.println(fName + ", " + kcal + ", " + carb + ", " + protein + ", " + fat);
			
			FoodDTO food = new FoodDTO(fName, kcal, carb, protein, fat, feedId);
			foodManager.create(food);
		}
		
		return "redirect:/";
	}
}
