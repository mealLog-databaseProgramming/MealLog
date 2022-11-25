package model.service;

import java.sql.SQLException;
import java.util.List;

import model.dao.JDBCUtil;
import model.dao.FeedDAO;
import model.dto.FeedDTO;

public class FeedManager {
	private static FeedManager FeedMan = new FeedManager();
	private FeedDAO feedDAO;
	
	private FeedManager() {
		try {
			feedDAO = new FeedDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public FeedManager getInstance() {
		return FeedMan;
	}

	//오류난 부분 일단 주석처리
	public int create(FeedDTO feed) throws SQLException {

		return feedDAO.createFeed(feed);
	}

	public int update(FeedDTO feed) throws SQLException {
		return 0;	//임시리턴값

		
//		return feedDAO.updateFeed(feed);	//피드수정 메소드 X
	}	

	public int remove(FeedDTO feed) throws SQLException {
		
		return feedDAO.removeFeed(feed.getFeedId());
	}		

	public List<FeedDTO> read() throws SQLException {
//		return 0;
		
		return feedDAO.findFeedList();
	}

}