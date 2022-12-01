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

	public int update(FeedDTO oldFeed) throws SQLException {
		//feedId가 들어옴
		
		//feed객체 아이디에 맞는 피드 객체를 받아온 후
		FeedDTO feed = feedDAO.findFeed(oldFeed.getFeedId());
		
		//변경값을 대입
		oldFeed.setPublishDate(feed.getPublishDate());
		oldFeed.setPhoto(feed.getPhoto());
		oldFeed.setContent(feed.getContent());
		
		//updateFeed에 객체를 넣어서 return
		return 0;	//임시리턴값

		
//		return feedDAO.updateFeed(feed);	//피드수정 메소드 필요함
	}	

	public int remove(FeedDTO feed) throws SQLException {
		
		return feedDAO.removeFeed(feed.getFeedId());
	}		

	public List<FeedDTO> read() throws SQLException {
		List<FeedDTO> feedList = feedDAO.findFeedList();
		
		//여기서 100개 자르기
		if (feedList.size() > 101) {
			feedList.subList(0, 101);
		}
		 
		return feedList;
	}

}