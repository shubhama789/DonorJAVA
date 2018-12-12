package com.cg.donor.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.util.DBConnection;

public class DonorDaoImpl implements IDonorDAO{

	@Override
	public String addDonor(DonorBean donor) throws DonorException, ClassNotFoundException, IOException, SQLException {
		Connection connection = DBConnection.getConnection();	
		PreparedStatement preparedStatement = null;
		ResultSet resultset = null;
		
		String donorId = null;
		int queryResult=0;
		try {
			Statement st = connection.createStatement();
			preparedStatement = connection.prepareStatement("insert into donor_details values(donorid_sequence.nextval,?,?,?,SYSDATE,?)");
			
			
			preparedStatement.setString(1,donor.getDonorName());
			preparedStatement.setString(2,donor.getAddress());
			preparedStatement.setString(3,donor.getPhoneNumber());
			preparedStatement.setDouble(4,donor.getDonationAmount());
			
			
			
			preparedStatement.executeUpdate();
			
			
			
			
			
			resultset = st.executeQuery("select * from donor_details order by donor_id");
			
			while(resultset.next()) {
				
				System.out.println("DonorId : "+resultset.getString(1)+" Donor Name : "+resultset.getString(2)+" Donor Address :  "+resultset.getString(3)+" Donor PhoneNumber is : "+resultset.getString(4)+" Donation Date :"+resultset.getDate(5)+" Donor_Amount :"+resultset.getDouble(6));
				System.out.println();		
				donorId = resultset.getString(1);
			}
			
			
		//	return donorId;

			//return resultset.getString(1);
			
		} catch (Exception sqle) {
			
		}
		
		
		
		return donorId;
		
		
		
	}

	@Override
	public DonorBean viewDonorDetails(String donorID) throws DonorException, ClassNotFoundException, IOException, SQLException {
		Connection connection = DBConnection.getConnection();
		ResultSet resultset = null;
		DonorBean bean = new DonorBean();
		try {
		Statement st = connection.createStatement();
		resultset = st.executeQuery("select * from donor_details where donor_id='"+donorID+"'");
		
		while(resultset.next()) {
			bean.setDonorId(resultset.getString(1));
			bean.setDonorName(resultset.getString(2));
			bean.setAddress(resultset.getString(3));
			bean.setPhoneNumber(resultset.getString(4));
			bean.setDonationDate(resultset.getDate(5));
			bean.setDonationAmount(resultset.getDouble(6));
			
			
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return bean;
	}

	@Override
	public List retrieveAll() throws DonorException {
		// TODO Auto-generated method stub
		return null;
	}

}
