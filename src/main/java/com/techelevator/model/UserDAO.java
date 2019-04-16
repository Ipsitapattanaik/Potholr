package com.techelevator.model;

public interface UserDAO {

	public void saveUser(String userName, String email, String phoneNumber, String password, boolean isEmployee);

	public User searchForUsernameAndPassword(String userName, String password);

	public void updatePassword(String userName, String password);

	public Object getUserByUserName(String userName);
	
	public boolean seeIfUserIsEmployee(String userName);

	User searchForUserByUserId(Long userId);

}
