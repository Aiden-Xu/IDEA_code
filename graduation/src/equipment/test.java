package equipment;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

 public class test{
public static void main(String[] args) throws ParseException { 
        String str = "2017-01-01 12:12:12";
        java.util.Date d = null;
		 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 d=format.parse(str);
		 DateFormat df=new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss "); 
		 String time = df.format(d.getTime()); 
		 java.sql.Timestamp date = new java.sql.Timestamp(d.getTime());
		 System.out.println(date);
		 d= new java.util.Date(d.getTime());
		 System.out.println(d);
    }
}