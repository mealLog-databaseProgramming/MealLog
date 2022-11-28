package model.dto;

import java.sql.Date;

public class BelongDTO {
	private long userId;
	private long clubId;
	private Date joinDate;
	
	public BelongDTO() {
		super();
	}
	
	public BelongDTO(long userId, long clubId, Date joinDate) {
		this.userId = userId;
		this.clubId = clubId;
		this.joinDate = joinDate;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getClubId() {
		return clubId;
	}

	public void setClubId(long clubId) {
		this.clubId = clubId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
