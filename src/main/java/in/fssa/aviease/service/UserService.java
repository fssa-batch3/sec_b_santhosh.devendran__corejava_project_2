package in.fssa.aviease.service;

import java.util.List;

import in.fssa.aviease.dao.UserDAO;
import in.fssa.aviease.exception.ValidationException;
import in.fssa.aviease.model.User;
import in.fssa.aviease.validator.UserValidator;

public class UserService {
	
	
	UserDAO userdao = new UserDAO();
	public void create(User user) throws Exception {

		UserValidator.validate(user);
		UserValidator.emailValidate(user.getEmail());
		UserValidator.mobileNoValidate(user.getMobileNo());
		UserValidator.checkNotExistMobileNo(user.getMobileNo());
		UserValidator.checkNotExistEmail(user.getEmail());
		UserValidator.passwordValidate(user.getPassword());
		userdao.create(user);

	}
	
	public void update(int newId, User newUser) throws ValidationException {
		
		UserValidator.idValidate(newId);
		UserValidator.checkExistid(newId);
		UserValidator.stringValidate(newUser.getFirstname(), "Firstname");
		UserValidator.stringValidate(newUser.getLastname(), "Lastname");
		

		userdao.update(newId, newUser);

	}
	
	public int count() {
		return userdao.count();

	}
	

	public User findById(int newId) throws ValidationException {
		
		UserValidator.idValidate(newId);
		
		return userdao.findById(newId);

	}

	public User findByEmail(String Email) throws ValidationException {
		
		UserValidator.emailValidate(Email);

		return userdao.findByEmail(Email);

	}
	
	public User findByMobileNo(long mobileNumber) throws ValidationException {
		UserValidator.mobileNoValidate(mobileNumber);

		return userdao.findByMobileNo(mobileNumber);

	}

	public List<User> getAll() {

		return userdao.findAll();

	}
	
	
}
