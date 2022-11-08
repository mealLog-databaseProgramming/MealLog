package UserDAO;
//eer산출법으로 계산된 값을 따로 저장하지 않아도 되는가?
public class UserDTO {
	
	private int userId;
	private String name;
	private String introduce;
	private int age;
	private int gender;
	private float height;
	private float weight;
	private float activeRank;//신체활동수준(권장 칼로리 계산용)
	private String loginId;
	private String emailAddress;
	
	public UserDTO() {} //기본 생성자	
	
	public UserDTO(int userId, String name, String introduce, int age, int gender, float height
			, float weight, float activeRank, String loginId, String emailAddress) {
		this.userId = userId;
		this.name = name;
		this.introduce = introduce;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.activeRank = activeRank;
		this.loginId = loginId;
		this.emailAddress = emailAddress;
	}
	
	//update
	public void update(UserDTO updateUser) {
		this.name = name;
		this.introduce = introduce;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.activeRank = activeRank;
		this.loginId = loginId;
		this.emailAddress = emailAddress;
	}
	
	//getter & setter
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getActiveRank() {
		return activeRank;
	}
	public void setActiveRank(float activeRank) {
		this.activeRank = activeRank;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	
}
