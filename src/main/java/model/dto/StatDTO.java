package model.dto;
import java.util.Date;

public class StatDTO {
	
	private long userId;
	private Date date;
	private float weight;

	
	public StatDTO() {} //기본 생성자

	public StatDTO(long userId, Date date, float weight) {
		this.userId = userId;
		this.date = date;
		this.weight = weight;
	}
	
	//getter & setter

	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
}
