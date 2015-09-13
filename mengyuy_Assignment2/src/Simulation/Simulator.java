package Simulation;

import ScoreAnalyzer.Statistics;
import ScoreAnalyzer.StatisticsImpl;
import ScoreAnalyzer.Student;
import ScoreAnalyzer.StudentLab2;
import Util.Reader;


/* 
 * Created by Mengyu Yang(AndrewID: mengyuy).
 * This is a class for simulation and tests
 */
public class Simulator {
	
	private static final String FILENAME1 = "test1.txt";
	private static final String FILENAME2 = "test2.txt";
	private static final String FILENAME3 = "test3.txt";
	private static final String FILENAME4 = "test4.txt";

	
	private final static String HEAD = "Stud	Q1	Q2	Q3	Q4	Q5";
	private final static int MAX_SIZE = 40;
	
	public static void main(String [] args) {
		// test case 1: less than 40 students. Do not raise exception.
		System.out.println("Test case 1: less than 40 students. Do not raise exception.");
		test(FILENAME1);
		System.out.println();
		
		// test case 2: more than 40 students. Throw exception.
		System.out.println("Test case 2: more than 40 students. Throw exception.");
		test(FILENAME2);
		System.out.println();
		
		// test case 3: equal to 40 students. Do not raise exception.
		System.out.println("Test case 3: equal to 40 students. Do not raise exception.");
		test(FILENAME3);
		System.out.println();
		
		// test case 4: file does not exist
		System.out.println("Test case 4: file does not exist.");
		test(FILENAME4);
		System.out.println();
	}
	
	private static void test(String filename) {
		
		Student[] students = new StudentLab2[MAX_SIZE]; // Populate the student array
		Reader.readFile(filename, students); 
	
		if (students[0] == null) {
			System.out.println("Input file does not exist.");
			return;
		}
		
		Statistics stat = new StatisticsImpl(); 
		stat.findlow(students);
		stat.findhigh(students);
		stat.findavg(students);
		
		// Print the data and statistics
		System.out.println(HEAD);
		for (int i = 0; i < MAX_SIZE && students[i] != null; i++) {
			students[i].printScores();
		}
		System.out.println();
		stat.printStatistics();
	}

}
