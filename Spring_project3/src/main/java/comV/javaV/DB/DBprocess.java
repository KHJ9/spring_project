package comV.javaV.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import comV.javaV.arrayClass.DtoList;
import comV.javaV.arrayClass.Indexinfo;

public class DBprocess {
	DataSource datasource;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
	SimpleDateFormat pc_time = new SimpleDateFormat("yy-MM-dd:hh:mm:ss");
	String getToday() {
		java.util.Date d = new java.util.Date();
		return sdf.format(d);
	}	
	String getTodayTwo() {
		java.util.Date d = new java.util.Date();
		return sdfTwo.format(d);
	}
	String getTodayTwo(long time) {
		java.util.Date d = new java.util.Date(time);
		return pc_time.format(d);
	}
	String getDateFormat(String sDate) {
		return sDate.substring(0, 4)+"-"+sDate.substring(4,6)+"-"+sDate.substring(6);
	}

   /**	연도 */
   public int getYear() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int year = cd.get(cd.YEAR);
      return year;
   }	
   /**	월 */
   public int getMonth(){
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int month = cd.get(cd.MONTH) + 1;
      return month;
   } 
	/**	일 */   
   public int getDay() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int day = cd.get(cd.DAY_OF_MONTH);
      return day;
   } 	
   /**	연도 */
   public String getYearString() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int year = cd.get(cd.YEAR);
      return Integer.toString(year);
   }	
   /**	월 */
   public String getMonthString(){
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int month = cd.get(cd.MONTH) + 1;
		String rs ="";
		if(month < 10) rs = "0"+Integer.toString(month);
		else rs  = Integer.toString(month);

      return rs;
   } 
	/**	일 */   
   public String getDayString() {
      Calendar cd = new GregorianCalendar(Locale.KOREA);
      int day = cd.get(cd.DAY_OF_MONTH);
		String rs ="";
		if(day < 10) rs = "0"+Integer.toString(day);
		else rs  = Integer.toString(day);

      return rs;
   }
	
	public DBprocess(){
		try {
			Context context = new InitialContext();
			datasource = (DataSource)context.lookup("java:comp/env/jdbc/mysqlVision");
		} catch(Exception e) {
			System.out.println("CON_INFO 오류 : "+e.getMessage());
		}
	}
	
	public ArrayList<DtoList> getNoticeList(String sQuery){
		Connection          			con  = null;
		PreparedStatement  	ps    = null;
		ResultSet	    				rs	    = null;
		ArrayList<DtoList> lists = new ArrayList<DtoList>();
		try {
			con = datasource.getConnection();
			ps  = con.prepareStatement(sQuery);	
			rs = ps.executeQuery();
			
			DtoList list;
			while(rs.next()){
				String num = rs.getString("num");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String file_name = rs.getString("file_name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				
				list = new DtoList(num, title, contents, file_name, reg_date, hit);
				lists.add(list);
			}
	
		} catch(SQLException se) {
			System.out.println("SQLException: " + se.getMessage());
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
			System.out.println("close Exception: " + e.getMessage());
			}
      }
		return lists;
	}
	
	public ArrayList<Indexinfo> getList(String sQuery){
		Connection          con      = null;
		PreparedStatement   ps       = null;
		ResultSet	    	rs	     = null;
		ArrayList<Indexinfo> lists = new ArrayList<Indexinfo>();
		try {
			con = datasource.getConnection();
			ps  = con.prepareStatement(sQuery);	
			rs = ps.executeQuery();
			
			Indexinfo list;
			while(rs.next()){
				String num = rs.getString("num");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String reg_date = rs.getString("reg_date");
				
				list = new Indexinfo(num, title, contents, reg_date);
				lists.add(list);
			}
	
		} catch(SQLException se) {
			System.out.println("SQLException: " + se.getMessage());
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
			System.out.println("close Exception: " + e.getMessage());
			}
      }
		return lists;
	}
	
	public DtoList view(String sQuery){
		Connection          con      = null;
		PreparedStatement   ps       = null;
		ResultSet	    	rs	     = null;
		DtoList list = null;
		try {
			con = datasource.getConnection();
			ps  = con.prepareStatement(sQuery);	
			rs = ps.executeQuery();
			
			while(rs.next()){
				String num = rs.getString("num");
				String title = rs.getString("title");
				String contents = rs.getString("contents");
				String file_name = rs.getString("file_name");
				String reg_date = rs.getString("reg_date");
				int hit = rs.getInt("hit");
				
				list = new DtoList(num, title, contents, file_name, reg_date, hit);
			}
	
		} catch(SQLException se) {
			System.out.println("SQLException: " + se.getMessage());
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
			System.out.println("close Exception: " + e.getMessage());
			}
      }
		return list;
	}
	
	public String getNum(String sQuery){
		Connection          con      = null;
		PreparedStatement   ps       = null;
		ResultSet	    	rs	     = null;
		String result = null;
		try {
			con = datasource.getConnection();
			ps  = con.prepareStatement(sQuery);	
			rs = ps.executeQuery();
			
			while(rs.next()){
				result = rs.getString(1);
			}
	
		} catch(SQLException se) {
			System.out.println("SQLException: " + se.getMessage());
		} catch(Exception e) {
			System.out.println("Exception: " + e.getMessage());
		} finally {
			try{
				if(con != null) con.close();
				if(ps != null) ps.close();
				if(rs != null) rs.close();
			}catch(Exception e){
			System.out.println("close Exception: " + e.getMessage());
			}
      }
		return result;
	}
	
	public boolean save(String sQuery) {
		// import java.sql.Connection;
		// import java.sql.PreparedStatement;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = datasource.getConnection();
			ps = con.prepareStatement(sQuery);
			int result = ps.executeUpdate();
		} catch(SQLException e) {
			System.out.println("SQL 오류 : "+e.getMessage());
		} catch(Exception e) {
			System.out.println("SQL 오류 : "+e.getMessage());
			return false;
		} finally {
			try {
				if(ps != null) ps.close();
				if(con != null) con.close();
			} catch(Exception e) {
				System.out.println("CLOSE 오류 : "+e.getMessage());
				return false;
			}
		}
		return true;
	}
	
	public int getTotalCount(String sQueryCount) {
		Connection          con      = null;
		ResultSet	    	rs	     = null;
		PreparedStatement   pstmt    = null;
		int result=0;
		//String sQuery = "select count(*) as num from "+tableName;
		try{
			con = datasource.getConnection();
			pstmt  = con.prepareStatement(sQueryCount);		
			rs = pstmt.executeQuery();
			while(rs.next()){
				result = rs.getInt("count"); // 
			}
	
		}catch(Exception e){
			System.out.println("Exception: " + e.getMessage());
		}finally{
			try{
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();		
			}catch(Exception e){
				System.out.println("close Exception: " + e.getMessage());
			}

      		}
	  return result;		
	}
	
}
