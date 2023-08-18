package in.fssa.aviease.validator;

import java.util.regex.Matcher;

import java.util.regex.Pattern;

import in.fssa.aviease.dao.UserDAO;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.util.StringUtil;

public class UserValidator {
	
	
	
	public static void validate(User newUser) throws ValidationException {
		if (newUser == null) {
			throw new ValidationException("invalid user input");
		}
		StringUtil.rejectIfInvalidString(newUser.getEmail(), "Email");
		StringUtil.rejectIfInvalidString(newUser.getPassword(), "Password");
		StringUtil.rejectIfInvalidString(newUser.getFirstname(), "Firstname");
		StringUtil.rejectIfInvalidString(newUser.getLastname(), "Lastname");
	}
	
	
	public static void stringValidate(String input,String inputName) throws ValidationException {
		StringUtil.rejectIfInvalidString(input, inputName);
	
	}
	
	
	public static void checkNotExistEmail(String email) throws ValidationException {
		UserDAO userdao = new UserDAO();
		User user = new User();
		
		user = userdao.findByEmail(email);
		
		if(user != null) {
			throw new ValidationException("email already exist");
		}
	
	}
	
	public static void checkNotExistMobileNo(long mobile) throws ValidationException {
		UserDAO userdao = new UserDAO();
		User user = new User();
		
		user = userdao.findByMobileNo(mobile);
		
		if(user != null) {
			throw new ValidationException("mobile number already exist");
		}
		
	}
	
	public static void checkExistEmail(String email) throws ValidationException {
		UserDAO userdao = new UserDAO();
		User user = new User();
		
		user = userdao.findByEmail(email);
		
		if(user == null) {
			throw new ValidationException("user not found");
		}
		
	}
	
	
	public static void checkExistMobileNo(long mobile) throws ValidationException {
		UserDAO userdao = new UserDAO();
		User user = new User();
		
		user = userdao.findByMobileNo(mobile);
		
		if(user == null) {
			throw new ValidationException("user not found");
		}
		
	}
	
	public static void checkExistid(int id) throws ValidationException {
		UserDAO userdao = new UserDAO();
		User user = new User();
		
		user = userdao.findById(id);
		
		if(user == null) {
			throw new ValidationException("user not found");
		}
		
	}

	public static void emailValidate(String email) throws ValidationException {
		
		StringUtil.rejectIfInvalidString(email, "Email");

		String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		if (!matcher.matches()) {
			throw new ValidationException("Invalid email format");
		}	

	}
	
	
	  public static void passwordValidate(String password) throws ValidationException {
	        StringUtil.rejectIfInvalidString(password, "Password");

	        String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

	        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
	        Matcher matcher = pattern.matcher(password);
	        if (!matcher.matches()) {
	            throw new ValidationException("Invalid password format");
	        }
	    }

	public static void idValidate(int id) throws ValidationException {

		if(id<1) {
			throw new ValidationException("Invalid user id");
		}
	

	}

	public static void mobileNoValidate(long mobile) throws ValidationException {

		StringUtil.rejectIfInvalidMobileNo(mobile);

	}

}
