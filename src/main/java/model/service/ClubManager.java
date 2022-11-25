package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ClubDAO;
import model.dto.ClubDTO;

public class ClubManager {
	private static ClubManager ClubMan = new ClubManager();
	private ClubDAO clubDAO;
	
	private ClubManager() {
		try {
			clubDAO = new ClubDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public ClubManager getInstance() {
		return ClubMan;
	}

	//오류난 부분 일단 주석처리
	public int create(ClubDTO club) throws SQLException {

		return clubDAO.createClub(club);
	}

	public int update(ClubDTO club) throws SQLException {
		
		return clubDAO.updateClub(club);
	}	

	public int remove(ClubDTO club) throws SQLException {

		return clubDAO.removeClub(club.getClubId());
	}		

	public List<ClubDTO> read() throws SQLException {
//		return 0;
		
		return clubDAO.findClubList();
	}

}