package model.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.FeedDTO;
import model.dto.FoodDTO;
import model.dto.ReactDTO;
import model.dto.ReplyDTO;
import model.dto.UserDTO;
import model.dao.FeedDAO;

public class test {

	private FeedDAO feed = new FeedDAO();
	
	public static void main(String[] args) throws SQLException {
	
		List<FeedDTO> list = feed.findFeedList();
		System.out.println(list);
//		System.out.println("d");
	}
}