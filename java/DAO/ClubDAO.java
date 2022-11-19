package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.BelongDTO;
import DTO.ClubDTO;
import DTO.HashtagDTO;

public class ClubDAO {
	private JDBCUtil jdbcUtil = null;

	public ClubDAO() {
 		jdbcUtil = new JDBCUtil();
 	}

	/* 그룹 레코드 생성 */
	public int createClub(ClubDTO club) throws SQLException {
		String sql = "INSERT INTO CLUB (clubId, cname, goal, info, max_member, leader) " 
			+ "VALUE(?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {club.getClubId(), club.getCname(), club.getGoal(), club.getInfo(), club.getMax_member(), club.getLeader()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	/* 그룹 가입 */
		public int joinClup(BelongDTO belong) throws SQLException {
		String sql = "INSERT INTO BELONG (userId, clubId, joinDate) " 
			+ "VALUE(?, ?, ?)";
		Object[] param = new Object[] {belong.getClubId(), belong.getUserId(), belong.getJoinDate()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}

	/* 그룹 삭제 */
	public int removeClub(String clubId) throws SQLException {
		String sql = "DELETE FROM CLUB WHERE clubId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}

	/**
	 * 특정 group 찾기
	 */
	public ClubDTO findClub(String clubId) throws SQLException {
        String sql = "SELECT clubId, cname, goal, info, max_member, leader FROM club WHERE clubId = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						
				ClubDTO club = new ClubDTO(
					rs.getInt("clubId"),
					rs.getString("cname"),
					rs.getString("goal"),
					rs.getString("info"),
					rs.getInt("max_member"),
					rs.getInt("leader"));
				return club;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/**
	 * 전체 group 정보를 검색하여 List에 저장 및 반환 
	 */
	public List<ClubDTO> findClubList() throws SQLException {
        String sql = "SELECT clubId, cname, goal, info, max_member, leader FROM group";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<ClubDTO> clubList = new ArrayList<ClubDTO>();	
			while (rs.next()) {
				ClubDTO club = new ClubDTO(		
					rs.getInt("clubId"),
					rs.getString("cname"),
					rs.getString("goal"),
					rs.getString("info"),
					rs.getInt("max_member"),
					rs.getInt("leader"));
				clubList.add(club);			
			}		
			return clubList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	// 그룹 정보 수정
	public int updateClub(ClubDTO club) throws SQLException {
		String sql = "UPDATE club " +
					"SET cname = ?, goal = ?, info = ?" +
					"WHERE clubId = ?";

		Object[] param = new Object[] {club.getCname(), club.getGoal(), club.getInfo(), club.getLeader()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return 0;
	}

	// 현재 그룹 인원 수 출력(max를 초과하면 안 되니까)
	public int countClubMember(ClubDTO club) throws SQLException {
		int count_mem = 0;
		String sql = "SELECT COUNT(userId) FROM BELONGS WHERE clubId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {club.getClubId()});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next())
				count_mem = rs.getInt(1);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		
		return count_mem;
		
	}
	
	// hashtag 관련
	
	/* hashtag 추가 */
	public int createHashtag(HashtagDTO hashtag) throws SQLException {
		String sql = "INSERT INTO HASHTAG (clubId, hname) " 
			+ "VALUE(?, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {hashtag.getClubId(), hashtag.getHname()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return 0;
	}
	
	/* 그룹 삭제 */
	public int removeHashtag(String clubId, String hname) throws SQLException {
		String sql = "DELETE FROM CLUB WHERE clubId = ? AND hname = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});

		try {				
			int result = jdbcUtil.executeUpdate();	// delete 문 실행
			return result;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		}
		finally {
			jdbcUtil.commit();
			jdbcUtil.close();	// resource 반환
		}		
		return 0;
	}
	
	/* hashtag로 그룹 찾기 (일단 ID로만 했는데 상세정보도 select로?) */
	public HashtagDTO findClubbyHashtag(String hname) throws SQLException {
        String sql = "SELECT clubId FROM hashtag WHERE hname = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {hname});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						
				HashtagDTO hashtag = new HashtagDTO(	
					rs.getInt("clubId"),
					rs.getString("hname"));
				return hashtag;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

}


