package DTO;

public class HashtagDTO {
	private int clubId;
	private String hname;
	
	public HashtagDTO() {
		super();
	}
	
	public HashtagDTO(int clubId, String hname) {
		this.setClubId(clubId);
		this.setHname(hname);
	}

	public String getHname() {
		return hname;
	}

	public void setHname(String hname) {
		this.hname = hname;
	}

	public int getClubId() {
		return clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}
	
	
}

