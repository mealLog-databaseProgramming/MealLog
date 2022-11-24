package DTO;

public class HashtagDTO {
	private long clubId;
	private String hname;
	
	public HashtagDTO() {
		super();
	}
	
	public HashtagDTO(long clubId, String hname) {
		this.clubId = clubId;
		this.hname = hname;
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public long getClubId() {
		return clubId;
	}

	public void setClubId(long clubId) {
		this.clubId = clubId;
	}
	 
	
}

