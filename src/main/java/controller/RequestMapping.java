package controller;

import java.util.HashMap;
import java.util.Map;

import controller.home.*;
import controller.main.*;
import controller.mypage.*;
import controller.club.*;
import controller.recomm.*;

public class RequestMapping {  
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	mappings.put("/", new HomeController());
    	mappings.put("/newreply", new CreateReplyController());
    	mappings.put("/newfeed", new CreateFeedController());
    	mappings.put("/removefeed", new RemoveFeedController());
    	//mappings.put("/react", new ReactController());
    	
    	mappings.put("/recomm", new RecommController());

    	mappings.put("/group", new ClubController());//
    	mappings.put("/groupUpdate", new ClubUpdateController());
    	mappings.put("/newGroup", new CreateClubController());
    	mappings.put("/deleteGroup", new DeleteClubController());
    	mappings.put("/joingroup", new JoinClubController());
    	mappings.put("/leaveGroup", new leaveClubController());

    	mappings.put("/mypage", new MypageController());
    	
    	mappings.put("/userinfoupdate", new UserInfoUpdateController());
    	mappings.put("/statupdate", new StatUpdateController());
    	
    	mappings.put("/login", new LoginController());
    	mappings.put("/signup", new SignupController());
    	mappings.put("/logout", new LogoutController());
    	mappings.put("/kakao_login", new KakaoLoginController());
    	mappings.put("/kakao_signup", new KakaoSyncController());
    }

    public Controller findController(String uri) {
    	// if(mappings.get(uri) == null) { return new ForwardController(uri); }
        return mappings.get(uri);
    }
}