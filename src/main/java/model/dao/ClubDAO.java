package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.BelongDTO;
import model.dto.ClubDTO;
import model.dto.FeedDTO;
import model.dto.HashtagDTO;

public class ClubDAO {
	private JDBCUtil jdbcUtil = null;
	private List<ClubDTO> clubList;
	private List<HashtagDTO> tagList;

	public ClubDAO() {
 		jdbcUtil = new JDBCUtil();
 	}

	/* 그룹 레코드 생성 */
	public long createClub(ClubDTO club) throws SQLException {
		String sql = "INSERT INTO CLUB (clubId, cname, goal, info, max_member, leader) " 
			+ "VALUES(SEQUENCE_CLUBID.nextval, ?, ?, ?, ?, ?, ?) ";
		
		String getClubId = "select SEQUENCE_CLUBID.currval from dual";
		Object[] param = new Object[] {club.getCname(), club.getGoal(), club.getInfo(), club.getMax_member(), club.getLeader()};
		jdbcUtil.setSqlAndParameters(sql, param);
		
		try {
			int result = jdbcUtil.executeUpdate();
			System.out.println(getClubId);
			
			jdbcUtil.setSqlAndParameters(getClubId, null);
			ResultSet rs = jdbcUtil.executeQuery();
			rs.next();
			
			long clubId = rs.getLong("CURRVAL");
			System.out.println("리턴되는 아이디" + clubId);
			return clubId;
			
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
	public int joinClub(BelongDTO belong) throws SQLException {
		String sql = "INSERT INTO BELONG (userId, clubId, joinDate) " 
			+ "VALUES(?, ?, ?) ";
		Object[] param = new Object[] {belong.getUserId(), belong.getClubId(), belong.getJoinDate()};
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
	public int removeClub(long clubId) throws SQLException {
		String sql = "DELETE FROM CLUB INNER JOIN BELONG INNER JOIN HASHTAG "
				+ "WHERE CLUB.clubID = BELONG.clubId "
				+ "AND BELONG.clubId = HASHTAG.clubId ";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});
		//club 테이블에서는 행 하나 삭제하는 건데
		//hashtag랑 belong은 clubId를 가진 행전체를 삭제해야함
		
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
	
	/* 그룹 멤버 삭제 */
	public int removeClubMember(long userId, long clubId) throws SQLException {
		String sql = "DELETE FROM BELONG WHERE userId = ? and clubId =?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, clubId});
		try {			
			System.out.println("delete");
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

	
	//특정 group 찾기
	public ClubDTO findClub(long clubId) throws SQLException {
        String sql = "SELECT clubId, cname, goal, info, max_member, leader FROM club WHERE clubId = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						
				ClubDTO club = new ClubDTO(
					rs.getLong("clubId"),
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

	//그룹 이름 중복인지 검사
	public boolean existClub(String cname) throws SQLException {
        String sql = "SELECT clubId, cname, goal, info, max_member, leader FROM club WHERE cname = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {cname});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						
				int count = rs.getInt("count");
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}
	/**리더여부확인
	public boolean isLeader(long userId, long clubId) {
		String sql = "SELECT leader "
	    			+ "FROM club "
	    			+ "WHERE clubId = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});	// JDBCUtil에 query문과 매개 변수 설정
	
		try {
			ResultSet rs = jdbcUtil.executeQuery();	// query 실행
			
			long clubLeader = rs.getLong("leader");
			//	clubLeader == userId
			System.out.println(clubLeader);
			//System.out.println(clubLeader.equals(userId));
			return ((clubLeader == userId) ? true : false);
			/**
			if (rs.next()) {						
				int count = rs.getInt("count");
				return (count == 1 ? true : false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return false;
	}**/
	//그룹 맴버인지 확인
		public boolean isMember(long userId, long clubId) throws SQLException {
	        String sql = "SELECT count(*) as count "
	        			+ "FROM belong "
	        			+ "WHERE userId = ? and clubId = ?";              
			jdbcUtil.setSqlAndParameters(sql, new Object[] {userId, clubId});	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						
					int count = rs.getInt("count");
					return (count >= 1 ? true : false);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return false;
		}
		
	//전체 group 정보를 검색하여 List에 저장 및 반환 
	public List<ClubDTO> findClubList() throws SQLException {
        String sql = "SELECT clubId, cname, goal, info, max_member, leader FROM club";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<ClubDTO> clubList = new ArrayList<ClubDTO>();	
			while (rs.next()) {
				ClubDTO club = new ClubDTO(		
					rs.getLong("clubId"),
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
	private List<ClubDTO> ListReturn(List<ClubDTO> clubList, List<HashtagDTO> tagList) {
		this.clubList = clubList;
        this.tagList = tagList;
        
		return clubList;
	}
	
	//삭제
	//특정 userId인 group 정보를 검색하여 List에 저장 및 반환 
		public List<ClubDTO> SearchClubList(List<HashtagDTO> tagList2) throws SQLException {
	        String sql = "SELECT clubId, cname, goal, info, max_member, leader, tagId, clubId, hname "
	        		+ "FROM group "
	        		+ "JOIN hashtag ON group.clubId = hashtag.clubId ";
	        //jdbcUtil.setSqlAndParameters(sql, new Object[] {UseTagList.get(1)});//UserId를 의미
			jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
						
			try {
				ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
				List<ClubDTO> clubList = new ArrayList<ClubDTO>();	
				List<HashtagDTO> tagList = new ArrayList<HashtagDTO>();	
				while (rs.next()) {
					ClubDTO club = new ClubDTO(		
						rs.getLong("clubId"),
						rs.getString("cname"),
						rs.getString("goal"),
						rs.getString("info"),
						rs.getInt("max_member"),
						rs.getInt("leader"));
					clubList.add(club);		
					
					HashtagDTO tag = new HashtagDTO(
							rs.getLong("clubId"),
							rs.getString("hname"));
					tagList.add(tag);
				}		
				return ListReturn(clubList, tagList);					
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
	

	//그룹 정보 수정
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

	//현재 그룹 인원 수 출력(max를 초과하면 안 되니까)
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
	public int createHashtag(List<HashtagDTO> hashtagList) throws SQLException {
		for(int i=0; i<5; i++) {
			String sql = "INSERT INTO HASHTAG (tagId, clubId, hname) " 
				+ "VALUE(?, ?)";
			Object[] param = new Object[] {hashtagList.get(i).getClubId()+hashtagList.get(i).getHname(),
					hashtagList.get(i).getClubId(), hashtagList.get(i).getHname()};
			jdbcUtil.setSqlAndParameters(sql, param);
		}

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
	
	/* hashtag 삭제 */
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
	
	/* 해시태그에 해당하는 그룹 아이디 리스트*/
	public List<HashtagDTO> findClubByHashtag(String hname) throws SQLException {
        String sql = "SELECT clubId FROM hashtag WHERE hname = ?";              
		jdbcUtil.setSqlAndParameters(sql, new Object[] {hname});	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();				
			List<HashtagDTO> hashtagList = new ArrayList<HashtagDTO>();	
			while (rs.next()) {
				HashtagDTO hashtag = new HashtagDTO(	
					rs.getLong("clubId"),		
					rs.getString("hname"));
				hashtagList.add(hashtag);				
			}		
			return hashtagList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/* 그룹 아이디로 해시태그 찾기 */
	public List<String> findHashtagbyClubId(long clubId) throws SQLException {
		String sql = "SELECT hname FROM hashtag WHERE clubId = ?";        
		jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();				
			List<String> hashtagList = new ArrayList<String>();	
			while (rs.next()) {
				hashtagList.add(rs.getString("hname"));				
			}		
			return hashtagList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;

	}
	
	//삭제
	//그룹별 해시태그 리스트 (그룹 아이디에 해당하는 해시태그 반환)
		public ArrayList<HashtagDTO> HashtagList(long clubId) throws SQLException {
	        String sql = "SELECT tagId, clubId, hname "
	        		+ "FROM HASHTAG "
	        		+ "WHERE clubId = ? ";
			jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
						
			try {
				ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
				ArrayList<HashtagDTO> hashtagList = new ArrayList<HashtagDTO>();	
				while (rs.next()) {
					HashtagDTO hashtag = new HashtagDTO(		
						rs.getLong("clubId"),
						rs.getString("hname"));
					hashtagList.add(hashtag);			
				}		
				return hashtagList;					
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
//
		/* 그룹 아이디로 멤버 찾기 */
		public List<Long> findMembersByClubId(long clubId) throws SQLException {
			String sql = "SELECT userId FROM belong WHERE clubId = ?";        
			jdbcUtil.setSqlAndParameters(sql, new Object[] {clubId});	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();				
				List<Long> MemberList = new ArrayList<Long>();	
				
				while (rs.next()) {
					MemberList.add(rs.getLong("userId"));				
				}		
				return MemberList;					
				
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;

		}
}


