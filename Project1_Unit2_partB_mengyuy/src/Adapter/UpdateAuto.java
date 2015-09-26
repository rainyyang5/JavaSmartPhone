package Adapter;


/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is the interface for updating automobile
 */

public interface UpdateAuto {
	public void updateOptionSetName(String modelName, String optionSetName, String newName);
	public void updateOptionPrice(String modelName, String optionName, String option, float newPrice);
}
