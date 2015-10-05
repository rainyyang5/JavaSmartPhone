package scale;

import java.util.ArrayList;

/* 
 * created by Mengyu Yang(AndrewID: mengyuy)
 * This is a class that implement command for calling syn/asyn method
 */
public class Command {

	private CommandLine cmdLine;
	private ArrayList<Object> inputs = new ArrayList<Object>();
	
	/* constructor */
	public Command() {}
	public Command(CommandLine commandLine, Object[] input) {
		cmdLine = commandLine;
		for (int i = 0; i < input.length; i++) {
			inputs.add(input[i]);
		}
	}
	
	// store syn/asyn methods' names
	public static enum CommandLine {
		asynUpdateOptionSetName,
		asynUpdateOptionPrice,
		asynDeleteOptionSet,
		asynDeleteOption,
		synUpdateOptionSetName,
		synUpdateOptionPrice,
		synDeleteOptionSet,
		synDeleteOption
	}
	
	/* getter and setter */
	public CommandLine getCommandLine() {
		return this.cmdLine;
	}
	
	public ArrayList<Object> getInputs() {
		return this.inputs;
	}
	
	public void setCommand(CommandLine commandLine, Object[] input) {
		cmdLine = commandLine;
		for (int i = 0; i < input.length; i++) {
			inputs.add(input[i]);
		}
	}
}
