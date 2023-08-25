package in.fssa.aviease.service;

import java.util.List;


import in.fssa.aviease.dao.UserDAO;
import in.fssa.aviease.exception.ServiceException;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.validator.UserValidator;

public class UserService {
	
	
	UserDAO userDAO = new UserDAO();
	
	/**
     * Creates a new user with validated data.
     *
     * @param user The user object to be created.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the user data fails.
     */
	public void createuser(User user) throws ServiceException ,ValidationException {

		try {
			UserValidator.validate(user);
			UserValidator.emailValidate(user.getEmail());
			UserValidator.mobileNoValidate(user.getMobileNo());
			UserValidator.checkNotExistMobileNo(user.getMobileNo());
			UserValidator.checkNotExistEmail(user.getEmail());
			UserValidator.passwordValidate(user.getPassword());
		} catch (ValidationException e) {
			throw new ServiceException("create user failed");
		}
		
		userDAO.create(user);

	}
	
	
	 /**
     * Updates an existing user with validated data.
     *
     * @param newId The ID of the user to be updated.
     * @param newUser The updated user object.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the ID or user data fails.
     */
	public void updateUser(int newId, User newUser) throws ServiceException ,ValidationException{
		
		
		try {
			UserValidator.idValidate(newId);
			UserValidator.checkExistid(newId);
			UserValidator.stringValidate(newUser.getFirstname(), "Firstname");
			UserValidator.stringValidate(newUser.getLastname(), "Lastname");
		} catch (ValidationException e) {
			throw new ServiceException("update user filed");
		}
		
		

		userDAO.update(newId, newUser);

	}
	
	 /**
     * Counts the total number of users.
     *
     * @return The total number of users.
     */
	public int count() {
		return userDAO.count();

	}
	


    /**
     * Finds a user by their ID.
     *
     * @param newId The ID of the user to be retrieved.
     * @return The found user.
     * @throws ServiceException 
     * @throws ValidationException If validation of the ID fails.
     */
	public User findUserById(int newId) throws ServiceException ,ValidationException{
		
		try {
			UserValidator.idValidate(newId);
			UserValidator.checkExistid(newId);
		} catch (ValidationException e) {
			throw new ServiceException("user not found");
		}
		
		
		return userDAO.findById(newId);

	}

	/**
     * Finds a user by their email.
     *
     * @param email The email of the user to be retrieved.
     * @return The found user.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the email fails.
     */
	public User findUserByEmail(String Email) throws ServiceException ,ValidationException{
		
		try {
			UserValidator.emailValidate(Email);
		} catch (ValidationException e) {
			throw new ServiceException("user not found");
		}

		return userDAO.findByEmail(Email);

	}
	
	 /**
     * Finds a user by their mobile number.
     *
     * @param mobileNumber The mobile number of the user to be retrieved.
     * @return The found user.
	 * @throws ServiceException 
     * @throws ValidationException If validation of the mobile number fails.
     */
	public User findUserByMobileNo(long mobileNumber) throws ServiceException ,ValidationException
	{
		try {
			UserValidator.mobileNoValidate(mobileNumber);
		} catch (ValidationException e) {
			throw new ServiceException("user not found");
		}

		return userDAO.findByMobileNo(mobileNumber);

	}

	 /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
     */
	public List<User> getAllUser() {

		return userDAO.findAll();

	}
	
	
}
