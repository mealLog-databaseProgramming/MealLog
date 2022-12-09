package model.dto;

import java.util.List;

public class HashtagDTO {
	private String tagId;
	private long clubId;
	private String hname;
	
	public HashtagDTO() {
		super();
	}
	
	public HashtagDTO(String tagId, long clubId, String hname) {
		this.setTagId(clubId+hname);
		this.clubId = clubId;
		this.hname = hname;
	}
	
	public String getTagId() {
		return tagId;
	}

	public void setTagId(String tagId) {
		this.tagId = tagId;
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

