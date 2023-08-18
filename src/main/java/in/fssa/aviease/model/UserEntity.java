package in.fssa.aviease.model;

public abstract class UserEntity implements Comparable<UserEntity> {

	private String firstname;
	private String lastname;
	private long mobileNo;
	private String email;
	private String password;
	private int id;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserEntity [firstname=" + firstname + ", lastname=" + lastname + ", mobileNo=" + mobileNo + ", email="
				+ email + ", password=" + password + ", id=" + id + "]";
	}

	
	public int compareTo(UserEntity o) {
		if (this.getId() == o.getId()) {
			return 0;
		} else {
			if (this.getId() < (o.getId())) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public String fullName() {
		return firstname.concat(" ").concat(lastname);
	}
}
