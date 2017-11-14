package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DG_MemberDAO {
	
	private static final String DRIVER = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/dicegame";
	
	private static final String USER = "root"; //DB ID
	private static final String PASS = "se"; //DB 패스워드

	public DG_MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	/**DB연결 메소드*/
	public Connection getConn(){
		Connection con = null;
		
		try {
			Class.forName(DRIVER); //1. 드라이버 로딩
			con = DriverManager.getConnection(URL,USER,PASS); //2. 드라이버 연결
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	/**로그인시 멤버인지 아닌지 확인하는 메소드*/
	public Boolean isMember(String userID,String userPW){
		
		boolean ok = false;
		Connection con = null; 		 //연결
		PreparedStatement ps = null; //명령
		ResultSet rs = null;		 //결과
		
		try {
			
			con = getConn();
			String sql = "select * from DG_MEMBER where userID=? AND userPW=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userPW);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(1).equals(userID) && rs.getString(2).equals(userPW)){
						ok=true;
				}
				else ok=false;
			}
			else ok=false;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("isMember() error");
			ok=false;
		}	
		return ok;
	}
	/**회원 등록*/
	public boolean insertMember(String userID,String userPW,String userName){
		
		boolean ok = false;
		
		Connection con = null; 		 //연결
		PreparedStatement ps = null; //명령
		
		try{
			
			con = getConn();
			String sql = "insert into DG_MEMBER(" +
						"userID,userPW,userName) " +
						"values(?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, userID);
			ps.setString(2, userPW);
			ps.setString(3, userName);
			
			int r = ps.executeUpdate(); //실행 -> 저장
			
			
			if(r>0){
				ok=true;
			}else{
				ok=false;
			}
			
				
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ok;
	}//insertMmeber
		
}
