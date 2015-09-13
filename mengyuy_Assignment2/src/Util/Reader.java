package Util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import Exception.ExceedSizeException;
import ScoreAnalyzer.Student;
import ScoreAnalyzer.StudentLab2;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy).
 * This is a class for reading files and tokenize lines
 */
public class Reader {
	
	private final static int MAX_SIZE = 40;
	private final static int QUIZ_NUM = 5;
	
	// Reads the file and builds student array.
	public static void readFile(String filename, Student[] stu) { 
		
		try {
			// Open the file.
			BufferedReader buff = new BufferedReader(new FileReader(filename));
			String line;
			boolean isFirstLine = true;
			int lineNum = 0;
			
			// In a loop read a line.
			while ((line = buff.readLine()) != null) {
				if (lineNum >= MAX_SIZE) {
					throw new ExceedSizeException();
				}
				
				if (isFirstLine) {
					isFirstLine = false;
					continue;
				}
				stu[lineNum] = new StudentLab2();
				// Tokenize each line.
				StringTokenizer st = new StringTokenizer(line);
				boolean isFirstColumn = true;
				int i = 0;
				int[] scores = new int[QUIZ_NUM];
				
				while(st.hasMoreTokens()) {
					if (isFirstColumn) {
						isFirstColumn = false;
						// Each token is converted from String to Integer.
						stu[lineNum].setStudentId(Integer.valueOf(st.nextToken()));
						continue;
					}	
					scores[i] = Integer.valueOf(st.nextToken());	
					i++;
				}
				stu[lineNum++].setScores(scores);
			}
			
			buff.close();
		} catch (IOException e) {
			System.out.println("Error ­­ " + e.toString()); 
		} catch (ExceedSizeException e) { // Handle ExceedSizeException
			System.out.println("Error ­­ " + e.toString()); 
		}
	}
}
