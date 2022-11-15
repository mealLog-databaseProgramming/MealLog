// CLub DAO

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.BelongDTO;
import DTO.ClubDTO;
import DTO.FeedDTO;

public class ClubDAO {
	private JDBCUtil jdbcUtil = null;

	public ClubDAO() {
 		JDBCUtil jdbcUtil = new JDBCUtil();
 	}

	/* 그룹 레코드 생성 */
	public int create_club(ClubDTO club) throws SQLException {
		String sql = "INSERT INTO Feed (clubId, cname, goal, info, hashtag, max_member, leader) " 
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
		public int join_group(BelongDTO belong) throws SQLException {
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
	public int remove(String clubId) throws SQLException {
		String sql = "DELETE FROM Group WHERE clubId = ?";
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
        String sql = "SELECT clubId, cname, goal, info, hashtag, max_member, leader FROM club WHERE clubId = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						
				ClubDTO club = new ClubDTO(	
					rs.getInt("clubId"),
					rs.getString("cname"),
					rs.getString("goal"),
					rs.getString("info"),
					rs.getString("hashtag"),
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
        String sql = "SELECT clubId, cname, goal, info, hashtag, max_member, leader FROM group";
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
					rs.getString("hashtag"),
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
	public int update(ClubDTO club) throws SQLException {
		String sql = "UPDATE club " +
					"SET cname = ?, goal = ?, info = ?, hashtag = ? " +
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
	}

	// 현재 그룹 인원 수 출력(max를 초과하면 안 되니까)
	public int count_club_mem(ClubDTO club) throws SQLException {
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

}


