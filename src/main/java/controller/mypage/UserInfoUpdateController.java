package controller.mypage;

import java.io.File;
import java.util.Enumeration;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import controller.UserSessionUtils;
import model.dto.UserDTO;
import model.service.*;


public class UserInfoUpdateController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		try {
			long userId = UserSessionUtils.getLoginUserId(request.getSession());
			
			String savePath = request.getSession().getServletContext().getRealPath("resources/profile");
			MultipartRequest multi = new MultipartRequest(request, savePath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
			
			String oldFileName = multi.getFilesystemName("profile");
			File oldFile = new File(savePath +"/"+oldFileName);
			
			int pos = oldFileName.lastIndexOf(".");
			String ext = oldFileName.substring(pos+1);

			String newFileName = Long.toString(userId)+"."+ext;
		    File newFile = new File(savePath +"/"+newFileName);
		    if(newFile.exists()) newFile.delete();
		    
		    oldFile.renameTo(newFile); 
		    
			String name = multi.getParameter("name");
			String introduce = multi.getParameter("introduce");
			
			UserManager userManager = UserManager.getInstance();
			UserDTO user = userManager.findUser(userId);
			
			user.setUname(name);
			user.setProfile(newFileName);
			user.setIntroduce(introduce);
			
			userManager.update(user);
			
		} catch(Exception e) {
			System.out.println("SDDDDDDDDDDDDDDDDDDDDD" + e);
		}
		
		return "redirect:/mypage";
	}

}
