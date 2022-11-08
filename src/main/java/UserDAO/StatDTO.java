package UserDAO;

public class StatDTO {
	
	private float weight;
	private float kcal;
	private float carb;
	private float protein;
	private float fat;
	
	public StatDTO() {} //기본 생성자
	
	public StatDTO(float weight, float kcal, float carb, float protein, float fat) {
		this.weight = weight;
		this.kcal = kcal;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
	}
	
	//update
	public void update(StatDTO updateStat) {
		this.weight = weight;
		this.kcal = kcal;
		this.carb = carb;
		this.protein = protein;
		this.fat = fat;
	}
		
	//getter & setter
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
