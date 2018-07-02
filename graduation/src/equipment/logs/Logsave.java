package equipment.logs;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logsave {
	FileWriter fw = null;
	public Logsave() throws Exception {
		String a = "F:/logs/";
		Date b = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String c = format.format(b) + ".txt";
		fw = new FileWriter(a + c, true);
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
}
