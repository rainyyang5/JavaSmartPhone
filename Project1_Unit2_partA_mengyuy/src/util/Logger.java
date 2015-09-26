package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is the class that implements Logger
 */
public class Logger {
	private String loggerName;
	
	/* constructor */
	public Logger(String loggerName) {
		this.loggerName = loggerName;
	}
	
	// log exception message to the file with given logger name
	public void log(String msg) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(loggerName));
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(new Date()).append(" ").append(msg);
			bufferedWriter.write(strBuilder.toString());
			bufferedWriter.close();
		} catch (IOException e) {
			System.out.println("Error -- :" + e);
		}
		
	}
	
}
