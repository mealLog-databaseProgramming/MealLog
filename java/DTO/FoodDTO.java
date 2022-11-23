package DTO;

public class FoodDTO {
	private long foodId;
	private long feedId;
	private String fname;
	private float kcal;
	private float carb;
	private float protein;
	private float fat;
	
	public FoodDTO() {
		super();
	}
	
	public FoodDTO(long foodId, long feedId, String fname, float kcal, float carb, float protein, float fat) {
		this.foodId = foodId;
		this.feedId = feedId;
		this.fname = fname;
		this.kcal = kcal;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
	}

	public long getFoodId() {
		return foodId;
	}

	public void setFoodId(long foodId) {
		this.foodId = foodId;
	}

	public long getFeedId() {
		return feedId;
	}

	public void setFeedId(long feedId) {
		this.feedId = feedId;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
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
