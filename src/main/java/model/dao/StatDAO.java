package model.dao;
import java.sql.Date;
//3. Stat - create, update
import java.sql.ResultSet;//결과값 확인이 필요할 수도 있으니까
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.dto.ClubDTO;
import model.dto.StatDTO;

public class StatDAO {

private JDBCUtil jdbcUtil = null;
	
	public StatDAO() {			
		jdbcUtil = new JDBCUtil();		// JDBCUtil 객체 생성
	}
		
	/**
	 * stat정보 입력(하루 단위로 새로 생성)
	 */
	public int create(StatDTO stat) throws SQLException {
		String sql = "Insert Into Stat(userId, m_date, weight, kcal, carb, protein, fat) "
					+ "Values (?, ?, ?, ?, ?, ?, ?) ";		
		Object[] param = new Object[] {stat.getUserId(), stat.getDate(), stat.getWeight(), stat.getKcal(), 
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
					+ "SET weight=?, kcal=?, carb=?. protein=?, fat=? "
					+ "WHERE userid=? ";
		Object[] param = new Object[] {stat.getWeight(), stat.getKcal(), stat.getCarb(), 
				stat.getProtein(), stat.getFat(), stat.getUserId()};				
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
	
	// Nutri 정보가 있는 stat만 모아서 return
	public List<StatDTO> nutriStatList(long userId) throws SQLException {
        String sql = "SELECT kcal, carb, protein, fat "
        		+ " FROM stat "
        		+ "WHERE userId = ?";
        Object[] param = new Object[] {userId};
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<StatDTO> nutriList = new ArrayList<StatDTO>();	
			while (rs.next()) {
				StatDTO nutri = new StatDTO(		
					rs.getFloat("kcal"),
					rs.getFloat("carb"),
					rs.getFloat("protein"),
					rs.getFloat("fat"));
				nutriList.add(nutri);			
			}		
			return nutriList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	// weight 정보가 있는 stat만 모아서 return
	public List<StatDTO> weightStatList(long userId) throws SQLException {
		String sql = "SELECT weight "
        		+ " FROM stat "
        		+ "WHERE userId = ?";
        Object[] param = new Object[] {userId};
		jdbcUtil.setSqlAndParameters(sql, null);		// JDBCUtil에 query문 설정
					
		try {
			ResultSet rs = jdbcUtil.executeQuery();			// query 실행			
			List<StatDTO> nutriList = new ArrayList<StatDTO>();	
			while (rs.next()) {
				StatDTO nutri = new StatDTO(		
					rs.getFloat("weight"));
				nutriList.add(nutri);			
			}		
			return nutriList;					
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close();		// resource 반환
		}
		return null;
	}
	//addWeightStat용
	public int addWeight(StatDTO stat) throws SQLException {
		String sql = "Update Stat "
					+ "SET weight=? "
					+ "WHERE userid=? ";
		Object[] param = new Object[] {stat.getWeight(), stat.getUserId()};				
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
	 * 특정 날짜의 기록을 삭제(혹시몰라 넣어둠)
	 
	public int delete(Date date) throws SQLException {
		String sql = "Delete Fr
		om Stat " 
					+ "Where m_Date = ? ";	
		Object[] param = new Object[] { date };
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
	*/
}
