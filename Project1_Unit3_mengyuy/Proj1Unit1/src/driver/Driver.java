package driver;

import adapter.BuildAuto;
import exception.AutoException;
import exception.CustomException;
import model.Automobile;
import scale.EditOptions;
import util.FileIO;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The Driver class is the main function that tests the fileIO, interfaces and exception handle
 */
public class Driver extends Thread{
	
	private static final String INPUT_FILENAME = "FordZTW.txt";
	private static final String INPUT_FILENAME2 = "Toyota.txt";
	
	private static final String MODEL_NAME = "Focus Wagon ZTW";
	private static final String MODEL_NAME2 = "Toyota";
	
	private static final String SYN_OPTIONSET_NAME = "Transmission";
	private static final String SYN_OPTIONSET_NAME2 = "Transmission2";
	private static final String SYN_OPTIONSET_NAME3 = "Transmission3";
	private static final String SYN_OPTIONSET_NAME4 = "Transmission4";
	
	private static final String ASYN_OPTIONSET_NAME = "Air Bags";
	private static final String ASYN_OPTIONSET_NAME2 = "Air Bags2";
	private static final String ASYN_OPTIONSET_NAME3 = "Air Bags3";
	private static final String ASYN_OPTIONSET_NAME4 = "Air Bags4";
	
	private static final String DELETE_OPTIONSET_NAME = "BrakesTraction Control";
	private static final String DELETE_OPTION = "standard";
	private static final String LAST_OPTIONSET_NAME = "Power Moonroof";
	
	private static final String SYN_PRICE_OPTIONSET = "Color";
	private static final String SYN_PRICE_OPTION = "Fort Knox Gold Clearcoat Metallic";
	private static final float SYN_PRICE = 1f;
	private static final float SYN_PRICE2 = 2f;
	private static final float SYN_PRICE3 = 3f;
	
	
	
	private static BuildAuto buildAuto = new BuildAuto();
	
	public void run() {
		
		
		/* Test sync update */
		System.out.println("---------Sync update price--------");
		buildAuto.synUpdateOptionPrice(MODEL_NAME, SYN_PRICE_OPTIONSET, SYN_PRICE_OPTION, SYN_PRICE);
		buildAuto.synUpdateOptionPrice(MODEL_NAME, SYN_PRICE_OPTIONSET, SYN_PRICE_OPTION, SYN_PRICE2);
		buildAuto.synUpdateOptionPrice(MODEL_NAME, SYN_PRICE_OPTIONSET, SYN_PRICE_OPTION, SYN_PRICE3);
		
		// Add sleep time between each testing block so that the printing of test block is in order
		// only for test output printing
		try {
			Thread.sleep(1200); 
		} catch (InterruptedException e) {
			System.out.println("interrupted.");
		}
		
		System.out.println("---------Sync update option set name--------");
		buildAuto.synUpdateOptionSetName(MODEL_NAME, SYN_OPTIONSET_NAME, SYN_OPTIONSET_NAME2);
		buildAuto.synUpdateOptionSetName(MODEL_NAME, SYN_OPTIONSET_NAME2, SYN_OPTIONSET_NAME3);
		buildAuto.synUpdateOptionSetName(MODEL_NAME, SYN_OPTIONSET_NAME3, SYN_OPTIONSET_NAME4);
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			System.out.println("interrupted.");
		}
		
		
		
		/* Test async update */
		System.out.println("---------Async update price--------");
		buildAuto.synUpdateOptionPrice(MODEL_NAME, SYN_PRICE_OPTIONSET, SYN_PRICE_OPTION, SYN_PRICE);
		buildAuto.synUpdateOptionPrice(MODEL_NAME, SYN_PRICE_OPTIONSET, SYN_PRICE_OPTION, SYN_PRICE2);
		buildAuto.synUpdateOptionPrice(MODEL_NAME, SYN_PRICE_OPTIONSET, SYN_PRICE_OPTION, SYN_PRICE3);
		try {
			Thread.sleep(1200);
		} catch (InterruptedException e) {
			System.out.println("interrupted.");
		}
		
		System.out.println("---------Async update option set name--------");
		buildAuto.synUpdateOptionSetName(MODEL_NAME2, ASYN_OPTIONSET_NAME, ASYN_OPTIONSET_NAME2);
		buildAuto.synUpdateOptionSetName(MODEL_NAME2, ASYN_OPTIONSET_NAME2, ASYN_OPTIONSET_NAME3);
		buildAuto.synUpdateOptionSetName(MODEL_NAME2, ASYN_OPTIONSET_NAME3, ASYN_OPTIONSET_NAME4);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			System.out.println("interrupted.");
		}
		
		
		/* Test sync delete */
		System.out.println("---------Sync delete optionset & option--------");
		buildAuto.synDeleteOption(MODEL_NAME, DELETE_OPTIONSET_NAME, DELETE_OPTION);
		buildAuto.synDeleteOptionSet(MODEL_NAME, LAST_OPTIONSET_NAME);
		buildAuto.synDeleteOptionSet(MODEL_NAME, LAST_OPTIONSET_NAME);
		buildAuto.synDeleteOptionSet(MODEL_NAME, LAST_OPTIONSET_NAME);
		buildAuto.synDeleteOptionSet(MODEL_NAME, LAST_OPTIONSET_NAME);
		try {
			Thread.sleep(35000);
		} catch (InterruptedException e) {
			System.out.println("interrupted.");
		}
				
		System.out.println("---------Async delete--------");
		buildAuto.synDeleteOption(MODEL_NAME2, DELETE_OPTIONSET_NAME, DELETE_OPTION);
		buildAuto.asynDeleteOptionSet(MODEL_NAME2, LAST_OPTIONSET_NAME);
		buildAuto.asynDeleteOptionSet(MODEL_NAME2, LAST_OPTIONSET_NAME);
		buildAuto.asynDeleteOptionSet(MODEL_NAME2, LAST_OPTIONSET_NAME);
		buildAuto.asynDeleteOptionSet(MODEL_NAME2, LAST_OPTIONSET_NAME);
		

	}
	
	public static void main(String[] args) {
		
		Driver driver = new Driver();
		
		/* Tests for basic methods */
		System.out.println("---------Print two models--------");
	
		buildAuto.buildAuto(INPUT_FILENAME);
		buildAuto.buildAuto(INPUT_FILENAME2);
	
		buildAuto.printAuto(MODEL_NAME);
		System.out.println();
		buildAuto.printAuto(MODEL_NAME2);
		System.out.println();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("interrupted.");
		}
		
		
		/* Test sync */
		driver.start();

	}
	
}
