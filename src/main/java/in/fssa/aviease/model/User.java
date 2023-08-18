package in.fssa.aviease.model;

public class User extends UserEntity {

	
	public User(String firstname,String lastname,long mobileNo,String email,String password,int id) {
		
		super.setFirstname(firstname);
		super.setLastname(lastname);
		super.setMobileNo(mobileNo);
		super.setEmail(email);
		super.setPassword(password);
		super.setId(id);
		
	}
	
	public User(){
		
	}
}
