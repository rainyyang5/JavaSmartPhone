package driver;

import exception.AutoException;
import exception.CustomException;
import Adapter.BuildAuto;
import model.Automobile;
import util.FileIO;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The Driver class is the main function that tests the fileIO, interfaces and exception handle
 */
public class Driver {
	
	private static final String INPUT_FILENAME = "FordZTW.txt";
	private static final String AUTO_PRICE_INVALID_FILE = "priceInvalid.txt";
	private static final String MISSING_OPTIONSET_DATA_FILE = "optionSetMissing.txt";
	private static final String MISSING_OPTION_DATA = "optionMissing.txt";
	private static final String OPTIONSET_ALREADY_EXIST_FILE = "optionSetExist.txt";
	private static final String MODEL_INFO_INCOMPLETE_FILE = "modelInfoIncomplete.txt";
	
	
	private static final String MODEL_NAME = "Focus Wagon ZTW";
	
	public static void main(String[] args) {
		
		System.out.println("---------Print auto info given model name--------");
		BuildAuto buildAuto = new BuildAuto();
		buildAuto.buildAuto(INPUT_FILENAME);
		buildAuto.printAuto(MODEL_NAME);
		
		System.out.println("---------Print auto info after update option price--------");
		buildAuto.updateOptionPrice(MODEL_NAME, "Brakes/Traction Control", "standard", 135f);
		buildAuto.printAuto(MODEL_NAME);
		
		System.out.println("---------Print auto info after update optionSet name--------");
		buildAuto.updateOptionSetName(MODEL_NAME, "Brakes/Traction Control", "Brake Control" );
		buildAuto.printAuto(MODEL_NAME);
		
		System.out.println("---------Test fix method in FixAuto interface--------");
		try {
			throw new AutoException(CustomException.AUTO_PRICE_INVALID);
		} catch (AutoException autoExp) {
			buildAuto.fix(autoExp);
		}
		
		System.out.println("---------Test OptionSetAlreadyExistException (COMPLETED fix)--------");
		buildAuto.buildAuto(OPTIONSET_ALREADY_EXIST_FILE);
		buildAuto.printAuto(MODEL_NAME);
		
		
		System.out.println("---------Test ModelInfoIncompleteException(Simple fix)--------");
		buildAuto.buildAuto(MODEL_INFO_INCOMPLETE_FILE);
		buildAuto.printAuto(MODEL_NAME);

		System.out.println("---------Test AutoPriceInvalidException(Simple fix)--------");
		buildAuto.buildAuto(AUTO_PRICE_INVALID_FILE);
		buildAuto.printAuto(MODEL_NAME);
	
		System.out.println("---------Test MissingOptionsetDataException(Simple fix)--------");
		buildAuto.buildAuto(MISSING_OPTIONSET_DATA_FILE);
		buildAuto.printAuto(MODEL_NAME);
		
		System.out.println("---------Test MissingOptionException(Simple fix)--------");
		buildAuto.buildAuto(MISSING_OPTION_DATA);
		buildAuto.printAuto(MODEL_NAME);
		

	}
	
}
