package Adapter;

import exception.AutoException;
import util.FileIO;
import model.Automobile;

/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is the abstract class that implements build, update and print for automobile.
 */
public abstract class ProxyAutomobile {
	
	private Automobile auto;
	
	// Searches the model for a given OptionSet and sets the name of OptionSet to newName
	public void updateOptionSetName(String modelName, String optionSetName, String newName) {
		if (auto.getName().equals(modelName)) {
			if (!auto.updateOptionSetName(optionSetName, newName)) {
				System.out.println("Fail to update optionSet name.");
			}
		}
	}
	
	// searches the model for a given OptionSet and Option name and set the price to newPrice
	public void updateOptionPrice(String modelName, String optionSetName, String option, float newPrice){
		if (auto.getName().equals(modelName)) {
			if (!auto.updateOptionPrice(optionSetName, option, newPrice)) {
				System.out.println("Fail to update option price.");
			}
		}
	}
	
	// Build an instance of Automobile given a text file
	public void buildAuto(String filename) {
		FileIO fileIO = new FileIO();
		auto = fileIO.buildAutoObject(filename);
	}
	
	// Searches and prints the properties of a given Automodel
	public void printAuto(String modelName) {
		if (auto == null) {
			return;
		}
		if (auto.getName().equals(modelName)) {
			auto.print();
		} else {
			System.out.println("Model is not found given the modelName: " + modelName);
		}
	}
	
	public void fix(AutoException autoExp) {
		autoExp.fix(auto);
	}
}
