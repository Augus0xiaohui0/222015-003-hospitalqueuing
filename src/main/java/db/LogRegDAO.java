package db;

import beans.PatientBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/** 
 * @author Stallion-X
 */
public class LogRegDAO extends ConnBean {
	private Connection connection=null;

	public boolean validateP(String pnum,String ppsd) {
		PreparedStatement pstmt=null;
		String sql="select * from patient where pnum=? and ppsd=?";
		ResultSet rs=null;
		int result = 0;
		try{
			connection=getConnection();
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, pnum);
			pstmt.setString(2, ppsd);
			rs=pstmt.executeQuery();
			if (rs.next()) { // 使用 rs.next() 来判断是否存在结果
				result = 1; // 如果存在结果，将 result 设置为 1
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null && !connection.isClosed()){
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return result > 0; // 返回 result 是否大于 0，表示是否存在匹配的记录
	}


	public boolean insertRegister(PatientBean p) {
		PreparedStatement pstmt;
		String sql="insert into patient values(?,?,?,?,?,?,?,?,?)";
		if(p==null) 
			return false;
		boolean result=false;
		int number=0;
		try{
			connection=getConnection();	
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1, p.getPnum());
			pstmt.setString(2, p.getPname());
			pstmt.setString(3, p.getPsex());
			pstmt.setInt(4, p.getPage());
			pstmt.setString(5, p.getPid());
			pstmt.setString(6, p.getPtel());
			pstmt.setString(7, p.getPpsd());
			pstmt.setString(8, "患者");
			pstmt.setString(9, null);
			number=pstmt.executeUpdate();
			pstmt.close();
			connection.close();	
		}catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try{
				if (connection!=null && (!connection.isClosed())){
					connection.close();
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		if(number>0)
			result=true;
		return result;
	}

	public boolean validateD(String dcon) {
		PreparedStatement pstmt = null;
		String sql = "select dnum from doctor where dcon=?";
		ResultSet rs = null;
		int result = 0;
		try {
			connection = getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, dcon);
			rs = pstmt.executeQuery();
			// 遍历 ResultSet 统计行数
			while (rs.next()) {
				result++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (connection != null && (!connection.isClosed())) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result > 0;
	}

}
