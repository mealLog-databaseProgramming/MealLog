// FeedDAO

package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
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
	public long createFeed(FeedDTO feed) throws SQLException {
		String sql = "INSERT INTO Feed (feedId, photo, publishDate, userId, content) " 
			+ "VALUES (SEQUENCE_FEEDID.nextval, ?, TO_DATE(SYSDATE, 'yy-MM-dd hh24:mi:ss'), ?, ?)";
//		String nextFeedId = "select SEQUENCE_FEEDID.nextval from dual";
		String getFeedId = "select SEQUENCE_FEEDID.currval from dual";
		Object[] param = new Object[] {feed.getPhoto(), feed.getUserId(), feed.getContent()};
		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			int result = jdbcUtil.executeUpdate();
			
			jdbcUtil.setSqlAndParameters(getFeedId, null);
			ResultSet rs = jdbcUtil.executeQuery();
			rs.next();
			long feedId = rs.getLong("CURRVAL");
			return feedId;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			System.out.println("commit!");
			jdbcUtil.close();
		}
		return 0;
	}

	// 반응 추가
	public int createReact(ReactDTO react) throws SQLException {
		String sql = "INSERT INTO REACT(feedId, userId, type) " + "VALUE(?, ?, ?)";
		Object[] param = new Object[] {react.getFeedId(), react.getUserId(), react.getType()};
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
		+ "VALUES(SEQUENCE_FOODID.nextval, ?, ?, ?, ?, ?, ?)";
		Object[] param = new Object[] {food.getFname(), food.getKcal(), food.getCarb(), food.getProtein(), food.getFat(), food.getFeedId()};
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
		Object[] param = new Object[] {reply.getContent(), reply.getPublishDate(), reply.getFeedId(), reply.getUserId()};
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
				+ "DELETE FROM reply WHERE feedId = ?"
				+ "DELETE FROM react WHERE feedId = ?";
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

//	// 반응 삭제
//	public int removeReact(long feedId, long userId) throws SQLException {
//		String sql = "DELETE FROM REACT WHERE feedid = ? AND userId = ?";
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId, userId});
//
//		try {				
//			int result = jdbcUtil.executeUpdate();	// delete 문 실행
//			return result;
//		} catch (Exception ex) {
//			jdbcUtil.rollback();
//			ex.printStackTrace();
//		}
//		finally {
//			jdbcUtil.commit();
//			jdbcUtil.close();	// resource 반환
//		}		
//		return 0;
//	} 
//
//	// 댓글 삭제
//	public int removeReply(long replyId) throws SQLException {
//		String sql = "DELETE FROM REPLY WHERE replyId = ?";
//		jdbcUtil.setSqlAndParameters(sql, new Object[] {replyId});
//
//		try {				
//			int result = jdbcUtil.executeUpdate();	// delete 문 실행
//			return result;
//		} catch (Exception ex) {
//			jdbcUtil.rollback();
//			ex.printStackTrace();
//		}
//		finally {
//			jdbcUtil.commit();
//			jdbcUtil.close();	// resource 반환
//		}		
//		return 0;
//	}
//
//	
	/* 피드 음식 삭제
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
	*/
	
	// 특정 피드 출력
	public FeedDTO findFeed(long feedId) throws SQLException {
        String sql = "SELECT feedId, photo, publishDate, userId, content"
        			+ "FROM feed "
        			+ "WHERE feedId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정
		FeedDTO feed = null;
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			if (rs.next()) {						
				feed = new FeedDTO(
						feedId,
						rs.getString("photo"),
						rs.getDate("publishDate"),
						rs.getLong("userId"),
						rs.getString("content"));
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
        String sql = "SELECT feedId, photo, publishDate, userId, content " 
     		   + "FROM FEED "
     		   + "WHERE ROWNUM < 101" 
     		   + "ORDER BY publishDate DESC";
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();				
			List<FeedDTO> feedList = new ArrayList<FeedDTO>();	
			
			while (rs.next()) {
				FeedDTO feed = new FeedDTO(	
						rs.getLong("feedId"),
						rs.getString("photo"),
						rs.getDate("publishDate"),
						rs.getLong("userId"),
						rs.getString("content"));
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
        		   + "ORDER BY publishDate DESC" 
        		   + "WHERE ROWNUM < 101";
		jdbcUtil.setSqlAndParameters(sql, null,					// JDBCUtil에 query문 설정
				ResultSet.TYPE_SCROLL_INSENSITIVE,				// cursor scroll 가능
				ResultSet.CONCUR_READ_ONLY);						
		
		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<FeedDTO> feedList = new ArrayList<FeedDTO>();
			while (rs.next()) {						
				FeedDTO feed = new FeedDTO(		
						rs.getLong("feedId"),
						rs.getString("photo"),
						rs.getDate("publishDate"),
						rs.getLong("userId"),
						rs.getString("content"));
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
		String sql = "SELECT COUNT(userId) as pcount FROM REACT WHERE feedId = ? AND type = 'P'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			int pcount = 0;
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			while (rs.next())
				pcount = rs.getInt("pcount");
			return pcount;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return 0;
	}

	// 부정적 반응 수
	public int countNegativeReact(long feedId) throws SQLException {
		String sql = "SELECT COUNT(userId) as ncount FROM REACT WHERE feedId = ? AND type = 'N'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			int ncount = 0;
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			while (rs.next())
				ncount = rs.getInt("ncount");
			return ncount;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		
		return 0;
	}
	
	// 마이페이지 : 그동안 받은 up 개수
	public int countPositiveReactbyUser(long userId) throws SQLException {
		String sql = "SELECT COUNT(*) as result FROM REACT WHERE feedId IN (SELECT feedId FROM FEED WHERE userId = ?) AND type = 'P'";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});
		
		try {
			int result = 0;
			ResultSet rs = jdbcUtil.executeQuery();
			while (rs.next())
				result = rs.getInt("result");
			return result;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		
		return 0;
	}
	
	// 마이페이지 : 그동안 작성한 피드 개수
	public int countFeedbyUser(long userId) throws SQLException {
		String sql = "SELECT COUNT(*) as result FROM FEED WHERE userId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	
		
		try {
			int result = 0;
			ResultSet rs = jdbcUtil.executeQuery();
			while (rs.next())
				result = rs.getInt("result");
			return result;
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();
		}
		return 0;
		
	} 
	
	// 마이페이지&추천 페이지 : 당일 사용자 피드 출력
		public List<FeedDTO> findFeedListToday(long userId) throws SQLException {
	        String sql = "SELECT feedId, photo, publishDate, userId, content " 
	     		   + "FROM FEED "
	     		   + "WHERE userId = ? AND (publishDate >= TO_CHAR(SYSDATE, 'YYYYMMDD'))" 
	     		   + "ORDER BY publishDate DESC";
			jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});		// JDBCUtil에 query문 설정
						
			try {
				ResultSet rs = jdbcUtil.executeQuery();				
				List<FeedDTO> feedList = new ArrayList<FeedDTO>();	
				
				while (rs.next()) {
					FeedDTO feed = new FeedDTO(	
							rs.getLong("feedId"),
							rs.getString("photo"),
							rs.getDate("publishDate"),
							userId,
							rs.getString("content"));
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

		// 추천 페이지 : 당일 사용자 식단
		public List<FoodDTO> findFoodListToday(long userId) throws SQLException {
			String sql = "SELECT food.foodId, food.fname, food.kcal, food.carb, food.protein, food.fat " 
			     		   + "FROM FOOD food, Feed feed"
			     		   + "WHERE userId = ? AND (publishDate >= TO_CHAR(SYSDATE - 1, 'YYYYMMDD')) AND food.feedId = feed.feedId";
			jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});		// JDBCUtil에 query문 설정
								
			try {
				ResultSet rs = jdbcUtil.executeQuery();				
				List<FoodDTO> foodList = new ArrayList<FoodDTO>();	
				
				while (rs.next()) {
					FoodDTO food = new FoodDTO(	
							rs.getLong("foodId"),
							rs.getString("fname"),
							rs.getFloat("kcal"),
							rs.getFloat("carb"),
							rs.getFloat("protein"),
							rs.getFloat("fat"),
							rs.getLong("feedId"));
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
		
		// 추천 페이지 : 당일 사용자 식단 값 합계
		public float[] findSumFoodListToday(long userId) throws SQLException {
			String sql = "SELECT SUM(food.kcal) as sumKcal, SUM(food.protein) as sumProtein, SUM(food.carb) as sumCarb, SUM(food.fat) as sumFat "
			     		   + "FROM FOOD food, Feed feed "
			     		   + "WHERE userId = ? AND (publishDate >= TO_CHAR(SYSDATE, 'YYYYMMDD')) AND food.feedId = feed.feedId";
			jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});		// JDBCUtil에 query문 설정
								
			try {
				float sumKcal = 0;
				float sumProtein = 0;
				float sumCarb = 0;
				float sumFat = 0;

				ResultSet rs = jdbcUtil.executeQuery();
				float[] foodList = new float[4];
				
				while (rs.next()) {
						sumKcal = rs.getFloat("sumKcal");
						sumProtein = rs.getFloat("sumProtein");
						sumCarb = rs.getFloat("sumCarb");
						sumFat = rs.getFloat("sumFat");
						
						foodList[0] = sumKcal;
						foodList[1] = sumProtein;
						foodList[2] = sumCarb;
						foodList[3] = sumFat;
				}

					return foodList;					
				} catch (Exception ex) {
						ex.printStackTrace();
				} finally {
					jdbcUtil.close();		// resource 반환
			}
			return null;
		}
		
		// 마이페이지 : 사용자 최근 100개의 피드의 영양 리스트
				public float[] findSumFoodList(long userId) throws SQLException {
					String sql = "SELECT SUM(protein) as sumProtein, SUM(carb) as sumCarb, SUM(fat) as sumFat "
							+ "FROM food food, (SELECT * FROM feed ORDER BY PUBLISHDATE) feed "
							+ "WHERE feed.userId = ? AND food.feedId = feed.feedId AND ROWNUM <= 100";
					jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});		// JDBCUtil에 query문 설정
										
					try {
						float sumProtein = 0;
						float sumCarb = 0;
						float sumFat = 0;

						ResultSet rs = jdbcUtil.executeQuery();
						float[] foodList = new float[3];
						
						while (rs.next()) {
								sumProtein = rs.getFloat("sumProtein");
								sumCarb = rs.getFloat("sumCarb");
								sumFat = rs.getFloat("sumFat");
								
								foodList[0] = sumProtein;
								foodList[1] = sumCarb;
								foodList[2] = sumFat;
								
						}
							return foodList;					
						} catch (Exception ex) {
								ex.printStackTrace();
						} finally {
							jdbcUtil.close();		// resource 반환
					} 
					return null;
				}
				
	// uid로 uname 찾기(feed와 comment에서 이름을 보여주기 위해)
	public String findUname(long userId) throws SQLException {
		String sql = "SELECT uname "
	        		+ "FROM UserInfo "
			        + "WHERE userId=? ";   
		
		Object[] param = new Object[] {userId};
		jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정
		
		try {
			String uname = null;
			ResultSet rs = jdbcUtil.executeQuery();		// query 실행
			while (rs.next())
				uname = rs.getString("uname");
			return uname;
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		} 
		return null;
	}
	// 유저의 피드 리스트
	public List<FeedDTO> findFeedListbyUser(long userId) throws SQLException {
        String sql = "SELECT feedId, photo, publishDate, userId, content FROM FEED WHERE userid = ? ORDER BY publishDate DESC";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<FeedDTO> feedList = new ArrayList<FeedDTO>();
			while (rs.next()) {						
				FeedDTO feed = new FeedDTO(		
					rs.getLong("feedId"),
					rs.getString("photo"),
					rs.getDate("publishDate"),
					rs.getLong("userId"),
					rs.getString("content"));
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
        String sql = "SELECT content, feedId, publishDate, replyId, userId FROM Reply WHERE feedId = ? ORDER BY publishDate DESC";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();				
			List<ReplyDTO> replyList = new ArrayList<ReplyDTO>();	
			while (rs.next()) {
				ReplyDTO reply = new ReplyDTO(	
					rs.getLong("replyId"),		
					rs.getString("content"),
					rs.getDate("publishDate"),
					feedId,
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
        String sql = "SELECT foodId, fname, kcal, carb, protein, fat, feedId FROM FOOD WHERE feedId = ?";
		jdbcUtil.setSqlAndParameters(sql, new Object[] {feedId});	// JDBCUtil에 query문과 매개 변수 설정

		try {
			ResultSet rs = jdbcUtil.executeQuery();	
			List<FoodDTO> foodList = new ArrayList<FoodDTO>();
			while (rs.next()) {						
				FoodDTO food = new FoodDTO(
						rs.getLong("foodId"),
						rs.getString("fname"),
						rs.getFloat("kcal"),
						rs.getFloat("carb"),
						rs.getFloat("protein"),
						rs.getFloat("fat"),
						feedId);
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

