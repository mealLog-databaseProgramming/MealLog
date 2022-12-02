/*
 * 네이버지도api -> 주소가입, qr 결제, 구글 api 이용하여 이미지 텍스트 인식
 * 
 * */

package model.service;

import java.sql.SQLException;

import java.util.List;

import model.dao.FeedDAO;
import model.dto.FeedDTO;
import model.dto.ReplyDTO;

public class ReplyManager {
	private static ReplyManager replyMan = new ReplyManager();
	private FeedDAO FeedDAO;
	
	public ReplyManager() {
		try {
			FeedDAO = new FeedDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
  
	public ReplyManager getInstance() {
		return replyMan;
	}

	public int create(ReplyDTO reply) throws SQLException {
		return FeedDAO.createComment(reply);
	}

	//댓글 수정 없음(update)
	
	public int remove(ReplyDTO reply) throws SQLException {
		
		return FeedDAO.removeReply(reply.getReplyId());
	}
	
	public List<ReplyDTO> display(long feedId) throws SQLException {
		return FeedDAO.replyList(feedId);
	}
	
	
}