package model.service;

import java.sql.SQLException;

import model.dto.UserDTO;
import model.dao.UserDAO;

public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;

	private UserManager() {
		try {
			userDAO = new UserDAO();
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}

	public static UserManager getInstance() {
		return userMan;
	}

	public int create(UserDTO user) throws SQLException, ExistingUserException {
		if (userDAO.existingUname(user.getName()) == true) {
			throw new ExistingUserException(user.getUserId() + "는 존재하는 아이디입니다.");
		}
		return userDAO.insert(user);
	}

	public int update(UserDTO user) throws SQLException, UserNotFoundException {

		
		return userDAO.update(user);
	}	

	public int delete(long userId) throws SQLException, UserNotFoundException {
		
		
		return userDAO.delete(userId);
	}
}