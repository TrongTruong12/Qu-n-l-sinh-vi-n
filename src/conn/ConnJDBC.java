package conn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import model.Detai;

public class ConnJDBC {
	static String url="jdbc:mysql://localhost:3306/projectmanager";
	static String user="root";
	static String password="";

	public static Connection getConnection() {// connection function
		Connection connection=null;
		try {
			connection=DriverManager.getConnection(url,user,password);
		}catch(Exception ex) {
		ex.printStackTrace();
	}
		return connection;
}
	public static HashMap<String,String> findAllAccount(){
		HashMap<String,String> logininfo = new HashMap<String,String>();
		String query="select*from login";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				
				 String userName = rs.getString("username");
				 String passWord = rs.getString("passWord");
				 logininfo.put(userName, passWord);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
       
		return logininfo;
	}
	public static List<Detai>findAll(){
		List<Detai>studentsList= new ArrayList<>();
		String query="select*from projectmanager";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				 Detai student = new Detai(rs.getString("madetai"),rs.getString("tendetai"),rs.getString("yeucau"),rs.getDate("deadline"),
						rs.getString("nhomdangki"),rs.getInt("trangthainop"));
				 studentsList.add(student);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
       
		return studentsList;
	}
	public static void insert(Detai student) {
		String query="insert into projectmanager(madetai,tendetai, yeucau, deadline,nhomdangki,trangthainop) values(?,?,?,?,?,?)";
		try {
                    
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, student.getMadetai());
			pstmt.setString(2, student.getTendetai());
			pstmt.setString(3, student.getYeucau());
			pstmt.setDate(4, new Date(student.getDeadline().getTime()));
			pstmt.setString(5, student.getNhomdangki());
                        pstmt.setInt(6, student.getTrangthainop());
                        

			pstmt.execute();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void delete(Detai p) {
		String query="delete from projectmanager where madetai='"+p.getMadetai()+"'";
		try {
			Connection connection =getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static List<Detai>findByName(String stName) {
		List<Detai>stl= new ArrayList<>();
		String query="select*from projectmanager where tendetai like '%"+stName+"%'";
		try {
			Connection connection =getConnection();
			Statement stmt= connection.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next()) {
				Detai student = new Detai(rs.getString("madetai"),rs.getString("tendetai"),rs.getString("yeucau"),rs.getDate("deadline"),
						rs.getString("nhomdangki"),rs.getInt("trangthainop"));
				 stl.add(student);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return stl;
        }
	public static void update(Detai student) {
		
		String query="Update projectmanager set madetai=?,tendetai=?,yeucau=?,deadline=?,nhomdangki=?,trangthainop= ? where madetai='"+student.getMadetai()+"'";
		try {
			Connection connection=getConnection();
			PreparedStatement pstmt=connection.prepareStatement(query);
			pstmt.setString(1, student.getMadetai());
			pstmt.setString(2, student.getTendetai());
			pstmt.setString(3, student.getYeucau());
			pstmt.setDate(4, new Date(student.getDeadline().getTime()));
			pstmt.setString(5, student.getNhomdangki());
                        pstmt.setInt(6, student.getTrangthainop());

            pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	
}