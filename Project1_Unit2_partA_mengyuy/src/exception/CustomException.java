package exception;

/*
 * Created by Mengyu Yang(Mengyu Yang)
 * This is enum for custom exceptions
 */
public enum CustomException {
	
	AUTO_PRICE_INVALID(0, "The price for Automobile is invalid, please check the price for automobile"),
	MISSING_OPTIONSET_DATA(1, "The optionSet data is missing, please check the input file"),
	MISSING_OPTION_DATA(2, "The option data is missing, please check the input file."),
	OPTION_SET_ALREADY_EXIST(3, "The option set is duplicated. It is fixed by created a new optionSet with a new name."),
	MODEL_INFO_INCOMPLETE(4, "The model information is incompleted, please check the input file");

	private final String msg;
	private final int expNum;
	
	/* constructor */
	private CustomException(int expNum, String msg) {
		this.msg = msg;
		this.expNum = expNum;
	}

	public String getMsg() {
		return msg;
	}

	public int getExpNum() {
		return expNum;
	}
	
	@Override
	public String toString() {
		return msg;
	}
}
