package model.dao;
//1. User - create, update, remove
import java.sql.ResultSet;
import java.sql.SQLException;
import model.dto.UserDTO;

public class UserDAO {

		private JDBCUtil jdbcUtil = null;
		
		public UserDAO() {			
			jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성
		}
		
		//새로운 사용자 추가-프로필/정보 제외
		public int insert(UserDTO user) throws SQLException {
			String sql = "INSERT INTO USERINFO(USERID, UNAME, AGE, GENDER, HEIGHT, WEIGHT, ACTIVERANK, LOGINID, PASSWORD, EMAILADDRESS) "
					+ "VALUES (SEQUENCE_USERID.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
//			
			Object[] param = new Object[] { 
					user.getUname(), 
					user.getAge(), 
					user.getGender(), 
					user.getHeight(),
					user.getWeight(), 
					user.getActiveRank(),
					user.getLoginId(), 
					user.getPassword(), 
					user.getEmailAddress()
				};
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil 에 insert문과 매개 변수 설정
							
			try {				
				int result = jdbcUtil.executeUpdate();	// insert 문 실행
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			} finally {		
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}		
			return 0;			
		}

		//기존 사용자 정보를 수정.
		public int update(UserDTO user) throws SQLException {
			String sql = "UPDATE UserInfo "
						+ "SET uname=?, introduce=?, age=?, gender=?, height=?, weight=?, activeRank=?, password=?, emailAddress=? profile=?"
						+ "WHERE userid=? ";
			
			Object[] param = new Object[] {
					user.getUname(), 
					user.getIntroduce(), 
					user.getAge(), 
					user.getGender(), 
					user.getHeight(),
					user.getWeight(), 
					user.getActiveRank(),
					user.getPassword(), 
					user.getEmailAddress(), 
					user.getProfile(), 
					user.getUserId()
				};				
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 update문과 매개 변수 설정
				
			try {				
				int result = jdbcUtil.executeUpdate();	// update 문 실행
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}
			finally {
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}		
			return 0;
		}

		//사용자 ID에 해당하는 사용자를 삭제.
		public int delete(long userId) throws SQLException {	//userId String형 -> long형으로 변경
			// 회원 탈퇴할 때 피드도 삭제? 아니면 정보만 dummy값으로 넣고 이름을 탈퇴한 회원으로ㅎㅎ;
		String sql = "Delete From UserInfo " 
						+ "Where userId=? ";	
			Object[] param = new Object[] { userId };
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 delete문과 매개 변수 설정

			try {				
				int result = jdbcUtil.executeUpdate();	// delete 문 실행
				return result;
			} catch (Exception ex) {
				jdbcUtil.rollback();
				ex.printStackTrace();
			}
			finally {
				jdbcUtil.commit();
				jdbcUtil.close();	// resource 반환
			}		
			return 0;
		}
		
		
		//로그인 타입 검사
		public UserDTO findLoginId(String userId) throws SQLException {
	        String sql = "Select loginType "
		        		+ "From UserInfo "
		        		+ "where userId=?";    
	        Object[] param = new Object[] { userId };
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 아이디 정보 발견
					UserDTO user = new UserDTO();
					return user;//test에서는 user객체 받아서 출력
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
		
		//userId로 유저 찾기
		public UserDTO findUser(long userId) {
			String sql = "Select userId, uname, age, gender, height, weight, activeRank, loginId, password, emailAddress "
		        		+ "From UserInfo "
		        		+ "where loginId = ? ";    
	        Object[] param = new Object[] { userId };
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정
	
			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 아이디 정보 발견
					UserDTO user = new UserDTO();//생성자 매개변수 물어보기
					return user;//test에서는 user객체 받아서 출력
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
		
		//loginId로 유저 찾기
		public UserDTO findUser(String loginId) {
			String sql = "Select userId, uname, age, gender, height, weight, activeRank, loginId, password, emailAddress "
	        		+ "From UserInfo "
	        		+ "where loginId = ? ";    
	        Object[] param = new Object[] { loginId };
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정
	
			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 아이디 정보 발견
					UserDTO user = new UserDTO();//생성자 매개변수 물어보기
					return user;//test에서는 user객체 받아서 출력
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}

		//이름과 이메일로 아이디 찾기
		public UserDTO findLoginId(String name, String email) throws SQLException {
	        String sql = "Select loginId "
		        		+ "From UserInfo "
		        		+ "where uname=?, emailAddress=? ";    
	        Object[] param = new Object[] { name, email };
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 아이디 정보 발견
					UserDTO user = new UserDTO(rs.getString("uname"), rs.getString("loginId"));
					return user;//test에서는 user객체 받아서 출력
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
		//이름과 이메일과 아이디로 비밀번호 찾기
		public UserDTO findPassword(String loginId, String uname, String email) throws SQLException {
			String sql = "Select password "
		        		+ "From UserInfo "
				        + "where uname=?, emailAddress=?, loginId=? ";   
			
			Object[] param = new Object[] {uname, email, loginId};
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정
			
			try {
//				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
//				if (rs.next()) {						// 비밀번호 정보 발견
//					UserDTO user = new UserDTO(rs.getString("uname"), rs.getString("loginId"), rs.getString("password"));
//					return user; 
//				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
		
		//중복검사
		//닉네임(Uname) 중복인지 확인
		public boolean existingUname(String uname) throws SQLException {
			String sql = "SELECT count(uname) "
						+ "FROM UserInfo "
						+ "WHERE uname = ? ";    
			
			Object[] param = new Object[] {uname};
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {
					int count = rs.getInt("count");
					return (count == 1 ? true : false);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return false;
		}
		
		//로그인 아이디 중복인지 확인
		public boolean existingLoginId(String loginId) throws SQLException {
			String sql = "SELECT count(Loginid) "
						+ "FROM UserInfo "
						+ "WHERE loginId=? ";    
			
			Object[] param = new Object[] {loginId};
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {
					int count = rs.getInt("count");
					return (count == 1 ? true : false);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return false;
		}
		//이메일 중복인지 확인
		public boolean existingEmail(String emailAddress) throws SQLException {
			String sql = "SELECT count(emailAddress) "
						+ "FROM UserInfo "
						+ "WHERE emailAddress=? ";      
			Object[] param = new Object[] {emailAddress};
			jdbcUtil.setSqlAndParameters(sql, param);	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {
					int count = rs.getInt("count");
					return (count == 1 ? true : false);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return false;
		}
}
