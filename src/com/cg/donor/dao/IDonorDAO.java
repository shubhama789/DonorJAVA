package com.cg.donor.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;

public interface IDonorDAO {


	public String addDonor(DonorBean donor) throws DonorException, ClassNotFoundException, IOException, SQLException;
	public DonorBean viewDonorDetails(String donorID)throws DonorException, ClassNotFoundException, IOException, SQLException;
	public List retrieveAll()throws DonorException;
	
	
}
