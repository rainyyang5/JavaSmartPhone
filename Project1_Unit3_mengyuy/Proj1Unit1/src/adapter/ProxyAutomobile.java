package adapter;

import java.util.LinkedHashMap;

import exception.AutoException;
import scale.Command.CommandLine;
import scale.EditOptions;
import util.FileIO;
import model.Automobile;


/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is the abstract class that implements build, update and print for automobile.
 */
public abstract class ProxyAutomobile {
	
	//private Automobile auto;
	private static LinkedHashMap<String, Automobile> autos = new LinkedHashMap<String, Automobile>();
	
	public LinkedHashMap<String, Automobile> getAutos() {
		return autos;
	}

	public void setAutos(LinkedHashMap<String, Automobile> autos) {
		this.autos = autos;
	}

	// Searches the model for a given OptionSet and sets the name of OptionSet to newName
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		if (autos.containsKey(modelName)) {
			if (autos.get(modelName).getModel().equals(modelName)) {
				if (!autos.get(modelName).updateOptionSetName(optionSetName, newName)) {
					System.out.println("Fail to update optionSet name.");
				}
			}
		}
	}
	
	// searches the model for a given OptionSet and Option name and set the price to newPrice
	public void updateOptionPrice(String modelName, String optionSetName, String option, float newPrice){
		if (autos.containsKey(modelName)) {
			Automobile auto = autos.get(modelName);
			if (auto.getModel().equals(modelName)) {
				if (!auto.updateOptionPrice(optionSetName, option, newPrice)) {
					System.out.println("Fail to update option price.");
				}
			}
		}
	}
	

	
	
	// sync update
	public void synUpdateOptionSetName(String model, String optSetName,
			String newName) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.synUpdateOptionSetName,
				model, optSetName, newName);
		editOptions.start();
	}

	public void synUpdateOptionPrice(String model, String optSetName,
			String optionName, float newPrice) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.synUpdateOptionPrice, 
				model, optSetName, optionName, newPrice);
		editOptions.start();
		
	}

	// sync delete
	public void synDeleteOptionSet(String model, String optSetName) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.synDeleteOptionSet, model, optSetName);
		editOptions.start();
	}

	public void synDeleteOption(String model, String optSetName,
			String optionName) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.synDeleteOption, model, optSetName, optionName);
		editOptions.start();
	}
	
	// async update for testing
	public void asynUpdateOptionSetName(String model, String optSetName,
			String newName) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.asynUpdateOptionSetName,
				model, optSetName, newName);
		editOptions.start();
	}

	public void asynUpdateOptionPrice(String model, String optSetName,
			String optionName, float newPrice) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.asynUpdateOptionPrice, 
				model, optSetName, optionName, newPrice);
		editOptions.start();
		
	}

	// async delete for testing
	public void asynDeleteOptionSet(String model, String optSetName) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.asynDeleteOptionSet, model, optSetName);
		editOptions.start();
	}

	public void asynDeleteOption(String model, String optSetName,
			String optionName) {
		EditOptions editOptions = new EditOptions(autos);
		editOptions.setCmd(CommandLine.asynDeleteOption, model, optSetName, optionName);
		editOptions.start();
	}
	
	
	
	
	
	// Build an instance of Automobile given a text file
	public void buildAuto(String filename) {
		FileIO fileIO = new FileIO();
		Automobile auto = fileIO.buildAutoObject(filename);
		if (auto != null) {
			autos.put(auto.getModel(), auto);
		}
	}
	
	// Searches and prints the properties of a given Automodel
	public void printAuto(String modelName) {
		if (autos.containsKey(modelName)) {
			Automobile auto = autos.get(modelName);
			if (auto == null) {
				return;
			}
			if (auto.getModel().equals(modelName)) {
				auto.print();
			} else {
				System.out.println("Model is not found given the modelName: " + modelName);
			}
		}
	}
	
	public void fix(AutoException autoExp, String model) {
		Automobile auto = autos.get(model);
		autoExp.fix(auto);
	}
	
	// Get total price
	public int getTotalPrice(String model) {
		return autos.get(model).getTotalPrice();
	}
	
	// Get price for a choice
	public int getOptionChoicePrice(String optSetName, String modelName) {
		Automobile auto = autos.get(modelName);
		return auto.getOptionChoicePrice(optSetName);
	}
	
	// Get choice for a optionSet
	public String getOptionChoice(String optSetName, String modelName) {
		try {
			Automobile auto = autos.get(modelName);
			return auto.getOptionChoice(optSetName);
		} catch (Exception e) {
			return null;
		}
	}
	
	// Set choice for a optionSet
	public void setOptionChoice(String optSetName, String optionName, String modelName) {
		Automobile auto = autos.get(modelName);
		auto.setOptionChoice(optSetName, optionName);
	}
	
}
