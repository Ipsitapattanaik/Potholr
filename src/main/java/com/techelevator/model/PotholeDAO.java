package com.techelevator.model;

import java.time.LocalDate;
import java.util.List;

public interface PotholeDAO {
	
	public List <Pothole> getListOfPotholes(String orderBy);
	
	public void reportPothole(Pothole newPothole);
	
	public Pothole getPotholeById(Long pothole_Id);

	public void updatePotholeById(String statusCode, LocalDate statusDate, int severity, Long pothole_Id);

	public void deletePotholeById(Long pothole_Id);

	public void savePothole(int street_Number, String street_Name, String city, String state, int zip_Code, String country, Long lat, Long lng);


}