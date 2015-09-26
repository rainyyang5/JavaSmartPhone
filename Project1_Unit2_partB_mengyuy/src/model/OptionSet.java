package model;

import java.io.Serializable;
import java.util.ArrayList;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The OptionSet class represents an OptionSet with name and an option list
 */
public class OptionSet implements Serializable{
	
	private ArrayList<Option> opts;
	private String name;
	private Option choice = null;
	
	/* Constructors */
	protected OptionSet() {
		opts = new ArrayList<Option>();
	}
	
	protected OptionSet(String n) {
		name = n;
		opts = new ArrayList<Option>();
	}
	
	
	// find option by name
	protected Option findOption(String name) {
		int index = findOptionIndex(name);
		if (index == -1) {
			return null;
		} else {
			return opts.get(index);
		}
	}
	
	protected int findOptionIndex(String name) {
		for (int i = 0; i < opts.size(); i++) {
			if (opts.get(i).getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}
	
	// delete option given name
	protected boolean deleteOption(String name) {
		int index = findOptionIndex(name);
		try {
			opts.remove(index);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	// update option given name and new price
	protected boolean updateOption(String name, float price) {
		try {
			int index = findOptionIndex(name);
			opts.get(index).setPrice(price);
			return true;
		} catch(Exception e) {
			return false;
		}
	}
	
	// print the optionSet information
	protected void print() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("OptionSet:").append(this.getName()).append(":").append(this.getOpts().size());
		System.out.println(strBuilder.toString());
		for (Option opt : opts) {
			opt.print();
		}
	}
	
	protected Option getOptionChoice() {
		return choice;
	}
	
	protected void setOptionChoice(String optionName) {
		choice = this.findOption(optionName);
	}
	
	/* Getters and Setters */
	protected ArrayList<Option> getOpts() {
		return opts;
	}
	protected void setOpts(String[] options) {
		for (String str : options) {
			String[] fields = str.split(",");
			if (fields == null || fields.length != 2) {
				continue;
			}
			opts.add(new Option(fields[0], Float.parseFloat(fields[1])));
		}
	}
	
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	
	/* Inner class for Option */
	protected class Option implements Serializable {
		private String name;
		private float price;
		
		// Constructors
		protected Option() {}
		protected Option(String name, float price) {
			this.name = name;
			this.price = price;
		}
		
		protected String getName() {
			return name;
		}
		protected void setName(String name) {
			this.name = name;
		}
		protected float getPrice() {
			return price;
		}
		protected void setPrice(float price) {
			this.price = price;
		}
		
		// Print the option information
		protected void print() {
			StringBuilder strBuilder = new StringBuilder();
			strBuilder.append(this.getName()).append(", ").append(this.getPrice()).append(";");
			System.out.println(strBuilder.toString());
		}
	}
}
