package DTO;
import java.sql.Date;

public class StatDTO {
	
	private int userId;
	private Date date;
	private float weight;
	private float kcal;
	private float carb;
	private float protein;
	private float fat;
	
	public StatDTO() {} //기본 생성자
	
	public StatDTO(int userId, Date date, float weight, float kcal, float carb, float protein, float fat) {
		this.userId = userId;
		this.date = date;
		this.weight = weight;
		this.kcal = kcal;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
	}
	
	//update
	public void update(StatDTO updateStat) {
		this.weight = updateStat.weight;
		this.kcal = updateStat.kcal;
		this.carb = updateStat.carb;
		this.protein = updateStat.protein;
		this.fat = updateStat.fat;
	}
		
	//getter & setter

	public float getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
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
	public float getKcal() {
		return kcal;
	}
	public void setKcal(float kcal) {
		this.kcal = kcal;
	}
	public float getCarb() {
		return carb;
	}
	public void setCarb(float carb) {
		this.carb = carb;
	}
	public float getProtein() {
		return protein;
	}
	public void setProtein(float protein) {
		this.protein = protein;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}


	
	
}
