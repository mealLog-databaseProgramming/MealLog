package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import controller.recomm.RecommController;
import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.ReactDTO;
import model.dto.ReplyDTO;
import model.dto.UserDTO;
import model.service.FeedManager;
import model.service.RecommandManager;
import model.dao.FeedDAO;

public class test {

	public static FeedDAO feed = new FeedDAO();
	public static FeedManager feedm = new FeedManager();
	public static RecommandManager recommM = new RecommandManager();
	public static RecommController recommC = new RecommController();

	
	
	public static void main(String[] args) throws SQLException, ParseException {
	
//		SimpleDateFormat format1 = new SimpleDateFormat ( "yyyy-MM-dd");	
//		String now = format1.format(new java.util.Date());
//		java.sql.Date publishDate= java.sql.Date.valueOf(now);
//
//		FeedDTO feedDTO = new FeedDTO("resources/img/salad.jpg", publishDate, 7, "아무말");
//		System.out.println(feedm.create(feedDTO));
//		
		
//		List<FeedDTO> fList = feed.findFeedList();
//		System.out.println(fList.get(0).getContent());
		
		long userId = 20;
		float[] fList = feed.findSumFoodListToday(userId);
		System.out.println(fList[0]);
	}
		
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        //자바설정파일을 사용한 애플리케이션컨텍스트 초기화
//        //ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);	//DaoFactory 설정정보를 생성자의 인자로 줌
//        //UserDao dao = context.getBean("userDao", UserDao.class);	//getBean(메소드명, 리턴타입)
//		
//        //XML설정파일을 사용한 애플리케이션컨텍스트 초기화
//        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
//		
//        UserDao dao = context.getBean("userDao",UserDao.class);
//		
//        //테스트용 데이터 셋팅
//        User user = new User();
//        user.setId("xmlMan3");
//        user.setName("kimMinSu");
//        user.setPassword("1234");
//		
//        //dao 함수 호출
//        dao.add(user);
//		
//        System.out.println(user.getId() + " 등록 성공");
//		
//        User user2 = dao.get(user.getId());
//        
//        //수정전
//        //System.out.println(user2.getName());
//        //System.out.println(user2.getPassword());
//        //System.out.println(user2.getId() + " 조회 성공");
//        
//        //수정후
//        if(!user.getName().equals(user2.getName())) {
//            System.out.println("테스트 실패 (name)");
//        }
//        else if(!user.getPassword().equals(user2.getPassword())) {
//            System.out.println("테스트 실패 (password)");
//        }
//        else {
//            System.out.println("조회 테스트 성공");
//        }
//    }
}
