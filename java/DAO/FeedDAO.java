// FeedDAO

package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.FeedDTO;
import DTO.FoodDTO;
import DTO.ReactDTO;
import DTO.ReplyDTO;
import DTO.UserDTO;

public class FeedDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public FeedDAO() {			
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성
	}


	/* CREATE feed table record */
	public int createFeed(FeedDTO feed) throws SQLException {
		String sql = "INSERT INTO Feed (feedId, userId, publishDate, content, photo) " 
			+ "VALUE(SEQUENCE_FEEDID.nextval, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {feed.getFeedId(), feed.getUserId(), feed.getPublishDate(), feed.getContent(), feed.getPhoto()};
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

	/* CREATE react table record */
	public int createReact(ReactDTO react) throws SQLException {
		String sql = "INSERT INTO REACT(feedId, userId, type) " + "VALUE(?, ?, ?)";
		Object[] param = new Object[] {react.getFeedId(), react.getUserId()};
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

		/* CREATE food table record */
	public int createFood(FoodDTO food) throws SQLException {
		String sql = "INSERT INTO Food(foodId, fname, kcal, carb, protein, fat, feedId) " 
		+ "VALUE(SEQUENCE_FOODID.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {food.getFoodId(), food.getFname(), food.getKcal(), food.getCarb(), food.getProtein(), food.getFat(), food.getFeedId()};
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

		/* CREATE comment table record */
	public int createComment(ReplyDTO reply) throws SQLException {
		String sql = "INSERT INTO Reply(replyId, content, getPublishDate, feedId, userId )" 
		+ "VALUE(SEQUENCE_REPLYID.nextval, ?, ?, ?, ?)";
		Object[] param = new Object[] {reply.getReplyId(), reply.getContent(), reply.getPublishDate(), reply.getFeedId(), reply.getUserId()};
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

	/* DELETE feed table record */
	public int removeFeed(String feedId) throws SQLException {
		// 글이 삭제되면 댓글도 함께 삭제? 아니면 데이터는 냅두고 글만 삭제?
		String sql = "DELETE FROM FEED WHERE feedId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});

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

	/* DELETE react table record */
	public int removeReact(String feedId, String userId) throws SQLException {
		String sql = "DELETE FROM REACT WHERE feedid = ? AND userId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId, userId});

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

	/* DELETE comment table record */
	public int removeReply(String replyId) throws SQLException {
		String sql = "DELETE FROM REPLY WHERE replyId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {replyId});

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

	
	/* DELETE food table record */
	public int removeFood(String foodId) throws SQLException {
		String sql = "DELETE FROM FOOD WHERE foodId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {foodId});

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

	/* 주어진 feedId에 해당하는 feed 정보를 DB에서 찾아 feed 도메인 클래스에 저장하여 반환
	 * -> 상세 페이지 출력 때 이용
	 */
	public FeedDTO findFeed(String feedId) throws SQLException {
        String sql = "SELECT userId, publishDate, content, photo "
        			+ "FROM feed "
        			+ "WHERE feedId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {						
				FeedDTO feed = new FeedDTO(
						rs.getLong("userId"),
						rs.getLong("feedId"),
						rs.getDate("publishDate"),
						rs.getString("content"),
						rs.getString("photo"));
				return feed;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	/*
	 * 전체 feed 정보를 검색하여 List에 저장 및 반환 -> Home 에서 이용
	 */
	public List<FeedDTO> findFeedList() throws SQLException {
        String sql = "SELECT feedId, userId, publishDate, content, photo, FROM FEED ORDER BY publishDate";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();				
			List<FeedDTO> feedList = new ArrayList<FeedDTO>();	
			while (rs.next()) {
				FeedDTO feed = new FeedDTO(	
					rs.getLong("userId"),		
					rs.getLong("feedId"),
					rs.getDate("publishDate"),
					rs.getString("content"),
					rs.getString("photo"));	
				feedList.add(feed);				
			}		
			return feedList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
	/*
	 * 전체 사용자 정보를 검색한 후 현재 페이지와 페이지당 출력할 사용자 수를 이용하여
	 * 해당하는 사용자 정보만을 List에 저장하여 반환. -> 이용하여 홈에서 100개의 피드만 출력
	 * 교수님은 페이지를 하셨는데 우리는 정확한 페이지가 없으므로 상위 100개..?
	 */
	public List<FeedDTO> homeFeedList(int currentPage, int countPerPage) throws SQLException {
        String sql = "SELECT feedId, userId, publishDate, content, photo " 
        		   + "FROM FEED "
        		   + "ORDER BY publishDate" 
        		   + "WHERE ROWNUM < 101";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<FeedDTO> feedList = new ArrayList<FeedDTO>();
			while (rs.next()) {						
				FeedDTO feed = new FeedDTO(		
					rs.getLong("userId"),
					rs.getLong("feedId"),
					rs.getDate("publishDate"),
					rs.getString("content"),
					rs.getString("photo"));
				feedList.add(feed);
			}
			return feedList;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	public int countPositiveReact(ReactDTO react) throws SQLException {
		String sql = "SELECT COUNT(userId) FROM REACT WHERE feedId = ? AND type = \'P\'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {react.getFeedId()});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate();	
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}

	public int countNegativeReact(ReactDTO react) throws SQLException {
		String sql = "SELECT COUNT(userId) FROM REACT WHERE feedId = ? AND type = \'N\'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {react.getFeedId()});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			int result = jdbcUtil.executeUpdate();	
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		
		return 0;
	}
	
	// uid로 uname 찾기(feed와 comment에서 이름을 보여주기 위해)
	public UserDTO findUname(int userId) throws SQLException {
		String sql = "SELECT uname "
	        		+ "FROM UserInfo "
			        + "WHERE userId=? ";   
		
		Object[] param = new Object[] {userId};
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			if (rs.next()) {						// 비밀번호 정보 발견
				UserDTO user = new UserDTO(rs.getInt("userID"));
				return user; 
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		} 
		return null;
	}
}

