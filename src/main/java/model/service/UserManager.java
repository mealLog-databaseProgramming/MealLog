package model.service;

import java.sql.SQLException;

import model.dto.UserDTO;
import model.service.exception.ExistingUserException;
import model.service.exception.UserNotFoundException;
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
		if (userDAO.existingLoginId(user.getLoginId()) == true) {
			throw new ExistingUserException(user.getLoginId() + "는 존재하는 아이디입니다.");
		}
		if (userDAO.existingUname(user.getName()) == true) {
			throw new ExistingUserException(user.getUserId() + "는 존재하는 닉네임입니다.");
		}
		if (userDAO.existingEmail(user.getEmailAddress()) == true) {
			throw new ExistingUserException(user.getEmailAddress() + "는 존재하는 이메일입니다.");
		}
		
		return userDAO.insert(user);
	}

	public int update(UserDTO user) throws SQLException, UserNotFoundException {

		return userDAO.update(user);
	}	

	public int delete(long userId) throws SQLException, UserNotFoundException {
		
		return userDAO.delete(userId);
	}
	
	public long login(String userId, String password) throws Exception {
		UserDTO user = userDAO.findUser(userId);
		if (user.getPassword().equals(password)) return user.getUserId();
		throw new Exception();
	}
}