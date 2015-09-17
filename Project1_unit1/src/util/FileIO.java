package util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.Automotive;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The FileIO class contains methods for read/write data.
 */
public class FileIO {
	
	// constructor
	public FileIO() {}
	
	// build an Automotive object given a plain input file
	public Automotive buildAutoObject(String filename) {
		Automotive automotive = null;
		try {
			BufferedReader buff = new BufferedReader(new FileReader(filename));
			String line;
			
			// initial automotive
			if ( (line = buff.readLine()) != null) {
				String[] fields = line.trim().split(":");
				if (fields == null || fields.length != 3) {
					System.out.println("Error in building auto object.");
					return null;
				}
				automotive = new Automotive(fields[0], Integer.parseInt(fields[1]), Integer.parseInt(fields[2]));
			}
			
			// build up option set
			int optSetNum = 0;
			while ((line = buff.readLine()) != null) {
				String[] fields = line.trim().split(":");
				if (fields == null || fields.length != 3) {
					continue;
				}
				String property = fields[1].trim();
				String optionSize = fields[2].trim();
				
				line = buff.readLine();
				String[] contents = line.split(";");
				
				automotive.setOptsetByIndex(optSetNum, property, contents, Integer.parseInt(optionSize));
				optSetNum++;
				
			}
			buff.close();
		} catch (IOException e) {
			System.out.println("Error -- " + e.toString());
		}
		return automotive;
	}
	
	// read serialized object from the file
	public Automotive readSerializedFile(String filename) {
		try {
			ObjectInputStream in= new ObjectInputStream(new FileInputStream(filename));
			Automotive auto = (Automotive) in.readObject();
			in.close();
			return auto;
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.toString());
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		} catch (ClassNotFoundException e) {
			System.out.println("Error: " + e.toString());
		}
		return null;
	}
	
	// write serialized object to the file
	public void writeToSerializedFile(String filename, Serializable serliz) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
			out.writeObject(serliz);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: " + e.toString());
		} catch (IOException e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
