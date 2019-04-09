package com.techelevator.model;

import java.util.List;

public interface PotholeDAO {
	
	public List <Pothole> getListOfPotholeById(Long Id);
	
	//public void reportPothole(new pothole);
	
	public Pothole getPotholeById(Long Id);

	public void updatePotholeById(Long Id);

	public void deletePotholeById(Long Id);

	
	
	

}
