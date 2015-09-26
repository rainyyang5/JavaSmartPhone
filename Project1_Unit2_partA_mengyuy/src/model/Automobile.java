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
	
	private String name;
	private int basePrice;
	private ArrayList<OptionSet> optsets;

	/* Constructors */
	public Automobile() {}
	
	public Automobile(String name, int basePrice) {
		this.name = name;
		this.basePrice = basePrice;
		optsets = new ArrayList<OptionSet>();
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
		strBuilder.append(this.getName()).append(":").append(this.getBasePrice()).append(":").append(this.getOptsets().size());
		System.out.println(strBuilder.toString());
		for (OptionSet optset : optsets) {
			optset.print();
		}
	}
	
	/* 
	 * getter and setter
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
