package ScoreAnalyzer;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy).
 * This is an abstract class for student
 */
public abstract class Student {
	
	int studentId;
	int scores[];
	
	public Student(){}

	// Public get and set methods for SID and scores
	public int getStudentId() {
		return studentId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int[] getScores() {
		return scores;
	}

	public void setScores(int[] scores) {
		this.scores = scores;
	}
	
	//abstract methods to print values of instance variables.
	public abstract void printScores();
}
