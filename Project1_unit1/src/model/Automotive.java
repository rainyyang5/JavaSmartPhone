package model;

import java.io.Serializable;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The Automotive class represents a model with name, basePrice
 * and a optionSet array
 */
public class Automotive implements Serializable{
	
	private String name;
	private int basePrice;
	private OptionSet[] optsets;

	/* Constructors */
	public Automotive() {}
	
	public Automotive(String name, int basePrice, int optionSetSize) {
		this.name = name;
		this.basePrice = basePrice;
		this.optsets = new OptionSet[optionSetSize];
		
		for (int i = 0; i < optsets.length; i++) {
			optsets[i] = new OptionSet();
		}
	}
	
	// find a optionSet given name
	public OptionSet findOptionSet(String name) {
		for (OptionSet optionSet : optsets) {
			if (optionSet.getName().equals(name)) {
				return optionSet;
			}
		}
		return null;
	}
	
	// delete a optionSet given name
	public boolean deleteOptionSet(String name) {
		int length = optsets.length;
		if (length <= 0) {
			return false;
		}
		OptionSet[] newOptSets = new OptionSet[length - 1];
		int index = 0;
		for (OptionSet optSet : optsets) {
			if (optSet.getName().equals(name)) {
				continue;
			} else {
				newOptSets[index++] = optSet;
			}
		}
		optsets = newOptSets;
		return true;
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
	
	// print the automotive information
	public void print() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(this.getName()).append(":").append(this.getBasePrice()).append(":").append(this.getOptsets().length);
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

	public OptionSet[] getOptsets() {
		return optsets;
	}

	public void setOptsets(OptionSet[] optsets) {
		this.optsets = optsets;
	}
	
	public OptionSet getOptsetByIndex(int i) {
		return optsets[i];
	}

	public void setOptsetByIndex(int i, String name, String[] opts, int size) {
		OptionSet optset = new OptionSet(name, size);
		optset.setOpts(opts);
		this.optsets[i] = optset;
	}
	
}
