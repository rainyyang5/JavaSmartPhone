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
	private static final String INPUT_FILENAME2 = "Toyota.txt";
	private static final String AUTO_PRICE_INVALID_FILE = "priceInvalid.txt";
	private static final String MISSING_OPTIONSET_DATA_FILE = "optionSetMissing.txt";
	private static final String MISSING_OPTION_DATA = "optionMissing.txt";
	private static final String OPTIONSET_ALREADY_EXIST_FILE = "optionSetExist.txt";
	private static final String MODEL_INFO_INCOMPLETE_FILE = "modelInfoIncomplete.txt";
	
	
	private static final String MODEL_NAME = "Focus Wagon ZTW";
	private static final String MODEL_NAME2 = "Toyota";
	private static final String OPTIONSET_NAME = "Color";
	private static final String OPTION_NAME = "Write";
	
	
	
	public static void main(String[] args) {
		
		/* Tests for basic methods */
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
		
	
		/* Test for multiple automobiles, LinkedHashMap */
		System.out.println("---------Build 2nd automobile--------");
		buildAuto.buildAuto(INPUT_FILENAME2);
		buildAuto.printAuto(MODEL_NAME2);
		
		System.out.println("---------Test setOptionChoic--------");
		int basePrice = buildAuto.getAutos().get(MODEL_NAME2).getBasePrice();
		System.out.printf("The basePrice for model2 is: " + String.valueOf(basePrice));
		System.out.println();
		buildAuto.setOptionChoice(OPTIONSET_NAME, OPTION_NAME, MODEL_NAME2);
		
		System.out.println("---------Test getOptionChoice--------");
		System.out.printf(buildAuto.getOptionChoice(OPTIONSET_NAME, MODEL_NAME2));
		System.out.println();
		
		System.out.println("---------Test getOptionChoicePrice--------");
		int price = buildAuto.getOptionChoicePrice(OPTIONSET_NAME, MODEL_NAME2);
		System.out.printf(String.valueOf(price) + '\n');
		
		System.out.println("---------Test getTotalPrice--------");
		int priceTotal = buildAuto.getTotalPrice(MODEL_NAME2);
		System.out.printf(String.valueOf(priceTotal) + '\n');
		

		/* Test for all the exception handle */
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
