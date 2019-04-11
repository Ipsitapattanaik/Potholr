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
	public void savePothole(int street_Number, String street_Name, String city, String state, int zip_Code, String country, Long lat, Long lng) {
		String sqlInsertStatement = "INSERT INTO app_user (street_number, street_name, city, state, zip_code, country, lat, lng) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		jdbcTemplate.update(sqlInsertStatement, street_Number, street_Name, city, state, zip_Code, country, lat, lng);
	}


	@Override
	public void reportPothole(Pothole newPothole) {
		String sqlUpdate = "INSERT INTO pothole (pothole_Id, street_Name, lat, lng) " + " VALUES (?,?,?,?) ";

		jdbcTemplate.update(sqlUpdate, getNextPotholeId(), newPothole.getStreet_Name(), newPothole.getLat(),
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
		String sqlUpdatePothole = "UPDATE pothole " + "SET status_Code = ?, status_Date = ?, severity = ? "
				+ "WHERE pothole_Id = ? ";
		jdbcTemplate.update(sqlUpdatePothole, status_Code, status_Date, severity, pothole_Id);

	}

	@Override
	public void deletePotholeById(Long pothole_Id) {
		String sqlDeletePothole = "DELETE FROM pothole WHERE pothole_Id = ?";
		jdbcTemplate.update(sqlDeletePothole, pothole_Id);
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
		thePothole.setPothole_Id(results.getLong("pothole_Id"));
		thePothole.setStreet_Name(results.getString("street_Name"));
		thePothole.setState(results.getString("state"));
		thePothole.setCity(results.getString("city"));
		thePothole.setCountry(results.getString("country"));
		thePothole.setStatus_Date(results.getDate("status_Date"));
		thePothole.setStatus_Code(results.getInt("status_Code"));
		thePothole.setLat(results.getLong("lat"));
		thePothole.setLng(results.getLong("lng"));
		thePothole.setSeverity(results.getInt("severity"));
		thePothole.setReport_Date(results.getDate("report_Date"));
		thePothole.setImg_Url(results.getString("img_Url"));
		thePothole.setStreet_Number(results.getInt("street_Number"));
		thePothole.setZip_Code(results.getInt("zip_Code"));
		thePothole.setReport_User(results.getString("report_User"));

		return thePothole;
	}

}
