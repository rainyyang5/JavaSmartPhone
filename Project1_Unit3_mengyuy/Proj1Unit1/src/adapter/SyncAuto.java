package adapter;

/* 
 * Created by Mengyu Yang (mengyuy)
 * This is the interface that defines the headers for sync/async methods.
 */
public interface SyncAuto {
	
	// sync update
	public void synUpdateOptionSetName(String model, String optSetName,
			String newName);

	public void synUpdateOptionPrice(String model, String optSetName,
			String optionName, float newPrice);

	// sync delete
	public void synDeleteOptionSet(String model, String optSetName);

	public void synDeleteOption(String model, String optSetName,
			String optionName);
	
	// asyn update
	public void asynUpdateOptionSetName(String model, String optSetName,
			String newName);

	public void asynUpdateOptionPrice(String model, String optSetName,
			String optionName, float newPrice);

	// asyn delete
	public void asynDeleteOptionSet(String model, String optSetName);

	public void asynDeleteOption(String model, String optSetName,
			String optionName);
}
