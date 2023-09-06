package in.fssa.aviease.util;

import java.time.LocalDate;
import in.fssa.aviease.exception.ValidationException;

public class StringUtil {


	 /**
     * Rejects the string input if it is null or empty.
     *
     * @param input The string input to be validated.
     * @param inputName The name of the input for error messages.
     * @throws ValidationException If the string input is null or empty.
     */
	public static void rejectIfInvalidString(String input, String inputName) throws ValidationException {
		if (input == null || "".equals(input.trim())) {
			throw new ValidationException(inputName.concat(" cannot be Null or Empty"));
		}
	}

	
	 /**
     * Rejects the date if it is in the past.
     *
     * @param date The date input to be validated.
     * @param inputName The name of the input for error messages.
     * @throws ValidationException If the date is in the past.
     */
	public static void rejectIfInvalidDate(LocalDate date, String inputName) throws ValidationException {
		LocalDate currentDate = LocalDate.now();
		if (date.isBefore(currentDate)) {
			throw new ValidationException(inputName.concat(" can not be in the Past"));
		}
	}

	
	/**
     * Checks if a string is valid (not null or empty).
     *
     * @param newString The string to be checked.
     * @return true if the string is valid, otherwise false.
     */
	public static boolean isValidString(String newString) {

		if (newString == null || "".equals(newString.trim())) {

			return false;
		}
		return true;

	}

	/**
     * Checks if a string is invalid (null or empty).
     *
     * @param newString The string to be checked.
     * @return true if the string is invalid, otherwise false.
     */
	public static boolean isInvalidString(String newString) {

		if (!isValidString(newString)) {

			return true;
		}
		return false;

	}
	

}
