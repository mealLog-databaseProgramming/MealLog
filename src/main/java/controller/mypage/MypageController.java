package controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class MypageController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String editmode = request.getParameter("edit");
		
		
		if (editmode != null)
			request.setAttribute("edit", true);
		else
			request.setAttribute("edit", false);
		
		request.setAttribute("page", "mypage/mypage.jsp");
		return "/index.jsp";
	}

}
