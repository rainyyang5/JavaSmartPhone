package exception;

import model.Automobile;


/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is the class that includes all the fix functions for custom exceptions
 */

public class AutoException extends Exception {
	
	private Object[] inputs;
	private CustomException customException;
	
	/* Constructor */
	public AutoException() { super(); }
	
	public AutoException(CustomException customException, Object... inputs) {
		this.customException = customException;
		this.inputs = inputs;
	}
	
	
	@Override 
	public String getMessage() {
		return customException.getMsg();
	}
	
	@Override
	public String toString() {
		return customException.toString();
	}
	
	public void fix(Automobile autoMobile) {
		switch (customException) {
		
		// Completely fix exception
		case OPTION_SET_ALREADY_EXIST:
			OptSetExistFixer optSetExistFixer = new OptSetExistFixer();
			String optSetName = (String)inputs[0];
			String[] optSetData = (String[])inputs[1];
			int optionSize = (Integer)inputs[2];
			optSetExistFixer.fix(autoMobile, optSetName, optSetData, customException.toString(), optionSize);
			break;
			
		// Simple fix exceptions
		case AUTO_PRICE_INVALID:
		case MODEL_INFO_INCOMPLETE:
		case MISSING_OPTIONSET_DATA:
		case MISSING_OPTION_DATA:
			ExceptionAlerter alerter = new ExceptionAlerter();
			alerter.fix(customException.toString());
			break;
		}
	}

}
