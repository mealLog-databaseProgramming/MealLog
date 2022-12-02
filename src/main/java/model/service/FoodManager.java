package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.FeedDAO;
import model.dto.FoodDTO;
import model.dto.FeedDTO;

public class FoodManager {
	private static FoodManager foodMan = new FoodManager();
	private FeedDAO feedDAO;
	//private FoodDTO food;
	//private FeedDTO feed;
	
	public FoodManager() {
		try {
			feedDAO = new FeedDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static FoodManager getInstance() {
		return foodMan;
	}
	
	public int create(FoodDTO food) throws SQLException {
		return feedDAO.createFood(food);
	}
	
	// update X
	
	public int remove(long foodId) throws SQLException {
		return feedDAO.removeFood(foodId);
	}

	public List<FoodDTO> findFoodList(long feedId) throws SQLException {
		return feedDAO.findFoodList(feedId); 
	}
}
