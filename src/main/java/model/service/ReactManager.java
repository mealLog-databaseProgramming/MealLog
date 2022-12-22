package model.service;

import java.sql.SQLException;

import java.util.List;

import model.dao.FeedDAO;
import model.dto.ReactDTO;

public class ReactManager {
	private static ReactManager reactMan = new ReactManager();
	private FeedDAO feedDAO;
	
	public ReactManager() {
		try {
			feedDAO = new FeedDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
  
	public ReactManager getInstance() {
		return reactMan;
	}

	public int create(ReactDTO react) throws SQLException {
		return feedDAO.createReact(react);
	}
	
	public int remove(ReactDTO react) throws SQLException {
		
		return feedDAO.cancleReact(react.getFeedId(), react.getUserId());
	}
	
//	public List<ReactDTO> display(long feedId) throws SQLException {
//		return FeedDAO.replyList(feedId);
//	}
	
	
}