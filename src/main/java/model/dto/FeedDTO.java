package model.dto;

import java.util.Date;

public class FeedDTO {
	private long feedId;
	private String photo;	// 경로로 저장
	private Date publishDate;
	private long userId;
	private String content;

	public FeedDTO(long feedId, String photo, Date publishDate, long userId, String content) {
		this.feedId = feedId;
		this.photo = photo;
		this.publishDate = publishDate;
		this.userId = userId;
		this.content = content;
	}
	public FeedDTO(String photo, Date publishDate, long userId, String content) {
		this.photo = photo;
		this.publishDate = publishDate;
		this.userId = userId;
		this.content = content;
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
