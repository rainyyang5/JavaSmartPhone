package ScoreAnalyzer;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy).
 * This is an interface for Statistics.
 */
public interface Statistics {
	
	public void findlow(Student[] students);
	public void findhigh(Student[] students);
	public void findavg(Student[] students);
	public void printStatistics();
}
