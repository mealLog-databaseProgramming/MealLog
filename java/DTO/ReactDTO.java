package DTO;

public class ReactDTO {
	private long userId;
	private long feedId;
	private String type;
	
	public ReactDTO() {
		super();
	}
	
	public ReactDTO(long userId, long feedId, String type) {
		this.userId = userId;
		this.feedId = feedId;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
