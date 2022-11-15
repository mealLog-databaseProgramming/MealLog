package DTO;

import java.sql.Date;

public class ReplyDTO {
	private int replyId;
	private String content;
	private Date publishDate;
	private int feedId;
	private int userId;

	public ReplyDTO() {
		super();
	}

	public ReplyDTO(int replyId, String content, Date publishDate, int feedId, int userId) {
		super();
		this.replyId = replyId;
		this.content = content;
		this.publishDate = publishDate;
		this.feedId = feedId;
		this.userId = userId;
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
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

	public int getFeedId() {
		return feedId;
	}

	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}

	
