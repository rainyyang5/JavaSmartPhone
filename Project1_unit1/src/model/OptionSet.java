package model;

import java.io.Serializable;

/* 
 * Created by Mengyu Yang(AndrewID: mengyuy)
 * The OptionSet class represents an OptionSet with name and an option array
 */
public class OptionSet implements Serializable{
	
	private Option[] opts;
	private String name;
	
	/* Constructors */
	protected OptionSet() {}
	protected OptionSet(String n, int size) {
		opts = new Option[size];
		name = n;
		
		for (int i = 0; i < opts.length; i++) {
			opts[i] = new Option();
		}	
	}
	
	
	// find option by name
	protected Option findOption(String name) {
		for (Option opt : opts) {
			if (opt.getName() == name) {
				return opt;
			}
		}
		return null;
	}
	
	
	// delete option given name
	protected boolean deleteOption(String name) {
		int length = opts.length;
		if (length <= 0) {
			return false;
		}
		Option[] newOpts = new Option[length - 1];
		int index = 0;
		for (Option opt : opts) {
			if (opt.getName() == name) {
				continue;
			} else {
				newOpts[index++] = opt;
			}
		}
		opts = newOpts;
		return true;
	}
	
	// update option given name and new price
	protected boolean updateOption(String name, float price) {
		Option opt = findOption(name);
		if (opt == null) {
			return false;
		}
		opt.setPrice(price);
		return true;
	}
	
	// print the optionSet information
	protected void print() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("OptionSet:").append(this.getName()).append(":").append(this.getOpts().length);
		System.out.println(strBuilder.toString());
		for (Option opt : opts) {
			opt.print();
		}
	}
	
	/* Getters and Setters */
	protected Option[] getOpts() {
		return opts;
	}
	protected void setOpts(String[] options) {
		int i = 0;
		int len = options.length;
		Option[] newOpts = new Option[len];
		for (String str : options) {
			String[] fields = str.split(",");
			if (fields == null || fields.length != 2) {
				continue;
			}
			Option opt = new Option(fields[0], Float.parseFloat(fields[1]));
			newOpts[i++] = opt;
		}
		opts = newOpts;
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
