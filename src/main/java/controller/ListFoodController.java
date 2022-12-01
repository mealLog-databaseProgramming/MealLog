package controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dto.FoodDTO;
import model.service.FoodManager;

public class ListFoodController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		FoodManager manager = FoodManager.getInstance();
		long feedId = Long.parseLong(request.getParameter("feedId"));
		List<FoodDTO> foodList = manager.findFoodList(feedId);
		
		request.setAttribute("foodList", foodList);
		return "/home.jsp";
	}

}
