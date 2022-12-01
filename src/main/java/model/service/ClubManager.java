package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ClubDAO;
import model.dto.BelongDTO;
import model.dto.ClubDTO;
import model.dto.UserDTO;

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

	public int create(ClubDTO club) throws SQLException, ExistingUserException {
	//그룹이름 중복인지 검사
		if(clubDAO.existClub(club.getCname())==true){
			throw new ExistingUserException(club.getCname() + "는 존재하는 그룹입니다.");
		}
		return clubDAO.createClub(club);
	}

	public int update(ClubDTO club) throws SQLException {
		
		return clubDAO.updateClub(club);
	}	

	public int remove(long clubId) throws SQLException {

		
		return clubDAO.removeClub(clubId);
	}		
	
	public List<ClubDTO> findClubList() throws SQLException {
//		return 0;
		
		return clubDAO.findClubList();
	}

	public int joinClub(BelongDTO belong) throws SQLException {
		//정원초과 아니고 && 이미 가입된 그룹 아니면 가입 = 매니저
		ClubDTO club = clubDAO.findClub(belong.getClubId());
		int maxMember = club.getMax_member();
		
		try {
			if(!clubDAO.alreadyJoin(belong.getUserId(), belong.getClubId()) 
					&&
					clubDAO.countClubMember(club) < maxMember) {
				return clubDAO.joinClub(belong);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}//
	public int leaveClub(BelongDTO belong) {
		//이미 로그인되어있고 = 컨트롤러
		//이미 가입된 그룹이면 가입 = 매니저
		try {
			
			if(clubDAO.alreadyJoin(belong.getUserId(), belong.getClubId())){
				return clubDAO.removeClubMember(belong.getUserId());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}//
	/*
	public void findByName(ClubDTO club) {
		// TODO Auto-generated method stub
		return clubDAO.findByName();
	}
	public void findClubbyHashtag(ClubDTO club) {
		// TODO Auto-generated method stub
		return clubDAO.findByHashtag();
	}*/
	

}