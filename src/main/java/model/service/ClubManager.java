package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.ClubDAO;
import model.dto.BelongDTO;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
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

	public static ClubManager getInstance() {
		return ClubMan;
	}

	public int create(ClubDTO club, HashtagDTO hashtag) throws SQLException, ExistingUserException {

		if(clubDAO.existClub(club.getCname())==true){
			throw new ExistingUserException(club.getCname() + "는 이미 사용중인 이름입니다.");
		}
		return clubDAO.createClub(club);
	}

	public int update(ClubDTO club) throws SQLException, ExistingUserException {
		if(clubDAO.existClub(club.getCname())==true){
			throw new ExistingUserException(club.getCname() + "는 이미 사용중인 이름입니다.");
		}
		return clubDAO.updateClub(club);
	}	

	public int remove(long clubId) throws SQLException {
		return clubDAO.removeClub(clubId);//반환값 확인
	}		
	
	public List<ClubDTO> findClubList() throws SQLException {
		return clubDAO.findClubList();
	}

	public int joinClub(BelongDTO belong) throws SQLException, ExistingUserException {
		ClubDTO club = clubDAO.findClub(belong.getClubId());
		int maxMember = club.getMax_member();

		if(!(clubDAO.countClubMember(club) < maxMember)) {
			throw new ExistingUserException("정원 초과입니다.");
		}
		return clubDAO.joinClub(belong);
	}
	
	public void leaveClub(long deleteId, long clubId) {
		return clubDAO.removeClubMember(deleteId, clubId);
	}

	public boolean alreadyJoin(long userId, long clubId) throws SQLException {
		return clubDAO.alreadyJoin(userId, clubId);
	}
	
	public boolean isLeader(long userId, long clubId) throws SQLException {
		return clubDAO.isLeader(userId, clubId);
	}

	
	
	
}