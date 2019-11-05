// Neel Patel 

/** This program will create a tool that a health insurance company could use to determine the risk associated with insuring a new customer. 
 * The amount of risk will be determined by the body-mass index, blood pressure, age, and family history of disease.
 * @author NP
 *
 */

import java.util.ArrayList;
import java.util.Scanner;


public class PatelInsurance {
	
	
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

public static void printMembers(ArrayList<Health> memberData) {
		for (Health data: memberData) {
		
		System.out.println(data);
	}
}
	
public static void main (String[] args) {
	String fname;
	int choice;
	
	Scanner sc = new Scanner(System.in);
	welcome();
	
	System.out.print("Enter name of the member file: ");
	fname = sc.nextLine();
	ArrayList<Health> memberData = MemberReader.insuranceFileReader(fname);
	
	if (memberData==null) {
		System.out.println("ooooooops! The file was not read correctly!");
	}
	
	else {
		do {
	
	showMenu();
	choice = sc.nextInt();
	
	if (choice== 1) 
	{
	printMembers(memberData);
    }
	else if (choice == 2)
	{
		
	}
	else if (choice == 3)
	{
		
	}
	else if (choice == 4)
	{
		
	}
	else if (choice == 5)
	{
		
	}
	else if (choice == 6)
	{
		
	}
		} while (choice!=7);
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
