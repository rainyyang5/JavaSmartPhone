package ScoreAnalyzer;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy).
 * This is an implementation of Statistics interface
 */
public class StatisticsImpl implements Statistics {
	
	private final int STUDENT_SIZE = 40;
	private final int QUIZ_NUM = 5;

	private Integer[] lowscores = new Integer[QUIZ_NUM]; 
	private Integer[] highscores = new Integer[QUIZ_NUM]; 
	private Float[] avgscores = new Float[QUIZ_NUM]; 
	
	// Constructor
	public StatisticsImpl(){
		for (int i = 0; i < QUIZ_NUM; i++) {
			lowscores[i] = Integer.MAX_VALUE;
			highscores[i] = Integer.MIN_VALUE;
			avgscores[i] = 0.f;
		}
	}
	
	// Find the lowest score for each quiz
	@Override
	public void findlow(Student[] students){
		for (int i = 0; i < STUDENT_SIZE && students[i] != null; i++) {
			for (int j = 0; j < QUIZ_NUM; j++) {
				lowscores[j] = Math.min(lowscores[j], students[i].getScores()[j]);
			}
		}
	}
	
	// Find the highest score for each quiz
	@Override
	public void findhigh(Student[] students){
		for (int i = 0; i < STUDENT_SIZE && students[i] != null; i++) {
			for (int j = 0; j < QUIZ_NUM; j++) {
				highscores[j] = Math.max(highscores[j], students[i].getScores()[j]);
			}
		}
	}

	// Find average score for each quiz
	@Override
	public void findavg(Student[] students){
		int i = 0;
		for ( ; i < STUDENT_SIZE && students[i] != null; i++) {
			for (int j = 0; j < QUIZ_NUM; j++) {
				avgscores[j] += students[i].getScores()[j];
			}
		}
		for (int k = 0; k < QUIZ_NUM; k++) {
			avgscores[k] /= i;
		}
	}
	
	// Print values of instance variables.
	@Override
	public void printStatistics() {
		printArray("High Score", highscores);
		printArray("Low Score", lowscores);
		printArray("Average", avgscores);
	}
	
	private <T> void printArray(String text, T[] scores) {
		String printout = text;
		if (scores instanceof Integer[]) {
			for (int i = 0; i < scores.length; i++) {
				printout = printout + "\t" + scores[i];
			}
		} else if(scores instanceof Float[]) {
			for (int i = 0; i < scores.length; i++) {
				printout = printout + "\t" + String.format("%.1f", scores[i]);
			}
		}
		System.out.println(printout);
	}
		
}
