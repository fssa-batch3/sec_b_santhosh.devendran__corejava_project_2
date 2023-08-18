package in.fssa.aviease.service;

import java.util.List;

import in.fssa.aviease.Interface.Base;
import in.fssa.aviease.dao.UserDAO;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.validator.UserValidator;

public class UserService {
	
	
	UserDAO userdao = new UserDAO();
	
	/**
     * Creates a new user with validated data.
     *
     * @param user The user object to be created.
     * @throws ValidationException If validation of the user data fails.
     */
	public void create(User user) throws ValidationException {

		UserValidator.validate(user);
		UserValidator.emailValidate(user.getEmail());
		UserValidator.mobileNoValidate(user.getMobileNo());
		UserValidator.checkNotExistMobileNo(user.getMobileNo());
		UserValidator.checkNotExistEmail(user.getEmail());
		UserValidator.passwordValidate(user.getPassword());
		userdao.create(user);

	}
	
	 /**
     * Updates an existing user with validated data.
     *
     * @param newId The ID of the user to be updated.
     * @param newUser The updated user object.
     * @throws ValidationException If validation of the ID or user data fails.
     */
	public void update(int newId, User newUser) throws ValidationException {
		
		UserValidator.idValidate(newId);
		UserValidator.checkExistid(newId);
		UserValidator.stringValidate(newUser.getFirstname(), "Firstname");
		UserValidator.stringValidate(newUser.getLastname(), "Lastname");
		

		userdao.update(newId, newUser);

	}
	
	 /**
     * Counts the total number of users.
     *
     * @return The total number of users.
     */
	public int count() {
		return userdao.count();

	}
	


    /**
     * Finds a user by their ID.
     *
     * @param newId The ID of the user to be retrieved.
     * @return The found user.
     * @throws ValidationException If validation of the ID fails.
     */
	public User findById(int newId) throws ValidationException {
		
		UserValidator.idValidate(newId);
		
		return userdao.findById(newId);

	}

	/**
     * Finds a user by their email.
     *
     * @param email The email of the user to be retrieved.
     * @return The found user.
     * @throws ValidationException If validation of the email fails.
     */
	public User findByEmail(String Email) throws ValidationException {
		
		UserValidator.emailValidate(Email);

		return userdao.findByEmail(Email);

	}
	
	 /**
     * Finds a user by their mobile number.
     *
     * @param mobileNumber The mobile number of the user to be retrieved.
     * @return The found user.
     * @throws ValidationException If validation of the mobile number fails.
     */
	public User findByMobileNo(long mobileNumber) throws ValidationException {
		UserValidator.mobileNoValidate(mobileNumber);

		return userdao.findByMobileNo(mobileNumber);

	}

	 /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
     */
	public List<User> getAll() {

		return userdao.findAll();

	}
	
	
}
