package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {
	
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	public static final String USER = "ca";
	public static final String PASSWORD = "ca";
	
	public MemberDAO() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("failed");
		}
	}
	
	public void insert(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement("insert into people values (?,?,?)");
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getBirth());
			
			if (pstmt.executeUpdate() == 1) System.out.println(dto.getId()+ " : 가입완료");
			else System.out.println(dto.getId()+ ": 가입실패");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public ArrayList<MemberDTO> getList() {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement("select * from people");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				list.add(new MemberDTO(rs.getString("id"), 
									   rs.getString("name"), 
									   rs.getString("birth")));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list; 
	}
	
	public MemberDTO getMember(String from, String to) {
		MemberDTO dto = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement("select * from people where "+from+" =?");
			pstmt.setString(1, to);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				dto = new MemberDTO(rs.getString("id"), 
								    rs.getString("name"), 
								    rs.getString("birth"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public boolean isDuplicate(String from, String to) {
		boolean flag = true;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement("select * from people where "+from+" =?");
			pstmt.setString(1, to);
			rs = pstmt.executeQuery();
			flag = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return flag;
	}
	
	public void update(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement("update people set name =?, birth=? where id =?");
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getBirth());
			pstmt.setString(3, dto.getId());
			if (pstmt.executeUpdate() ==1) System.out.println("정보 수정 완료");
			else System.out.println("정보 수정 실패");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void delete(String id) {
		Connection conn= null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement("delect from people where id =?");
			pstmt.setString(1, id);
			if (pstmt.executeUpdate() == 1) System.out.println(id + " : 삭제 완료");
			else System.out.println(id + "삭제 실패");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
