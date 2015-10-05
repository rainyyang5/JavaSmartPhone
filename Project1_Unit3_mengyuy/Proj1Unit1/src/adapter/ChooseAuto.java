package adapter;

import model.OptionSet;

/* Created by Mengyu Yang(mengyuy)
 * this is the interface for auto choices.
 */
public interface ChooseAuto {
	
	// Get price for a choice
	public int getOptionChoicePrice(String optSetName, String modelName);
	
	// Get choice for a optionSet
	public String getOptionChoice(String optSetName, String modelName);
	
	// Set choice for a optionSet
	public void setOptionChoice(String optSetName, String optionName, String modelName);
	
	// get total price given all the choices in all the optionSets
	public int getTotalPrice(String modelName);
	
}
