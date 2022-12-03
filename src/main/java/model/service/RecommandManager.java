package model.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import model.dao.JDBCUtil;
import model.dao.UserDAO;
import model.dao.StatDAO;

import model.dto.UserDTO;
import model.dto.FoodDTO;
import model.dto.StatDTO;

public class RecommandManager {
	private static RecommandManager recommMan = new RecommandManager();
	private UserDAO userDAO;
	private StatDAO statDAO;
	
	private UserDTO userDTO;
	private StatDTO statDTO;
	
	private RecommandManager() {
		try {
			userDAO = new UserDAO();
			statDAO = new StatDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public static RecommandManager getInstance() {
		return recommMan;
	}

	public float getUserEER(long userId) throws SQLException {
		//userDAO에 userId넣으면 그 유저 정보 리턴해주는 메소드 필요
		//성별, 나이, 키, 체중, 활동량
		
		//이 부분 user객체 리턴받는걸로 대체(DAO 추가시)->틀린코드야 이거
		int gender = userDTO.getGender();
		int age = userDTO.getAge();
		float height = userDTO.getHeight();
		float weight = userDTO.getWeight();
		float activeRank = userDTO.getActiveRank();
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
			EER = (float) (345 - 6.91 * age + activeRank * (9.361 * weight + 726 * height));
		}
		//성인 남성
		else if (gender == 0 && age >= 20) {
			EER = (float) (662 - 9.53 * age + activeRank * (15.91 * weight + 539.6 * height));
		}
		//미성년 여성
		else if (gender == 1 && age < 20) {
			EER = (float) (135.3 - 30.8 * age + activeRank * (10.0 * weight + 934 * height) + 10);
		}
		//미성년 남성
		else if (gender == 0 && age < 20) {
			EER = (float) (88.5 - 61.9 * age + activeRank * (26.7 * weight + 903 * height) + 10);
		} 
//		else {	//예외 case
			
//		}
		
		return EER;
	}
	
	//음식 재료 기반으로 조리음식 n개 검색 후 하나 랜덤 리턴
	//매개변수 재료, eer
	//1. 사용자가 입력한 재료를 받아온다
			//2. 입력받아온 재료로 검색
			//3. EER 안쪽으로 열량을 가진 음식이 있다면 그것을 추천
			//4. 없다면 걍 결과값에서 아무거나 출력
	//public FoodDTO recommendFood(String ingredient, float EER) {	//메소드 삭제, js에서 진행
		// FoodDTO foodDTO = new FoodDTO();
		
		//예외처리 : 결과값이 없음.(ex)'궯둛' 입력)
		
		//api 호출 및 파싱(최대 100개의 결과)
		
		//for문 돌면서 열량이 목표치 안에 있는 음식 골라내기
		
		//있다면 -> 랜덤 돌려서 나온 음식 dto에 값 저장
		
		//목표치 안에 드는 음식 없다면 -> 전체 결과값 중 랜덤 돌려서 dto에 저장 후 리턴
		
		//return foodDTO;
	//}
	
	//그날 필요한 stat의 퍼센트를 구한다.
	public StatDTO getStatPerToday(Date today, float EER) {
		StatDTO stat = new StatDTO();
//		stat = statDAO.getStatToday(today);	//추가해야할 메소드(stat리스트를 가져옴)
		//가장 최근 stat정보만 잘라서 밑의 과정 수행
		
		//하루치의 stat객체
		float kcal = stat.getKcal();
		float carb = stat.getCarb();
		float protein = stat.getProtein();
		float fat = stat.getFat();
		
		//퍼센트를 구하여 stat객체에 set
		stat.setKcal(kcal / EER);
		stat.setCarb(carb / EER);
		stat.setProtein(protein / EER);
		stat.setFat(fat / EER);
		
		return stat;
	}
}