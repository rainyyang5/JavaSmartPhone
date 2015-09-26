package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import exception.AutoException;
import exception.CustomException;
import model.OptionSet.Option;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The Automotive class represents a model with name, basePrice
 * and a optionSet array
 */
public class Automobile implements Serializable{
	
	//private String name;
	private String make;
	private String model;
	private int basePrice;
	private ArrayList<OptionSet> optsets;
	private ArrayList<Option> choice;

	/* Constructors */
	public Automobile() {
		optsets = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
	}
	
	public Automobile(String model, int price) {
		optsets = new ArrayList<OptionSet>();
		choice = new ArrayList<Option>();
		this.model = model;
		this.basePrice = price;
	}
	
	// Get price for a choice
	public int getOptionChoicePrice(String optSetName) {
		Option option = this.findOptionSet(optSetName).getOptionChoice();
		return (int)option.getPrice();
	}
	
	// Get choice for a optionSet
	public String getOptionChoice(String optSetName) {
		try {
			return this.findOptionSet(optSetName).getOptionChoice().getName();
		} catch (Exception e) {
			return null;
		}
	}
	
	// Set choice for a optionSet
	public void setOptionChoice(String optSetName, String optionName) {
		this.findOptionSet(optSetName).setOptionChoice(optionName);
	}
	
	// get total price given all the choices in all the optionSets
	public int getTotalPrice() {
		int total = this.basePrice;
		for (OptionSet optset : this.optsets) {
			try {
				total += optset.getOptionChoice().getPrice();
			} catch(Exception e) {
				
			}
		}
		return total;
	}
	
	

	
	// find a optionSet given name
	public OptionSet findOptionSet(String name) {
		int index = findOptionSetIndex(name);
		if (index == -1) {
			return null;
		} else {
			return optsets.get(index);
		}
	}
	
	public int findOptionSetIndex(String name) {
		for (int i = 0; i < optsets.size(); i++) {
			if (optsets.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	// delete a optionSet given name
	public boolean deleteOpionSet(String name) {
		int index = findOptionSetIndex(name);
		try {
			optsets.remove(index);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	
	// update a optionSet given name and the String array for new optionSet
	public boolean updateOptionSet(String name, String[] opts) {
		OptionSet optset = findOptionSet(name);
		if (optset == null) {
			return false;
		}
		optset.setOpts(opts);
		return true;
	}
	
	// update optionSet name to newName
	public boolean updateOptionSetName(String name, String newName) {
		try {
			findOptionSet(name).setName(newName);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	// update option price given optionSet name and optionName
	public boolean updateOptionPrice(String optionSetName, String optionName, float newPrice) {
		try {
			findOptionSet(optionSetName).findOption(optionName).setPrice(newPrice);
			return true;
		} catch (NullPointerException e) {
			return false;
		}
	}
	
	// print the automotive information
	public void print() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(this.getModel()).append(":").append(this.getBasePrice()).append(":").append(this.getOptsets().size());
		System.out.println(strBuilder.toString());
		for (OptionSet optset : optsets) {
			optset.print();
		}
	}
	
	/* 
	 * getter and setter
	 */
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public ArrayList<Option> getChoice() {
		return choice;
	}

	public void setChoice(ArrayList<Option> choice) {
		this.choice = choice;
	}

	public int getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(int basePrice) {
		this.basePrice = basePrice;
	}

	public List<OptionSet> getOptsets() {
		return optsets;
	}

	public void setOptsets(ArrayList<OptionSet> optsets) {
		this.optsets = optsets;
	}
	
	public void addOptset(String name, String[] opts, int size) {
		OptionSet optset = new OptionSet();
		optset.setName(name);
		optset.setOpts(opts);
		optsets.add(optset);
		try {
			if (optset.getOpts().size() != size) {
				throw new AutoException(CustomException.MISSING_OPTION_DATA);
			}
		} catch (AutoException autoException) {
			autoException.fix(this);
		}
	}
	
}
