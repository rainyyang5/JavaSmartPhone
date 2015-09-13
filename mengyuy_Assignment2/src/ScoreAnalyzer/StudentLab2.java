package ScoreAnalyzer;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy).
 * This is an concrete class for student according to the requirement in Lab2
 */
public class StudentLab2 extends Student{
	
	private final int QUIZ_NUM = 5;
	
	public StudentLab2() {
		scores = new int[QUIZ_NUM];
	}
	
	// Print studentID and scores
	public void printScores() {		
		String printout = "";
		printout += studentId;
		for (int i = 0; i < scores.length; i++) {
			printout = printout + "\t" + scores[i];
		}
		System.out.println(printout);
	}
}
