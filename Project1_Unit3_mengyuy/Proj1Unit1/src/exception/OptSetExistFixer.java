package exception;

import model.Automobile;
/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is the class for fixing OptionSetAlreadyExistException
 */
public class OptSetExistFixer {

	// create a new option set with a new name
	public void fix(Automobile autoMobile, String optSetName,
			String[] optSetData, String msg, int optionSize) {
		
		String newName = generateNewName(autoMobile, optSetName);
		autoMobile.addOptset(newName, optSetData, optionSize);
	}
	
	
	// Create a new name for the duplicated option set name
	private String generateNewName(Automobile autoMobile, String optSetName) {
		int version = 2;
		String newName = optSetName + String.valueOf(version);
		while (autoMobile.findOptionSet(newName) != null) {
			version ++;
			newName = optSetName + String.valueOf(version);
		}
		return newName;
	}

}
