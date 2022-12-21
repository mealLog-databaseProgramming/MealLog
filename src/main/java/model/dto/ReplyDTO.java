package model.dto;

//import java.util.Date;
import java.sql.Date;

public class ReplyDTO {
	private long replyId;
	private String content;
	private Date publishDate;
	private long feedId;
	private long userId;

	public ReplyDTO() {
		super();
	}

	public ReplyDTO(long replyId, String content, Date publishDate, long feedId, long userId) {
		super();
		this.replyId = replyId;
		this.content = content;
		this.publishDate = publishDate;
		this.feedId = feedId;
		this.userId = userId;
	}

	public ReplyDTO(long userId, long feedId, String content) {
		this.userId = userId;
		this.feedId = feedId;
		this.content = content;
	}

	public long getReplyId() {
		return replyId;
	}

	public void setReplyId(long replyId) {
		this.replyId = replyId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public long getFeedId() {
		return feedId;
	}

	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
	
}

	
