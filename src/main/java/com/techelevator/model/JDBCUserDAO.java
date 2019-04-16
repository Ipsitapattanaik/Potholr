package com.techelevator.model;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.User;
import com.techelevator.security.PasswordHasher;

@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate jdbcTemplate;
	private PasswordHasher hashMaster;

	@Autowired
	public JDBCUserDAO(DataSource dataSource, PasswordHasher hashMaster) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.hashMaster = hashMaster;
	}
	
	@Override
	public void saveUser(String userName, String email, String phoneNumber, String password, boolean isEmployee) {
//		byte[] salt = hashMaster.generateRandomSalt();
//		String hashedPassword = hashMaster.computeHash(password, salt);
//		String saltString = new String(Base64.encode(salt));
//		
//		jdbcTemplate.update("INSERT INTO app_user(user_name, password, salt) VALUES (?, ?, ?)",
//				userName, hashedPassword, saltString);
		String sqlGetNextId = "SELECT nextval('app_user_user_id_seq')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetNextId);
		results.next();
		int id = results.getInt(1);
		System.out.println("Next id is " + id);
		String sqlInsertStatement = "INSERT INTO app_user (user_id, user_name, email, phone, password, is_employee) VALUES (?, ?, ?, ?, ?, ?);";
		jdbcTemplate.update(sqlInsertStatement, id, userName, email, phoneNumber, password, isEmployee);
		
	}

	@Override
	public User searchForUsernameAndPassword(String userName, String password) {
		String sqlSearchForUser = "SELECT * "+
							      "FROM app_user "+
							      "WHERE user_name = ? ";
		
		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUser, userName);
//		if(user.next()) {
//			String dbSalt = user.getString("salt");
//			String dbHashedPassword = user.getString("password");
//			String givenPassword = hashMaster.computeHash(password, Base64.decode(dbSalt));
//			return dbHashedPassword.equals(givenPassword);
//		} else {
//			return false;
//		}
//		if(user.next()) {
//			return true;
//		} else {
//			return false;
//		}
	
		
		User thisUser = new User();
		if(user.next()) {
			thisUser.setUserId(user.getLong("user_id"));
			thisUser.setUserName(user.getString("user_name"));
			thisUser.setPassword(user.getString("password"));
			thisUser.setEmail(user.getString("email"));
			thisUser.setPhone(user.getString("phone"));
			thisUser.setEmployee(user.getBoolean("is_employee"));
			}

		return thisUser;

	}

	
	@Override
	public User searchForUserByUserId(Long userId) {
		String sqlSearchForUser = "SELECT * "+
							      "FROM app_user "+
							      "WHERE user_id = ? ";
		
		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUser, userId);
	
		User thisUser = new User();
		if(user.next()) {
			thisUser.setUserId(user.getLong("user_id"));
			thisUser.setUserName(user.getString("user_name"));
			thisUser.setPassword(user.getString("password"));
			thisUser.setEmail(user.getString("email"));
			thisUser.setPhone(user.getString("phone"));
			thisUser.setEmployee(user.getBoolean("is_employee"));
			}

		return thisUser;

	}

	
	@Override
	public void updatePassword(String userName, String password) {
		jdbcTemplate.update("UPDATE app_user SET password = ? WHERE user_name = ?", password, userName);
	}

	@Override
	public Object getUserByUserName(String userName) {
		String sqlSearchForUsername ="SELECT * "+
		"FROM app_user "+
		"WHERE UPPER(user_name) = ? ";

		SqlRowSet user = jdbcTemplate.queryForRowSet(sqlSearchForUsername, userName.toUpperCase()); 
		User thisUser = null;
		if(user.next()) {
			thisUser = new User();
			thisUser.setUserName(user.getString("user_name"));
			thisUser.setPassword(user.getString("password"));
			thisUser.setEmail(user.getString("email"));
			thisUser.setPhone(user.getString("phone"));
			}

		return thisUser;
	}

	//@Override
	public boolean seeIfUserIsEmployee(String userName) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
