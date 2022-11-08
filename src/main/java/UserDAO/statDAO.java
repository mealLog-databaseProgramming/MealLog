package UserDAO;
//3. Stat - create, update
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class statDAO {

private JDBCUtil jdbcUtil = null;
	
	public UserDAO() {			
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성
	}
		
	/**
	 * stat정보 입력(하루 단위로 새로 생성)
	 */
	public int create(StatDTO stat) throws SQLException {
		String sql = "Insert Into Stat(date, kcal, carb, protein, fat) "
					+ "Values (?, ?, ?, ?, ?) ";		
		Object[] param = new Object[] {stat.getDate(), stat.getKcal(), 
				stat.getCarb(), stat.getProtein(), stat.getFat()};				
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
	 * 기존의 stat 정보를 수정=식사 추가
	 */
	public int update(StatDTO stat) throws SQLException {
		String sql = "Update Stat "
					+ "SET kcal=?, card=?. protein=?, fat=? "
					+ "WHERE userid=? ";
		Object[] param = new Object[] {stat.getPassword(), stat.getName(), 
				stat.getEmail(), stat.getPhone(), stat.getUserId()};				
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

	
}
