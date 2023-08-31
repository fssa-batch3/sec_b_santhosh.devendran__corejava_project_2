package in.fssa.aviease.interfaces;

import in.fssa.aviease.exception.PersistenceException;
import in.fssa.aviease.model.User;

public interface UserInterface  extends Base<User>{
	
	public abstract User findByEmail(String email) throws PersistenceException;
	
	public abstract User findByMobileNo(long mobileNo) throws PersistenceException;
		
	public abstract int count() throws PersistenceException;

}
