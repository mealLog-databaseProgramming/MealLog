package controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {  
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	mappings.put("/", new HomeController());
    	mappings.put("/recomm", new RecommController());

    	mappings.put("/group", new ClubController());//
    	mappings.put("/groupUpdate", new ClubUpdateController());
    	mappings.put("/newgroup", new CreateClubController());
    	mappings.put("/deletegroup", new DeleteClubController());
    	mappings.put("/joingroup", new JoinClubController());
    	mappings.put("/leavegroup", new leaveClubController());

    	mappings.put("/mypage", new MypageController());
    	
    	mappings.put("/infoupdate", new UserInfoUpdateController());
    	mappings.put("/statupdate", new UserStatUpdateController());
    	
    	mappings.put("/login", new LoginController());
    	mappings.put("/signup", new SignupController());
    }

    public Controller findController(String uri) {
    	// if(mappings.get(uri) == null) { return new ForwardController(uri); }
        return mappings.get(uri);
    }
}