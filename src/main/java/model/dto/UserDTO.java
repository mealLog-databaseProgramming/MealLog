package model.dto;
//eer산출법으로 계산된 값을 따로 저장하지 않아도 되는가?
public class UserDTO {
	
	private long userId; //pk
	private String uname;
	private String introduce;
	private int age;
	private int gender;
	private float height;
	private float weight;
	private int activeRank;//신체활동수준(권장 칼로리 계산용)
	private String loginId;//본인 지정 아이디 or 카카오 아이디
	private String password;
	private String emailAddress;
	private String profile;
	private String loginType; //카카오인지 일반인지를 구분
	//프로필이랑 소개빼고 당 립력
	
	
	// uid로 이름 찾기
	public UserDTO(int userId) {
		this.userId = userId;
	} 
	
	//기본 생성자	
	public UserDTO() {
	
	} 
	
	public UserDTO(long userId, String uname, String introduce, int age, int gender, float height
			, float weight, int activeRank, String loginId, String password, String emailAddress, String profile
			, String loginType) {
		this.userId = userId;
		this.uname = uname;
		this.introduce = introduce;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.activeRank = activeRank;
		this.loginId = loginId;
		this.emailAddress = emailAddress;
		this.profile = profile;
		this.loginType = loginType;
	}
	//아이디 찾기용
	public UserDTO(String uname, String loginId) {
		this.uname = uname;
		this.loginId = loginId;
	}
	//비번 찾기용
	public UserDTO(String uname, String password, String loginId) {
		this.uname = uname;
		this.password = password;
		this.loginId = loginId;
	}
	//update//수정확인
	public void update(UserDTO updateUser) {
		this.uname = updateUser.uname;
		this.introduce = updateUser.introduce;
		this.age = updateUser.age;
		this.gender = updateUser.gender;
		this.height = updateUser.height;
		this.weight = updateUser.weight;
		this.activeRank = updateUser.activeRank;
		this.loginId = updateUser.loginId;
		this.emailAddress = updateUser.emailAddress;
		this.profile = updateUser.profile;
	}
	
	//getter & setter
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String name) {
		this.uname = name;
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
	public int getActiveRank() {
		return activeRank;
	}
	public void setActiveRank(int activeRank) {
		this.activeRank = activeRank;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}
	
	
}
