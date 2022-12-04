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

	public int create(StatDTO stat) throws SQLException {

		return statDAO.create(stat);
	}

	public int update(StatDTO stat) throws SQLException {
		
		return statDAO.update(stat);
	}	
	
	/* mypageController */
	public List<StatDTO> read(long userId) throws SQLException {
		// weight 정보가 있는 stat만 모아서 return
		return statDAO.statList(userId);
	}
}