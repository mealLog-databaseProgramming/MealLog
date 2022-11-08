package UserDAO;
//1. User - create, update, remove
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

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
			String sql = "Insert Into User(userId, name, introduce, age, gender, height, weight, PA, loginId, password, emailAddress) "
					+ "Values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";		
			Object[] param = new Object[] {user.getUserId(), user.getName(), 
					user.getIntroduce(), user.getAge(), user.getGender(), user.getHeight()
					,user.getWeight(), user.getPA()
					, user.loginId(), user.password(), user.emailAddress()};				
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
			String sql = "UPDATE User "
						+ "SET name=?, introduce=?, age=?, gender=?, height=?, weight=?, PA=?, password=?, emailAddress=? "
						+ "WHERE userid=? ";
			Object[] param = new Object[] {user.getName(), 
					user.getIntroduce(), user.getAge(), user.getGender(), user.getHeight()
					,user.getWeight(), user.getPA()
					,user.password(), user.emailAddress()};				
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
			String sql = "Delete From User " + "Where userId=? ";		
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
		        		+ "From User "
		        		+ "where name=?, emailAddress=? ";              
			jdbcUtil.setSqlAndParameters(sql, new Object[] {name, email});//??	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 아이디 정보 발견
					String findID = rs.getString("LoginId");
					return findID;//아이디값 리턴
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
		        		+ "From User "
				        + "where name=?, emailAddress=?, loginId=? ";              
			jdbcUtil.setSqlAndParameters(sql, new Object[] {loginId, name, email});	// JDBCUtil에 query문과 매개 변수 설정???????????????????????????????

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {						// 비밀번호 정보 발견
					String findPW = rs.getString("password");
					return findPW;
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
		public boolean existingLoginId(String Loginid) throws SQLException {
			String sql = "SELECT count(*) "
						+ "FROM User "
						+ "WHERE Loginid=?- ";      
			jdbcUtil.setSqlAndParameters(sql, new Object[] {Loginid});	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {
					int count = rs.getInt(1);
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
			String sql = "SELECT count(*) "
						+ "FROM User "
						+ "WHERE emailAddress=? ";      
			jdbcUtil.setSqlAndParameters(sql, new Object[] {emailAddress});	// JDBCUtil에 query문과 매개 변수 설정

			try {
				ResultSet rs = jdbcUtil.executeQuery();		// query 실행
				if (rs.next()) {
					int count = rs.getInt(1);
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
