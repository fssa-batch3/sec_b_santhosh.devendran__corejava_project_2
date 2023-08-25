package in.fssa.aviease.interfaces;

import in.fssa.aviease.model.User;

public interface UserInterface  extends Base<User>{
	
	public abstract User findByEmail(String email);
	
	public abstract User findByMobileNo(long mobileNo);
		
	public abstract int count();

}
