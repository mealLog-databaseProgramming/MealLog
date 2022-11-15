package DTO;

public class ReactDTO {
	private int userId;
	private int feedId;
	private String type;
	
	public ReactDTO() {
		super();
	}
	
	public ReactDTO(int userId, int feedId, String type) {
		this.userId = userId;
		this.feedId = feedId;
		this.type = type;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
