package model.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dao.ClubDAO;
import model.dto.BelongDTO;
import model.dto.ClubDTO;
import model.dto.HashtagDTO;
import model.dto.UserDTO;
import model.service.exception.ExistingUserException;

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
	
	public List<Long> findMembersByClubId(long clubId) throws SQLException {
		return clubDAO.findMembersByClubId(clubId);
	}
	
	public int leaveClub(long deleteId, long clubId) throws SQLException {
		return clubDAO.removeClubMember(deleteId, clubId);
	}

	public boolean isMember(long userId, long clubId) throws SQLException {
		return clubDAO.isMember(userId, clubId);
	}
	
	public boolean isLeader(long userId, long clubId) throws SQLException {
		return clubDAO.isLeader(userId, clubId);
	}

	public List<HashtagDTO> findClubByHashtag(String tag) throws SQLException {
		
		return clubDAO.findClubByHashtag(tag);
	}

//	public List<ClubDTO> SearchClubList(List<HashtagDTO> tagList) throws SQLException {
//
//		return clubDAO.SearchClubList(tagList);
//	}
//클럽 아이디로 해시태그 찾기
	public List<String> findHashtagbyClubId(long clubId) throws SQLException {
		
		return clubDAO.findHashtagbyClubId(clubId);
	}

	public int createHashtag(List<HashtagDTO> hashtagList) throws SQLException {
		
		return clubDAO.createHashtag(hashtagList);
	}



	
	
	
}