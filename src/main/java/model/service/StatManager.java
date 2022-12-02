package model.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import model.dao.StatDAO;
import model.dto.StatDTO;

public class StatManager {
	private static StatManager statMan = new StatManager();
	private StatDAO statDAO;
	LocalDate today = LocalDate.now();
	
	private StatManager() {
		try {
			statDAO = new StatDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public static StatManager getInstance() {
		return statMan;
	}

	//오류난 부분 일단 주석처리
	public int create(StatDTO stat) throws SQLException {

		return statDAO.create(stat);
	}

	public int update(StatDTO stat) throws SQLException {
		
		return statDAO.update(stat);
	}	
	
	/* mypageController */
	public List<StatDTO> readNutri(long userId) throws SQLException {
		// Nutri 정보가 있는 stat만 모아서 return
		return statDAO.nutriStatList(userId);
	}
	public List<StatDTO> readWeight(long userId) throws SQLException {
		// weight 정보가 있는 stat만 모아서 return
		return statDAO.weightStatList(userId);
	}
	
	/* UserStatUpdateController */
	public void addWeightStat(long userId, Date date, float weight) {
		// (userID, date)가 기본 키인 레코드가 있으면 해당 레코드에 업데이트
		// 없으면 새로 만듦
	} 
	
//	public int delete(StatDTO stat) {
	
//	return statDAO.delete(stat.getUserId(), stat.getDate());	//DAO에 주석처리된 메소드 사용
//}

//public int read() throws SQLException {
//	return 0;
	
//	return StatDAO.read();	//메소드 없음
//}
}