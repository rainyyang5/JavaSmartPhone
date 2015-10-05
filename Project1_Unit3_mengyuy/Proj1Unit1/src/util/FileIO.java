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

import exception.AutoException;
import exception.CustomException;
import model.Automobile;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The FileIO class contains methods for read/write data.
 */
public class FileIO {
	
	private Logger logger;
	private static final String LOGGER_NAME = "log.txt";
	// constructor
	public FileIO() {
		logger = new Logger(LOGGER_NAME);
	}
	
	// build an Automotive object given a plain input file
	public Automobile buildAutoObject(String filename) {
		Automobile automobile = null;
		try {
			BufferedReader buff = new BufferedReader(new FileReader(filename));
			String line;
			int numOptSets = 0;
			
			// initial automotive
			if ( (line = buff.readLine()) != null) {
				try {
					String[] fields = line.trim().split(":");
					if (fields == null || fields.length != 3) {
						throw new AutoException(CustomException.MODEL_INFO_INCOMPLETE);
					} else if (Integer.parseInt(fields[1]) < 0) {
						throw new AutoException(CustomException.AUTO_PRICE_INVALID);
					}
					numOptSets = Integer.parseInt(fields[2]);
					automobile = new Automobile(fields[0], Integer.parseInt(fields[1]));
				} catch (AutoException autoException) {
					logger.log("Error: " + autoException.toString());
					autoException.fix(automobile);
					buff.close();
					return automobile;
				}
			}
			
			// build up option set
			while ((line = buff.readLine()) != null) {
				line = line.trim();
				if (line.startsWith("OptionSet")) {
					try {
						String[] fields = line.trim().split(":");
						if (fields == null || fields.length != 3) {
							continue;
						}
						String property = fields[1].trim();
						String optionSize = fields[2].trim();
				
						line = buff.readLine();
						String[] contents = line.split(";");
				
						if (automobile.findOptionSet(property) != null) {
							throw new AutoException(CustomException.OPTION_SET_ALREADY_EXIST,
									property, contents, Integer.parseInt(optionSize));
						}
				/*
						if (contents.length < Integer.parseInt(optionSize)) {
							throw new AutoException(CustomException.MISSING_OPTION_DATA);
						}*/
						automobile.addOptset(property, contents, Integer.parseInt(optionSize));
		
					} catch (AutoException autoException) {
						logger.log("Error: " + autoException.toString());
						autoException.fix(automobile);
					}
				}
			}
			try {
				if (automobile.getOptsets().size() != numOptSets) {
					throw new AutoException(CustomException.MISSING_OPTIONSET_DATA);
				}
			} catch (AutoException autoException) {
				logger.log("Error: " + autoException.toString());
				autoException.fix(automobile);
			}
			buff.close();
		} catch (IOException e) {
			logger.log("Error: " + e.toString());
		}
		return automobile;
	}
	
	// read serialized object from the file
	public Automobile readSerializedFile(String filename) {
		try {
			ObjectInputStream in= new ObjectInputStream(new FileInputStream(filename));
			Automobile auto = (Automobile) in.readObject();
			in.close();
			return auto;
		} catch (FileNotFoundException e) {
			logger.log("Error: " + e.toString());
		} catch (IOException e) {
			logger.log("Error: " + e.toString());
		} catch (ClassNotFoundException e) {
			logger.log("Error: " + e.toString());
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
			logger.log("Error: " + e.toString());
		} catch (IOException e) {
			logger.log("Error: " + e.toString());
		}
	}
}
