package in.fssa.aviease.service;

import java.util.List;
import in.fssa.aviease.dao.UserDAO;
import in.fssa.aviease.exception.PersistenceException;
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
	public void createUser(User user) throws ServiceException ,ValidationException {

		try {
			UserValidator.validateUser(user);
			UserValidator.emailValidate(user.getEmail());
			UserValidator.mobileNoValidate(user.getMobileNo());
			UserValidator.checkNotExistMobileNo(user.getMobileNo());
			UserValidator.checkNotExistEmail(user.getEmail());
			UserValidator.passwordValidate(user.getPassword());
			userDAO.create(user);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		

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
			userDAO.update(newId, newUser);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		

		

	}
	
	 /**
     * Counts the total number of users.
     *
     * @return The total number of users.
	 * @throws ServiceException 
     */
	public int count() throws ServiceException {
		try {
			return userDAO.count();
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	


    /**
     * Finds a user by their ID.
     *
     * @param i The ID of the user to be retrieved.
     * @return The found user.
     * @throws ServiceException 
     * @throws ValidationException If validation of the ID fails.
     */
	public User findUserById(int id) throws ServiceException ,ValidationException{
		
		try {
			
			UserValidator.idValidate(id);
			UserValidator.checkExistid(id);

			return userDAO.findById(id);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}
		
		

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
			return userDAO.findByEmail(Email);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}

	

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
			return userDAO.findByMobileNo(mobileNumber);
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		
		}

		

	}

	 /**
     * Retrieves a list of all users.
     *
     * @return A list of all users.
	 * @throws ServiceException 
     */
	public List<User> getAllUser() throws ServiceException {

		try {
			return userDAO.findAll();
		} catch (PersistenceException e) {
			throw new ServiceException(e.getMessage());
		}

	}
	
	
}
