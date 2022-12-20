package model.service;

import java.sql.SQLException;

import model.dto.UserDTO;
import model.service.exception.ExistingUserException;
import model.service.exception.UserNotFoundException;
import model.dao.UserDAO;

public class UserManager {
	private static UserManager userMan = new UserManager();
	private UserDAO userDAO;

	public UserManager() {
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
		if (userDAO.existingUname(user.getUname()) == true) {
			throw new ExistingUserException(user.getUname() + "는 존재하는 닉네임입니다.");
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
	
	public UserDTO findUser(long userId) {
		return userDAO.findUser(userId);
	}
	public boolean existingLoginId(String loginId) throws SQLException, ExistingUserException {
		return userDAO.existingLoginId(loginId);
	}
	
	public long login(String loginId, String password) throws Exception {
		long userId = userDAO.findUserId(loginId, password);
		
		if(userId == -1) throw new Exception("아이디 또는 비밀번호가 일치하지 않습니다.");
		
		return userId;
	}
	
}