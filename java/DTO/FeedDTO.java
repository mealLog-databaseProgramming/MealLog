package DTO;

import java.sql.Date;

public class FeedDTO {
	private int userId;
	private int feedId;
	private Date publishDate;
	private String content;
	private String photo;	// 경로로 저장

	public FeedDTO() {
		super();
	}

	public FeedDTO(int userId, int feedId, Date publishDate, String content, String photo) {
		super();
		this.userId = userId;
		this.feedId = feedId;
		this.publishDate = publishDate;
		this.content = content;
		this.photo = photo;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFeedId() {
		return feedId;
	}
	public void setFeedId(int feedId) {
		this.feedId = feedId;
	}

	public Date getPublishDate() {
		return publishDate;
	}
	public void setPulishDate(Date publishDate) {
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
