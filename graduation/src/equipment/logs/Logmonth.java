package equipment.logs;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logmonth {
	FileWriter fw = null;
	String d = null;
	public Logmonth() throws Exception {
		String a = "F:/logs/";
		Date b = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String c = format.format(b) + ".txt";
		fw = new FileWriter(a + c, true);
		// 在每月日志中，每天开始加一个日期，如果有了就不加
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		d = format1.format(b);
	}
	public void close() throws Exception {
		if (fw != null) {
			fw.close();
		}
	}
	public void save(String a) throws Exception {
		fw.write(a);
		fw.write("\r\n");
	}
	public void save2(String a) throws Exception {
		fw.write(a);
	}
	public void savetime() throws Exception {
		fw.write(d);
		fw.write("\r\n");
	}
}
