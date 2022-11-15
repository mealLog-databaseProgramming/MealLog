package DTO;

import java.sql.Date;

public class BelongDTO {
	private int userId;
	private int clubId;
	private Date joinDate;
	
	public BelongDTO() {
		super();
	}
	
	public BelongDTO(int userId, int clubId, Date joinDate) {
		this.userId = userId;
		this.clubId = clubId;
		this.joinDate = joinDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
	
}
