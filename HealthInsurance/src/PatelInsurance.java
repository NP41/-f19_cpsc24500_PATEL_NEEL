// Neel Patel 

/** This program will create a tool that a health insurance company could use to determine the risk associated with insuring a new customer. 
 * The amount of risk will be determined by the body-mass index, blood pressure, age, and family history of disease.
 * @author NP
 *
 */

import java.util.ArrayList;
import java.util.Scanner;


public class PatelInsurance {
/*
 * Welcome function will print the greeting message to the screen.
 */
public static void welcome() {
	System.out.println("****************************************");
	System.out.println("         INSURANCE SCORE CARD\n");
	System.out.println("This app scores a potential customer");
	System.out.println("on various health attributes: blood");
	System.out.println("pressure, age, height, weight, and");
	System.out.println("family history of disease. It writes");
	System.out.println("each member's insurance grade to a");
	System.out.println("JSON file so that they can be easily");
	System.out.println("shared on a web-based data exchange.");
	System.out.println("****************************************");
}
/*
 * This Show Menu function will print list of options that user can choose from.
 */
public static void showMenu() {
	System.out.println("Here are your choices:");
	System.out.println("  1. List members");
	System.out.println("  2. Add a new member");
	System.out.println("  3. Save members");
	System.out.println("  4. Load members");
	System.out.println("  5. Assess members");
	System.out.println("  6. Save assessments as JSON");
	System.out.println("  7. Exit");
	System.out.print("Please enter your choice: ");
}
/*
 * 	This addMember function will allow the user to enter a new member.
 */
public static void addMember(ArrayList<Health> memberData) {
	
	// get inputs from user for each field:
	// i.e first name, last name, age, weight, height, bpSys,bpDias,cancer, diabetes, alzheimers;
	Scanner sc = new Scanner(System.in);
	String fname,lname,age,weight,height,bpSys,bpDias,cancer, diabetes, alzheimers;
	
	Health hlt;
// getting user unputs for various data for member
	System.out.print("Enter firstname:");
	fname = sc.nextLine();
	
	System.out.print("Enter lastname:");
	lname = sc.nextLine();
	
	System.out.print("Enter age:");
	age= sc.nextLine();
	
	System.out.print("Enter height in inches:");
	height = sc.nextLine();
	
	System.out.print("Enter weight in pounds:");
	weight = sc.nextLine();
	
	System.out.print("Enter Blood Pressure (Sys and Dias):");
	bpSys= sc.nextLine();
	String [] lineparts = bpSys.split(" ");
	bpSys = lineparts[0];
	bpDias= lineparts[1];
	
	System.out.println("\nHas a family member had....");
    System.out.print("Cancer (y or n):");
    cancer = sc.nextLine();
    
    System.out.print("Diabetes (y or n):");
    diabetes = sc.nextLine();
    
    System.out.print("Alzheimers (y or n):");
    alzheimers = sc.nextLine();
	
	// add the health to the array of memory 
	hlt = new Health(fname,lname,age,height, weight,bpSys, bpDias, cancer, diabetes, alzheimers );
	memberData.add(hlt);
	
	System.out.println("\nNew member has been added.");
}
/*
 * This risk Assessor function will assess the riskLevel and provide the verdict based on assigned penalty points
 */

/*
 * Begin Main function ...
 */
public static void main (String[] args) {
	String fname;
	int choice;
	String type;
	
	Scanner sc = new Scanner(System.in);
	welcome();  // call welcome function to greet user
	
	System.out.print("Enter name of the member file: ");   // ask user for filename to read from
	fname = sc.next();
	ArrayList<Health> memberData = MemberReader.insuranceFileReader(fname);  // call the insurance file reader to read data from file
	
	if (memberData==null)  // If file is not read, print following message and quit
	{
		System.out.println("ooooooops! I was not able to read the file correcly!");
	}
	
	else {
		
		
		do {
			
	showMenu(); // call showMenu function to print option for user to select from
	choice = sc.nextInt();

/*
 * If chooses option 1, print the members from input file to screen in a formated way.
 */
	if (choice==1) 
	{
	
	MemberWriter.printMembers(memberData); // call the printMembers function to print member data on screen
	}
/*
 * 	If user chooses option 2, allow the user to enter a new member into ArrayList.
 */
	else if (choice ==2 ) 
	{
		addMember(memberData); // call the addMember function
	}
	/*
	 * If user chooses option 3, this will allow them to store the data from the ArrayList into Text, Binary or XML file format.	
	 */
		else if (choice==3)
		{
			System.out.print("(T)ext, (B)inary, or (X)ML? ");
			type = sc.next();
	// If user chooses option T, Ask for output file name and create the file in Text Format.		
			if (type.equals("T") || type.equals("t")) 
			{
				System.out.print("Enter name of the output file: ");
				fname = sc.next();
	// 
				if (MemberWriter.saveMembertoText(fname, memberData)) 
				{
					System.out.println("Members were written successfully!");
				}
				else 
					System.out.println("failure!");
			}
	// If user chooses option B, Ask for output file name and create the file in Binary Format.		
			else if (type.contentEquals("B") || type.contentEquals("b"))
			{
				System.out.print("Enter name of the output file: ");
				fname = sc.next();
	// If files are written successfully, let the user know of success else it will print failure
				if (MemberWriter.saveMembertoBinary(fname, memberData))
				{
					System.out.println("Members were written successfully!");
				}
				else 
					System.out.println("failure!");
			}
	// If user chooses option X, Ask for output file name and create the file in xml Format.
			else if (type.contentEquals("X") || type.contentEquals("x"))
			{
				System.out.print("Enter the name of output file: ");
				fname = sc.next();
	// If files are written successfully, let the user know of success else it will print failure		
				if (MemberWriter.saveStudentsToXML(fname, memberData)) {
					System.out.println("Members were written successfully!");
				}
				else 
				{
					System.out.println("failure!");
				}
			}	
		}
	/*
	 * If user chooses option 4, following else if function will allow them to enter input file name and read number of member in that file	
	 */
		else if (choice==4) 
		{
		
		}
		
		else if (choice==5) 
		{
			
		}
			
		
		else if (choice==6) 
		{
			
		}
		
		} 
			while(choice!= 7 ); // if user chooses option 7, print good bye message and quit.
		{
			System.out.println("*********************************************");
			System.out.println("           INSURANCE SCORE CARD");
			System.out.println("                THANK YOU");
			System.out.println("*********************************************");
			System.out.println("Thank you for using this tool! I hope it was helpful.");
			System.out.println("Please feel free to suggest any feedback.");
		}
		
	}
	}
	}