// FeedDAO

package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.ReactDTO;
import model.dto.ReplyDTO;
import model.dto.UserDTO;

public class FeedDAO {
	
	private JDBCUtil jdbcUtil = null;
	
	public FeedDAO() {			
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성
	}


	// 피드 추가
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

	// 반응 추가
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

	// 피드 음식 추가
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

	// 댓글 추가
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

	// 피드 삭제 (+댓글도 삭제되도록 추가 수정 해봄)
	public int removeFeed(long feedId) throws SQLException {
		String sql = "DELETE FROM FEED WHERE feedId = ?"
				+ "DELETE FROM reply WHERE feedId = ?";
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

	// 반응 삭제
	public int removeReact(long feedId, long userId) throws SQLException {
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

	// 댓글 삭제
	public int removeReply(long replyId) throws SQLException {
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

	
	// 피드 음식 삭제
	public int removeFood(long foodId) throws SQLException {
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

	// 특정 피드 출력
	public FeedDTO findFeed(long feedId) throws SQLException {
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

	// 최신 100개의 피드 리스트
	public List<FeedDTO> findFeedList() throws SQLException {
        String sql = "SELECT feedId, userId, publishDate, content, photo " 
     		   + "FROM FEED "
     		   + "ORDER BY publishDate" 
     		   + "WHERE ROWNUM < 101";
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
	
	// 페이지를 이용해 최신 100개의 피드(일단 교수님거 복붙)
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

	// 긍정적 반응 수
	public int countPositiveReact(long feedId) throws SQLException {
		String sql = "SELECT COUNT(userId) FROM REACT WHERE feedId = ? AND type = \'P\'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정

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

	// 부정적 반응 수
	public int countNegativeReact(long feedId) throws SQLException {
		String sql = "SELECT COUNT(userId) FROM REACT WHERE feedId = ? AND type = \'N\'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정

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
	public UserDTO findUname(long userId) throws SQLException {
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
	
	// 유저의 피드 리스트
	public List<FeedDTO> findFeedListbyUser(long userId) throws SQLException {
        String sql = "SELECT feedId, userId, publishDate, content, photo FROM FEED WHERE userid = ? ORDER BY publishDate";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

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
	
	// 피드 별 전체 댓글
	public List<ReplyDTO> replyList(long feedId) throws SQLException {
        String sql = "SELECT content, feedId, publishDate, replyId, userId FROM Reply WHERE feedId = ? ORDER BY publishDate";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();				
			List<ReplyDTO> replyList = new ArrayList<ReplyDTO>();	
			while (rs.next()) {
				ReplyDTO reply = new ReplyDTO(	
					rs.getLong("replyId"),		
					rs.getString("content"),
					rs.getDate("publishDate"),
					rs.getLong("feedId"),
					rs.getLong("userId"));	
				replyList.add(reply);				
			}		
			return replyList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}

	// 피드별 전체 푸드 리스트
	public List<FoodDTO> findFoodList(long feedId) throws SQLException {
        String sql = "SELECT foodId, feedId, fname, kcal, carb, protein, fat FROM FOOD WHERE feedid = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<FoodDTO> foodList = new ArrayList<FoodDTO>();
			while (rs.next()) {						
				FoodDTO food = new FoodDTO(		
					rs.getLong("foodId"),
					rs.getLong("feedId"),
					rs.getString("fname"),
					rs.getFloat("kcal"),
					rs.getFloat("carb"),
					rs.getFloat("protein"),
					rs.getFloat("fat"));
				foodList.add(food);
			}
			return foodList;
		} catch (Exception ex) { 
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	
}

