package model.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
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
	
	public void updateStatList(long userId, String[] value) throws SQLException {
		statDAO.deleteByUserId(userId);
		
		for(int i = 0; i < value.length; i++) {
			String[] arr = value[i].split("/");
			Date date = Date.valueOf(arr[0]);
			float weight = Float.parseFloat(arr[1]);
			
			StatDTO stat = new StatDTO(userId, date, weight);
			create(stat);
		}
	}
	
	/* mypageController */
	public List<StatDTO> read(long userId) throws SQLException {
		// weight 정보가 있는 stat만 모아서 return
		return statDAO.statList(userId);
	}
}