package com.techelevator.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCPotholeDAO implements PotholeDAO{
	
private JdbcTemplate jdbcTemplate;
	
	@Autowired  //connecting to DB
	public JDBCPotholeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Pothole> getListOfPotholeById(Long pothole_Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pothole getPotholeById(Long pothole_Id) {
		Pothole pothole = null;
		String sqlSelectionPotholeId = "SELECT * FROM pothole WHERE pothole_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectionPotholeId, pothole_Id);
		if (results.next()) {
			pothole = mapRowToPothole(results);
		}
		return pothole;
		
	}

	@Override
	public void updatePotholeById(Long pothole_Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePotholeById(Long pothole_Id) {
		// TODO Auto-generated method stub
		
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
