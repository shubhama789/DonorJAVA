package com.cg.donor.pl;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.donor.bean.DonorBean;
import com.cg.donor.exception.DonorException;
import com.cg.donor.service.DonorServiceImpl;
import com.cg.donor.service.IDonorService;

public class DonorMain {
	
	
	static Scanner sc = new Scanner(System.in);
	static IDonorService donorService = null;
	static DonorServiceImpl donorServiceImpl =null;
	
	public static void main(String[] args) {
		
		
		DonorBean donorBean = null;
		
		String donorId = null;
		int option=0;
		
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println("  ICARE CAPGEMINI TRUST ");
			System.out.println("_____________________________________");
			
			System.out.println("1. Add Donator ");
			System.out.println("2. View Donator");
			System.out.println("3. Retrieve All");
			System.out.println("4. Exit");
			System.out.println("__________________________________________________");
			System.out.println("Select an Option");
		
			
			try 
			{
				option = sc.nextInt();
				switch (option) {
				case 1:
					while(donorBean==null) {
						donorBean = populateDonorBean();
					}
					try
					{
						donorService = new DonorServiceImpl();
						donorId = donorService.addDonor(donorBean);
						
						System.out.println("Donator details has been successfully registered");
						System.out.println("donator Id is : "+donorId);
						donorBean.setDonorId(donorId);// this is done by me 
						
					}
					catch(DonorException donorException) {
						System.err.println("ERROR: "+donorException.getMessage());
					}
					finally {
						donorId=null;
						donorBean=null;
						donorService=null;
					}
					break;

				case 2:
					
						System.out.println("Enter the donorId to search details: ");
						donorId = sc.next();
						donorServiceImpl = new DonorServiceImpl(); 
						donorService = new DonorServiceImpl();
						
						
						
							if(donorServiceImpl.validateDonorId(donorId)) {
								System.out.println(donorService.viewDonorDetails(donorId));
							}
							
							
						
						
					
					
					
					break;
					
				case 3:
					
					break;
					
				case 4:
					
					break;
					
				default:
					
					break;
				}
				
				
				
				
			}
			catch (Exception e) 
			{
				// TODO: handle exception
			}
		}
		
		
	}

	private static DonorBean populateDonorBean() {
		// TODO Auto-generated method stub
		
		DonorBean donorBean = new DonorBean();
		System.out.println("\n Enter Details");
		
		System.out.println("Enter donor name: ");
		donorBean.setDonorName(sc.next());
		
		System.out.println("Enter donor contact: ");
		donorBean.setPhoneNumber(sc.next());
		
		System.out.println("Enter donor address");
		donorBean.setAddress(sc.next());
		
		System.out.println("Enter donation amount: ");
		try {
			donorBean.setDonationAmount(sc.nextFloat());
		}
		catch (InputMismatchException ime) {
			// TODO: handle exception
			sc.nextLine();
			System.out.println("Please enter a numeric value for donation amount, try again ");
		}
		donorServiceImpl = new DonorServiceImpl(); 
		try 
		{
			donorServiceImpl.ValidateDonor(donorBean);
			return donorBean;
			
		}
		catch (DonorException donorException) {
			System.err.println("invalid data");
			System.err.println(donorException.getMessage()+"\n Try again..");
			System.exit(0);
		}
		return null;
	}
	
	
	
}
