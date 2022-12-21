package model.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.dao.FeedDAO;
import model.dao.JDBCUtil;
import model.dao.UserDAO;
import model.dao.StatDAO;

import model.dto.UserDTO;
import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.StatDTO;

public class RecommandManager {
	private static RecommandManager recommMan = new RecommandManager();
	private UserDAO userDAO;
	private StatDAO statDAO;
	private FeedDAO feedDAO;
	
	private UserDTO userDTO;
	private StatDTO statDTO;
	private FeedDTO feedDTO;
	
	public RecommandManager() {
		try {
			userDAO = new UserDAO();
			statDAO = new StatDAO();
			feedDAO = new FeedDAO();
			
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public static RecommandManager getInstance() {
		return recommMan;
	}

	public int test(long userId) {
		return (int) (1 + userId);
	}
	
	public float getUserEER(long userId) throws SQLException {
		//userDAO에 userId넣으면 그 유저 정보 리턴해주는 메소드 필요
		//성별, 나이, 키, 체중, 활동량
		
		userDTO = userDAO.findUser(userId);
		
		//이 부분 user객체 리턴받는걸로 대체(DAO 추가시)->틀린코드야 이거
		int gender = userDTO.getGender();
		int age = userDTO.getAge();
		float height = userDTO.getHeight();
		float weight = userDTO.getWeight();
		float activeRank = userDTO.getActiveRank();
		System.out.println(gender);
		System.out.println(age);
		System.out.println(height);
		System.out.println(weight);
		System.out.println(activeRank);
		float EER = (float) 0.0;
		
		//이거로 대체
//		UserDTO user = userDAO.readUserInfo(userId);
//		int gender = user.getGender();
//		int age = user.getAge();
//		float height = user.getHeight();
//		float weight = user.getWeight();
//		float activeRank = user.getActiveRank();
//		float EER = (float) 0.0;
		
		//성인 여성
		if (gender == 1 && age >= 20) {
			EER = (float) (345 - 6.91 * age + activeRank + (9.36 * weight + 726 + height));
		}
		//성인 남성
		else if (gender == 2 && age >= 20) {
			EER = (float) (662 - 9.53 * age + activeRank + (15.91 * weight + 539.6 + height));
		}
		//미성년 여성
		else if (gender == 1 && age < 20) {
			EER = (float) (135.3 - 30.8 * age + activeRank + (10.0 * weight + 934 + height) + 10);
		}
		//미성년 남성
		else if (gender == 2 && age < 20) {
			EER = (float) (88.5 - 61.9 * age + activeRank + (26.7 * weight + 903 + height) + 10);
		} 
		
		System.out.println("eer:" + EER);
		return EER;
	}

	public List<FeedDTO> findFeedListToday(long userId) {
		try {
			List<FeedDTO> todayFeedList = feedDAO.findFeedListToday(userId);
			return todayFeedList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<FoodDTO> findFoodList(long feedId) {
		try {
			List<FoodDTO> foodList = feedDAO.findFoodList(feedId);
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public float[] findSumFoodListToday(long userId) {
		try {
			float[] foodList = new float[4];
			foodList = feedDAO.findSumFoodListToday(userId);
			
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}