package scale;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import scale.Command.CommandLine;
import model.Automobile;

/*
 * Created by Mengyu Yang (mengyuy)
 * This is a class that implements syncronized methods for updating and deleting
 * part of optionsset and option
 *
 */
public class EditOptions extends Thread{

	private static LinkedHashMap<String, Automobile> autos = new LinkedHashMap<String, Automobile>();
	private Command command = new Command();

	public EditOptions(LinkedHashMap<String, Automobile> autos) {
		this.autos = autos;
	}

	/* All the syncronized code are written in this class.
	 * Every time when a user wants to update/delete part of option set or option
	 * a EditOptions thread will be created. 
	 * When the update/delete methods are running, the automobile will be locked 
	 * and only one method can touch the automobile at a time
	 */
	public void run() {
		ArrayList<Object> inputs = command.getInputs();
		switch(command.getCommandLine()) {
		case asynUpdateOptionSetName:
			this.asynUpdateOptionSetName((String)inputs.get(0), 
					(String)inputs.get(1), (String)inputs.get(2));
			break;
		case asynUpdateOptionPrice:
			this.asynUpdateOptionPrice((String)inputs.get(0), 
					(String)inputs.get(1), (String)inputs.get(2),
					(float)((Float) inputs.get(3)));
			break;
		case asynDeleteOptionSet:
			this.asynDeleteOptionSet((String)inputs.get(0), 
					(String)inputs.get(1));
			break;
		case asynDeleteOption:
			this.asynDeleteOption((String)inputs.get(0), 
					(String)inputs.get(1), (String)inputs.get(2));
			break;
		case synUpdateOptionSetName:
			this.synUpdateOptionSetName((String)inputs.get(0), 
					(String)inputs.get(1), (String)inputs.get(2));
			break;
		case synUpdateOptionPrice:
			this.synUpdateOptionPrice((String)inputs.get(0), 
					(String)inputs.get(1), (String)inputs.get(2),
					(float)((Float) inputs.get(3)));
			break;
		case synDeleteOptionSet:
			this.synDeleteOptionSet((String)inputs.get(0), 
					(String)inputs.get(1));
			break;
		case synDeleteOption:
			this.synDeleteOption((String)inputs.get(0), 
					(String)inputs.get(1), (String)inputs.get(2));
			break;
		
		}
	}
	
	
	// sync update option set
	public void synUpdateOptionSetName(String model, String optSetName,
			String newName) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		synchronized(auto) {
			if (auto.updateOptionSetName(optSetName, newName)) {
				System.out.println("The new option set name is: " + newName);
			} else {
				System.out.println("Fail to update optionSet Name.");
			}
		}
	}

	// sync option price
	public void synUpdateOptionPrice(String model, String optSetName,
			String optionName, float newPrice) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		synchronized(auto) {
			if (auto.updateOptionPrice(optSetName, optionName, newPrice)) {
				System.out.println("The new option price is: " + String.valueOf(newPrice));
			} else {
				System.out.println("Fail to update option price.");
			}
		}
	}

	// sync delete option set
	public void synDeleteOptionSet(String model, String optSetName) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		synchronized(auto) {
			if (auto.deleteOpionSet(optSetName)) {
				System.out.println("The option set " + optSetName + " has been deleted.");
			} else {
				System.out.println("fail to delete option set " + optSetName +
						". The option set may already be deleted.");
				return;
			}
		}
	}

	// sync delete option 
	public void synDeleteOption(String model, String optSetName,
			String optionName) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		synchronized(auto) {
			if (auto.deleteOption(optSetName, optionName) ) {
				System.out.println("The option " + optionName + " has been deleted.");
			} else {
				System.out.println("Fail to delte option " + optionName + 
						". The option may already be delted.");
			}
			
		}
	}
	
	
	/* async methods for testing */
	// async update option set
	public void asynUpdateOptionSetName(String model, String optSetName,
			String newName) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		if (auto.updateOptionSetName(optSetName, newName)) {
			System.out.println("The new option set name is: " + newName);
		} else {
			System.out.println("Fail to update optionSet Name");
		}
		
	}

	// async update option price
	public void asynUpdateOptionPrice(String model, String optSetName,
			String optionName, float newPrice) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		if (auto.updateOptionPrice(optSetName, optionName, newPrice)) {
			System.out.println("The new option price is: " + String.valueOf(newPrice));
		} else {
			System.out.println("Fail to update option price.");
		}
		
	}

	// async delete option set
	public void asynDeleteOptionSet(String model, String optSetName) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		
		if (autos.get(model).deleteOpionSet(optSetName)) {
			System.out.println("The option set " + optSetName + " has been deleted.");
		} else {
			System.out.println("Fail to delete option set " + optSetName);
		}
		
	}

	// async delete option
	public void asynDeleteOption(String model, String optSetName,
			String optionName) {
		Automobile auto = autos.get(model);
		if (auto == null) {
			System.out.println("automobile does not exist given the model name: " + model);
			return;
		}
		
		if (autos.get(model).deleteOption(optSetName, optionName)) {
			System.out.println("The option " + optionName + "has been deleted.");
		} else {
			System.out.println("Fail to delte option " + optionName);
		}
		
	}

	public void setCmd(CommandLine line, Object... inputs) {
		command.setCommand(line, inputs);
	}
}
