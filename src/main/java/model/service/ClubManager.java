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
	//특정 그룹 출력
		//검색어 포함 그룹 출력
		//해시태그 포함 그룹 출력
		//전체그룹 리스트 출력
	//그룹이름 중복인지 검사
	//
	public static ClubManager getInstance() {
		return ClubMan;
	}

	//오류난 부분 일단 주석처리
	public int create(ClubDTO club) throws SQLException {
		//그룹이름 중복인지 검사
		if(existingGroup())
		return clubDAO.createClub(club);
	}

	public int update(ClubDTO club) throws SQLException {
		
		return clubDAO.updateClub(club);
	}	

	public int remove(long clubId) throws SQLException {

		
		return clubDAO.removeClub(club.getClubId());
	}		
	//특정 그룹 출력
	//검색어 포함 그룹 출력
	//해시태그 포함 그룹 출력
	//전체그룹 리스트 출력
	public List<ClubDTO> findClubList() throws SQLException {
//		return 0;
		
		return clubDAO.findClubList();
	}
	
	public ClubDTO existingGroup() throws SQLException {
			
		return clubDAO.findClubList();
	}

}