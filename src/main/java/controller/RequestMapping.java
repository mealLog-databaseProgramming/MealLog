package controller;

import java.util.HashMap;
import java.util.Map;

public class RequestMapping {  
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	mappings.put("/", new HomeController());
    	mappings.put("/recomm", new RecommController());
    	mappings.put("/group", new GroupController());
    	mappings.put("/mypage", new MypageController());
    }

    public Controller findController(String uri) {
    	// if(mappings.get(uri) == null) { return new ForwardController(uri); }
        return mappings.get(uri);
    }
}