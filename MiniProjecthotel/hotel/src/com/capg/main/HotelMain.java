package com.capg.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.capg.dao.AdminDAO;
import com.capg.dao.AdminDAOImpl;
import com.capg.dao.UserDAO;
import com.capg.dao.UserDAOImpl;
import com.capg.exception.HotelException;
import com.cg.project.dto.ProgramsOffered;
import com.cg.project.dto.ProgramsScheduled;



public class HotelMain {
	public static void main(String[] args)throws HotelException
	{
		Scanner sc = new Scanner(System.in);
	
	  while(true)
	  {
		  
		    System.out.println("Hotel Bookings Management System\n");
		    System.out.println("________________________________\n");
			System.out.println("1. Login (User/Admin)\n");
			System.out.println("2. Perform Operations\n");
			System.out.println("3. Book Roooms\n");
			System.out.println("4. Exit\n");
			System.out.println("Enter your choice:\n");
			AdminDAO admindao = new AdminDAOImpl();
	        UserDAO userdao = new UserDAOImpl();
			int choice = sc.nextInt();
			if(choice!=4){
			switch(choice)
			{
			
		   
		    case 1:  
		    	    System.out.println("Login ID: \n");
			        String user_id = sc.next(); 
			        
			        System.out.println("Password: \n");
			        String password = sc.next();
			        String role = admindao.userVerification(user_id, password);
			        if(role.equals("User"))
			        {   
			        	System.out.println("\n-----------User Portal------------");
			        	System.out.println("\n 1.View List of Hotels \n 2.Book Rooms\n 3.logout");
			            System.out.println("\n Enter Choice: \n");
			            
			            int opt= sc.nextInt();
			            switch(opt){
			           case 1: System.out.println("\n List of Hotels ");
			                   System.out.println("\n +hotel.hotel_id"+"+hotel.hotel_name");              
			                   break;
			            case 2: System.out.println("\n enter hotel Id to book rooms:");
			                    String hotel_id= sc.next();
			                    userdao.bookRooms(hotel_id);
			                    break;
			            case 3: break;
			            default: System.out.println("\n invalid option");
			                     
			            }
		    		  
		    		  
			        }else if(role.equals("ADMIN"))
			        {
			        	System.out.println("\n------------ADMIN Portal--------------");
			        	System.out.println("\n 1.Create Program\n 2.Update Program\n 3.Delete Program");
			        	System.out.println("\n 4.View Applicants For a ScheduledProgram and Status \n 5.Logout");
			        	int opt2= sc.nextInt();
			        	switch(opt2){
			        	case 1: System.out.println("\n ProgramName: ");
			        	        String progname=sc.next();
			        	        System.out.println("\n Description: ");
			        	        String description= sc.nextLine();
			        	        System.out.println("\n ApplicantEligibility: ");
			        	        String applEligibility= sc.nextLine();
			        	        System.out.println("\n Duration of Program: ");
			        	        int duration = sc.nextInt();
			        	        System.out.println("\n Certificate Offered: ");
			        	        String certificate=sc.next();
			        	        
			        	        ProgramsOffered progoff= new ProgramsOffered();
			        	        
			        	        progoff.setProgramName(progname);
			        	        progoff.setDescription(description);
			        	        progoff.setApplicant_eligibility(applEligibility);
			        	        progoff.setProgram_duration(duration);
			        	        progoff.setDegree_certificate_offered(certificate);
			        	        
			        	        System.out.println("\n ProgramId: ");
			        	        String progid= sc.next();
			        	        //System.out.println("\n Start Date: ");
			        	        //System.out.println("\n ENd Date: ");
			        	        System.out.println("\n Program Location: ");
			        	        String location= sc.next();
			        	        System.out.println("\n Sessions per week: ");
			        	        int spw= sc.nextInt();
			        	        ProgramsScheduled progsch= new ProgramsScheduled();
			        	        progsch.setScheduledprogramid(progid);
			        	        progsch.setProgram_location(location);
			        	        progsch.setSessions_per_week(spw);
			        	        admindao.createprogram(progoff, progsch);
			        	        break;
			        	case 2:  System.out.println("\n enter Programname to update: ");
	        	        		 String name= sc.next();
	        	        		int count = admindao.countapplicants(name);
	 		        	        if(count==0){
	 		        	        //System.out.println("\n Start Date: ");
	 		        	        //System.out.println("\n ENd Date: ");
	 		        	        System.out.println("\n Program Location: ");
	 		        	        String plocation= sc.next();
	 		        	        System.out.println("\n Sessions per week: ");
	 		        	        int sessionspw= sc.nextInt();
	 		        	       // admindao.updateprogram(name, startdate, enddate, sessionspw, plocation);
			        	         }else System.out.println("\n Can't be updated");
	 		        	        break; 
			        	case 3:  System.out.println("\n enter Programname to delete: ");
		        		         String name1= sc.next();
		        		         int count1 = admindao.countapplicants(name1);
	        	                 if(count1==0){
	        	        		 admindao.deleteprogram(name1);
			        	         }else System.out.println("\n Can't be deleted");
	        	                 break;
			        	case 4: System.out.println("\n Enter ProgramId view: ");
			        	        String programid=sc.next();
			        	        System.out.println("\n Enter Status: ");
			        	        String status= sc.next();
			        	        admindao.finallist(programid, status);
			        	        break;
			        	case 5: break;
			        	default: System.out.println("\n invalid choice");
			        }
			      
			       
			   }
			    break;
			    
			case 2: admindao.retrieveprograms();
			        break;
			case 3: System.out.println("\n Enter Details: ");
			        System.out.println("\n FullName: ");
			        String fullname= sc.nextLine();
			        //System.out.println("\n Enter DateOf Birth: ");
			        System.out.println("\n Highest Qualification: ");
			        String qualification= sc.next();
			        System.out.println("\n Goals: ");
			        String goals= sc.nextLine();
			        System.out.println("\n marks obtained: ");
			        int marks= sc.nextInt();
			        System.out.println("\n Email: ");
			        String email= sc.next();
			        System.out.println("\n ProgramId to Apply: ");
			        String programid= sc.next();
			        String status= "Applied";
			        String DOI="NA";
			        //Applicant appl= new Applicant(fullname, dob, qualification, marks, goals, email, programid,status,DOI);
			      //  macdao.createapplicant(appl);
			        break;
			case 4: System.out.println("\n Enter ApplicantId: ");
			        int appid= sc.nextInt();
			        macdao.applicationstatus(appid);
			        break;
			 default: System.out.println("\n Invalid Choice");
			}}else break;
			
		 }
		}
		
	}

		    		  
		    		
			}
			
			}
}
			
	  
	  }
	
	
}	
	
	
	




