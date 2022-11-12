package UserDAO;
//1. User - create, update, remove
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//import UserDAO;//써야하는건가?

import java.util.List;

public class UserDAO {

	/**
	 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
	 */
		private JDBCUtil jdbcUtil = null;
		
		public UserDAO() {			
			jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성
		}
			
		/**
		 * 새로운 사용자 추가
		 */
		public int insert(UserDTO user) throws SQLException {
			String sql = "Insert Into UserInfo(userId, name, introduce, age, gender, height, weight, activeRank, loginId, password, emailAddress) "
					+ "Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
			Object[] param = new Object[] {user.getUserId(), user.getName(), 
					user.getIntroduce(), user.getAge(), user.getGender(), user.getHeight()
					,user.getWeight(), user.getActiveRank()
					, user.getLoginId(), user.getPassword(), user.getEmailAddress()};				
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

		/**
		 * 기존의 사용자 정보를 수정.
		 */
		public int update(UserDTO user) throws SQLException {
			String sql = "UPDATE UserInfo "
						+ "SET name=?, introduce=?, age=?, gender=?, height=?, weight=?, activeRank=?, password=?, emailAddress=? "
						+ "WHERE userid=? ";
			Object[] param = new Object[] {user.getName(), 
					user.getIntroduce(), user.getAge(), user.getGender(), user.getHeight()
					,user.getWeight(), user.getActiveRank()
					, user.getLoginId(), user.getPassword(), user.getEmailAddress()};				
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

		/**
		 * 사용자 ID에 해당하는 사용자를 삭제.
		 */
		public int delete(String userId) throws SQLException {
			String sql = "Delete From UserInfo " + "Where userId=? ";		
			jdbcUtil.setSqlAndParameters(sql, new Object[] {userId});	// JDBCUtil에 delete문과 매개 변수 설정

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
		
		
		/**
		 * 이름과 이메일로 아이디 찾기
		 */
		public UserDTO findLoginId(String name, String email) throws SQLException {
	        String sql = "Select loginId "
		        		+ "From UserInfo "
		        		+ "where name=?, emailAddress=? ";              
			jdbcUtil.setSqlAndParameters(sql, new Object[] {name, email});	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 아이디 정보 발견
					UserDTO user = new UserDTO(rs.getString("name"), rs.getString("loginId"));
					return user;
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
		//--이름과 이메일과 아이디로 비밀번호 찾기
		public UserDTO findPassword(String loginId, String name, String email) throws SQLException {
			String sql = "Select password "
		        		+ "From UserInfo "
				        + "where name=?, emailAddress=?, loginId=? ";              
			jdbcUtil.setSqlAndParameters(sql, new Object[] {loginId, name, email});	// JDBCUtil에 query문과 매개 변수 설정???????????????????????????????

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 비밀번호 정보 발견
					UserDTO user = new UserDTO(rs.getString("name"), rs.getString("loginId"), rs.getString("password"));
					return user; 
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			} finally {
				jdbcUtil.close();		// resource 반환
			}
			return null;
		}
//중복검사
		/**
		 * 로그인 아이디 중복인지 확인
		 */
		public boolean existingLoginId(String loginId) throws SQLException {
			String sql = "SELECT count(Loginid) "
						+ "FROM UserInfo "
						+ "WHERE loginId=? ";      
			jdbcUtil.setSqlAndParameters(sql, new Object[] {loginId});	// JDBCUtil에 query문과 매개 변수 설정

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
		/**
		 * 이메일 중복인지 확인
		 */
		public boolean existingEmail(String emailAddress) throws SQLException {
			String sql = "SELECT count(emailAddress) "
						+ "FROM UserInfo "
						+ "WHERE emailAddress=? ";      
			jdbcUtil.setSqlAndParameters(sql, new Object[] {emailAddress});	// JDBCUtil에 query문과 매개 변수 설정

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
