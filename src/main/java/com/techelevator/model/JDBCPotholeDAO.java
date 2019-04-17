package com.techelevator.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCPotholeDAO implements PotholeDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired // connecting to DB
	public JDBCPotholeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Pothole> getListOfAllPotholes() {
	String sqlStatement = "SELECT * FROM pothole";
	List<Pothole> listOfPotholes = new ArrayList<Pothole>();
	SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement);
	while(results.next()) {
	listOfPotholes.add(mapRowToPothole(results));
	}
	return listOfPotholes;
	}
	
	@Override
	public String getArrayOfPothole(List<Pothole> listOfPotholes) {
	String addToArrayString = "";
	for (Pothole pothole: listOfPotholes) {
	String picturePathString = pothole.getImgUrl();
	if(picturePathString == null) {
	picturePathString = "/capstone/img/potholeWarning.png";
	}
	addToArrayString += "{ position: new google.maps.LatLng(" + getLatitude(pothole.getLat()) +
	"," + getLongitude(pothole.getLng()) + "), type: '" + pothole.getStatusCode() + "', "
	+ "picture: '" + picturePathString + "', address: ' "
	+ pothole.getStreetNumber() + " " + pothole.getStreetName() + "', id: "+
	pothole.getPotholeId()+ ", severity: "+
	pothole.getSeverity() + "},";
	}
	addToArrayString = "[" + addToArrayString.substring(0, addToArrayString.length()-1) + "]";
	return addToArrayString;
	}

	private Float getLatitude(String lat) {
	    return Float.valueOf(lat.trim());
	// return Long.parseLong(lat.trim());
	}

	private Float getLongitude(String longitude) {
	    return Float.valueOf(longitude.trim());
	}

	@Override
	public List<Pothole> getListOfPotholes(String orderBy) {
	List<Pothole> potholeList = new ArrayList<Pothole>();
	//avoid sql injection attack
	String sqlGetAllPotholes = "";
	if (orderBy.equals("severity") || orderBy.equals("report_Date") || orderBy.equals("status_Code")) {
	sqlGetAllPotholes = "SELECT * FROM pothole ORDER BY " + orderBy + " DESC";
	} else if (orderBy.equals("street_Name")) {
	sqlGetAllPotholes = "SELECT * FROM pothole ORDER BY " + orderBy;
	}

	    Pothole thePothole;
	    SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllPotholes);
	    while (results.next()) {
	        thePothole = mapRowToPothole(results);
	        potholeList.add(thePothole);
	    }
	    return potholeList;
	}	
	
	@Override
	public void reportPothole(Pothole newPothole) {
		String sqlUpdate = "INSERT INTO pothole (pothole_Id, street_Name, lat, lng) " + " VALUES (?,?,?,?) ";

		jdbcTemplate.update(sqlUpdate, getNextPotholeId(), newPothole.getStreetName(), newPothole.getLat(),
				newPothole.getLng());
	}


	@Override
	public Pothole getPotholeById(Long pothole_Id) {
		String sqlGetUserPothole = "SELECT * FROM pothole WHERE pothole_Id = ?";
		Pothole thePothole = new Pothole();

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetUserPothole, pothole_Id);
		while (results.next()) {
			thePothole = mapRowToPothole(results);
		}
		return thePothole;
	}

	@Override
	public void updatePotholeById(String status_Code, LocalDate status_Date, int severity, Long pothole_Id) {
		String sqlUpdatePothole = "UPDATE pothole " + "SET status_code = ?, status_date = ?, severity = ? "
				+ "WHERE pothole_id = " + pothole_Id;
		jdbcTemplate.update(sqlUpdatePothole, status_Code, status_Date, severity);
	
	}

	@Override
	public void deletePotholeById(Long pothole_Id) {
		String sqlDeletePothole = "DELETE FROM pothole WHERE pothole_Id = ?";
		jdbcTemplate.update(sqlDeletePothole, pothole_Id);
	}
	
	
	

	@Override
	public List<Pothole> getListOfPotholesByUserId(Long user_Id) {
		String sqlStatement = "SELECT * FROM pothole WHERE user_id = ?";
		List<Pothole> listOfPotholes = new ArrayList<Pothole>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlStatement, user_Id);
		while(results.next()) {
			listOfPotholes.add(mapRowToPothole(results));
		}
		return listOfPotholes;
	}
	

	@Override
	public void savePothole(long userId, int street_Number, String street_Name, String city, String state, int zip_Code, String country, String lat, String lng, int severity) {
	String sqlInsertStatement = "INSERT INTO pothole (user_id, street_number, street_Name, city, state, zip_code, country, lat, lng, severity) "
	+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	jdbcTemplate.update(sqlInsertStatement, userId, street_Number, street_Name, city, state, zip_Code, country, lat, lng, severity);
	}
	
	
	public long getNextPotholeId() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('pothole_pothole_Id_seq')");
		if (nextIdResult.next()) {
			return nextIdResult.getLong(1);
		} else {
			throw new RuntimeException("Something went wrong with the pothole sequence");
		}
	}

	private Pothole mapRowToPothole(SqlRowSet results) {
		Pothole thePothole = new Pothole();
		thePothole.setPotholeId(results.getLong("pothole_id"));
		thePothole.setStreetName(results.getString("street_name"));
		thePothole.setState(results.getString("state"));
		thePothole.setCity(results.getString("city"));
		thePothole.setCountry(results.getString("country"));
		thePothole.setStatusDate(results.getDate("status_date"));
		thePothole.setStatusCode(results.getString("status_code"));
		thePothole.setLat(results.getString("lat"));
		thePothole.setLng(results.getString("lng"));
		thePothole.setSeverity(results.getInt("severity"));
		thePothole.setReportDate(results.getDate("report_date"));
		thePothole.setImgUrl(results.getString("img_url"));
		thePothole.setStreetNumber(results.getInt("street_number"));
		thePothole.setZipCode(results.getInt("zip_code"));
		thePothole.setUserId(results.getLong("user_id"));

		    return thePothole;
		}

}
