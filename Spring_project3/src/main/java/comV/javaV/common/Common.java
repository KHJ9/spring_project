package comV.javaV.common;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Common {
	public static String noticeDir = "d:/java_spring_file_dir/notice/";
	public static String noticeDir2 = "d:/java_spring_file_dir/notice";
	   /**	연도 */
	   public String getYearString() {
	      Calendar cd = new GregorianCalendar(Locale.KOREA);
	      int year = cd.get(Calendar.YEAR);
	      return Integer.toString(year);
	   }	
	   /**	월 */
	   public String getMonthString(){
	      Calendar cd = new GregorianCalendar(Locale.KOREA);
	      int month = cd.get(Calendar.MONTH) + 1;
			String rs ="";
			if(month < 10) rs = "0"+Integer.toString(month);
			else rs  = Integer.toString(month);

	      return rs;
	   } 
		/**	일 */   
	   public String getDayString() {
	      Calendar cd = new GregorianCalendar(Locale.KOREA);
	      int day = cd.get(Calendar.DAY_OF_MONTH);
			String rs ="";
			if(day < 10) rs = "0"+Integer.toString(day);
			else rs  = Integer.toString(day);

	      return rs;
	   } 
}
