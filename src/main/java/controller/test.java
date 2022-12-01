package controller;

import java.sql.SQLException;

import model.dao.ClubDAO;
import model.dto.ClubDTO;

public class test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		ClubDTO club1 = new ClubDTO(1, "m" , "m", "n", 13, 2);
		ClubDAO dao = new ClubDAO();
		dao.createClub(club1);
	}

}
