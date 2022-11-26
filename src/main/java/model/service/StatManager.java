package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.StatDAO;
import model.dto.StatDTO;

public class StatManager {
	private static StatManager statMan = new StatManager();
	private StatDAO statDAO;
	
	private StatManager() {
		try {
			statDAO = new StatDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public StatManager getInstance() {
		return statMan;
	}

	//오류난 부분 일단 주석처리
	public int create(StatDTO stat) throws SQLException {

		return statDAO.create(stat);
	}

	public int update(StatDTO stat) throws SQLException {
		
		return statDAO.update(stat);
	}	
	
//	public int delete(StatDTO stat) {
		
//		return statDAO.delete(stat.getUserId(), stat.getDate());	//DAO에 주석처리된 메소드 사용
//	}
	
//	public int read() throws SQLException {
//		return 0;
		
//		return StatDAO.read();	//메소드 없음
//	}

}