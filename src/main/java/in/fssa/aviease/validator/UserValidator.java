package in.fssa.aviease.validator;

import java.util.regex.Matcher;


import java.util.regex.Pattern;

import in.fssa.aviease.dao.UserDAO;
import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.util.StringUtil;

public class UserValidator {
	
	
	 /**
     * Validates the provided User object.
     *
     * @param newUser The User object to be validated.
     * @throws ValidationException If validation of the user fails.
     */
	public static void validateUser(User newUser) throws ValidationException {
		if (newUser == null) {
			throw new ValidationException("invalid user input");
		}
		StringUtil.rejectIfInvalidString(newUser.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(newUser.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(newUser.getFirstname(), "Firstname");
		StringUtil.rejectIfInvalidString(newUser.getLastname(), "Lastname");
	}
	
	/**
     * Validates a string value.
     *
     * @param input The string value to be validated.
     * @param inputName The name of the string value for error messages.
     * @throws ValidationException If validation of the string value fails.
     */
	public static void stringValidate(String input,String inputName) throws ValidationException {
		StringUtil.rejectIfInvalidString(input, inputName);
	
	}
	
	 /**
     * Validates the non-existence of a user with the given email.
     *
     * @param email The email to be validated.
     * @throws ValidationException If a user with the given email already exists.
     */
	public static void checkNotExistEmail(String email) throws ValidationException {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		try {
			user = userDAO.findByEmail(email);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(user != null) {
			throw new ValidationException("email already exist");
		}
	
	}
	
	/**
     * Validates the non-existence of a user with the given mobile number.
     *
     * @param mobile The mobile number to be validated.
     * @throws ValidationException If a user with the given mobile number already exists.
     */
	public static void checkNotExistMobileNo(long mobile) throws ValidationException {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		try {
			user = userDAO.findByMobileNo(mobile);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(user != null) {
			throw new ValidationException("mobile number already exist");
		}
		
	}
	
	 /**
     * Validates the existence of a user with the given email.
     *
     * @param email The email to be validated.
     * @throws ValidationException If a user with the given email does not exist.
     */
	public static void checkExistEmail(String email) throws ValidationException {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		try {
			user = userDAO.findByEmail(email);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(user == null) {
			throw new ValidationException("user not found");
		}
		
	}
	
	 /**
     * Validates the existence of a user with the given mobile number.
     *
     * @param mobile The mobile number to be validated.
     * @throws ValidationException If a user with the given mobile number does not exist.
     */
	public static void checkExistMobileNo(long mobile) throws ValidationException {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		try {
			user = userDAO.findByMobileNo(mobile);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(user == null) {
			throw new ValidationException("user not found");
		}
		
	}
	
	/**
     * Validates the existence of a user with the given ID.
     *
     * @param id The ID to be validated.
     * @throws ValidationException If a user with the given ID does not exist.
     */
	public static void checkExistid(int id) throws ValidationException {
		UserDAO userDAO = new UserDAO();
		User user = new User();
		
		try {
			user = userDAO.findById(id);
		} catch (PersistenceException e) {
			throw new ValidationException(e.getMessage());
		}
		
		if(user == null) {
			throw new ValidationException("user not found");
		}
		
	}

	 /**
     * Validates the format of an email.
     *
     * @param email The email to be validated.
     * @throws ValidationException If validation of the email format fails.
     */
	public static void emailValidate(String email) throws ValidationException {
		
		StringUtil.rejectIfInvalidString(email, "Email");

		String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new ValidationException("Invalid email format");
		}	

	}
	
	/**
     * Validates the format of a password.
     *
     * @param password The password to be validated.
     * @throws ValidationException If validation of the password format fails.
     */
	  public static void passwordValidate(String password) throws ValidationException {
	        StringUtil.rejectIfInvalidString(password, "Password");

	        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

	        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	        Matcher matcher = pattern.matcher(password);
	        if (!matcher.matches()) {
	            throw new ValidationException("Invalid password format");
	        }
	    }

	  /**
	     * Validates an integer ID.
	     *
	     * @param id The ID to be validated.
	     * @throws ValidationException If validation of the ID fails.
	     */
	public static void idValidate(int id) throws ValidationException {

		if(id<1) {
			throw new ValidationException("Invalid user id");
		}
	

	}

	/**
     * Validates a mobile number.
     *
     * @param mobile The mobile number to be validated.
     * @throws ValidationException If validation of the mobile number fails.
     */
	public static void mobileNoValidate(long mobile) throws ValidationException {
		
		if(mobile < 6000000001l || mobile > 9999999999l) {
			throw new ValidationException("invalid mobile number");
		}

	}

}
