package model.data.db;

import model.data.users.User;

public interface UsersStorageInterface {
	/*
	 * Save user to database
	 * returns true if succeed / or false if failed
	 */
	public boolean saveUser(User user);
	
	/*
	 * retrieve user from database
	 */
	public User loadUser(int id);
	
	
	public int isValidUser(User user);
	
	
	public void changePassword(int id, String pass);
	
}
