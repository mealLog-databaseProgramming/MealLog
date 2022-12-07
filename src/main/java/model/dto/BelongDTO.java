package model.dto;

import java.util.Date;

public class BelongDTO {
	private long userId;
	private long clubId;
	private Date joinDate;
	
	public BelongDTO() {
		super();
	}
	public BelongDTO(long userId, long clubId) {
		this.userId = userId;
		this.clubId = clubId;
	}//아 이거 생성자 메소드 조건 있었는데
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
