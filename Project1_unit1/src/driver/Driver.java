package driver;

import model.Automotive;
import util.FileIO;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The Driver class is the main function that tests the fileIO
 * both for plain text read in and the serialized object read/write
 */
public class Driver {
	
	private static final String INPUT_FILENAME = "FordZTW.txt";
	private static final String SERIAL_FILENAME = "auto.ser";
	private static final String[] NEW_COLOR = { 
		"new color red, 0",
		"new color white, 100"
	};
	
	public static void main(String [] args) {
		
		//Build Automobile Object from a file.
		FileIO fileIO = new FileIO();
		Automotive FordZTW = fileIO.buildAutoObject(INPUT_FILENAME);
		
		//Print attributes before serialization
		FordZTW.print();
		System.out.println();
		
		//Serialize the object
		fileIO.writeToSerializedFile(SERIAL_FILENAME, FordZTW);
		
		//Deserialize the object and read it into memory.
		Automotive newFordZTW = fileIO.readSerializedFile(SERIAL_FILENAME); 
		
		//Print new attributes.
		newFordZTW.print();
		System.out.println();
		
		//Test delete a single optionSet
		newFordZTW.deleteOptionSet("Power Moonroof");
		newFordZTW.print();
		System.out.println();
		
		//Test update the optionSet
		newFordZTW.updateOptionSet("Color", NEW_COLOR);
		newFordZTW.print();
		System.out.println();
		
		//Test delete all the optionsets
		newFordZTW.deleteOptionSet("Color");
		newFordZTW.deleteOptionSet("Transmission");
		newFordZTW.deleteOptionSet("Brakes/Traction Control");
		newFordZTW.print();

	}
}
