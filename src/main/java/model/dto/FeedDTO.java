package model.dto;

import java.sql.Date;

public class FeedDTO {
	private long userId;
	private long feedId;
	private Date publishDate;
	private String content;
	private String photo;	// 경로로 저장

	
	public FeedDTO(long userId, long feedId, Date publishDate, String content, String photo) {
		this.userId = userId;
		this.feedId = feedId;
		this.publishDate = publishDate;
		this.photo = photo;
	}

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getFeedId() {
		return feedId;
	}
	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


}
