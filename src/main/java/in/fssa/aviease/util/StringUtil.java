package in.fssa.aviease.util;

import java.time.LocalDate;

import in.fssa.aviease.exception.ValidationException;

public class StringUtil {


	public static void rejectIfInvalidString(String input, String inputName) throws ValidationException {
		if (input == null || "".equals(input.trim())) {
			throw new ValidationException(inputName.concat(" cannot be Null or Empty"));
		}
	}

	public static void rejectIfInvalidDate(LocalDate date, String inputName) throws ValidationException {
		LocalDate currentDate = LocalDate.now();
		if (date.isBefore(currentDate)) {
			throw new ValidationException(inputName.concat(" can not be in the Past"));
		}
	}

	public static boolean isValidString(String newString) {

		if (newString == null || "".equals(newString.trim())) {

			return false;
		}
		return true;

	}

	public static boolean isInvalidString(String newString) {

		if (!isValidString(newString)) {

			return true;
		}
		return false;

	}
	
	public static void rejectIfInvalidMobileNo(long mobileNo) throws ValidationException {
		
		if(mobileNo < 6000000001l && mobileNo > 9999999999l) {
			throw new ValidationException("invalid mobile number");
		}
		
	}
}
