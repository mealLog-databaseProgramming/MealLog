package model.service;

import java.sql.SQLException;

import model.dao.FeedDAO;
import model.dto.FeedDTO;
import model.dto.ReplyDTO;

public class ReplyManager {
	private static ReplyManager replyMan = new ReplyManager();
	private FeedDAO FeedDAO;
	
	private ReplyManager() {
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
	
	public int display(FeedDTO feed) throws SQLException {
		
//		return FeedDAO.모든 댓글 리스트 반환하는 dao 메소드 필요
		return 0;//임시 리턴값, 나중에는 List형 리턴으로 수정 필요
	}
}