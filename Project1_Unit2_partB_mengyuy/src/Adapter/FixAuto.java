package Adapter;

import exception.AutoException;


/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is the interface for fixing exception
 */
public interface FixAuto {
	public void fix(AutoException autoException, String modelName);
}
