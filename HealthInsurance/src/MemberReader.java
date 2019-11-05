/** This class file reads the initial tab-delimited file and stores it into an arrayList 
 * 
 * @author NP
 *
 */
    import java.io.File;
	import java.util.ArrayList;
	import java.util.Scanner;


public class MemberReader {
		
		public static ArrayList<Health> insuranceFileReader(String fname) 
		{
			
			 // try catch block to catch exception before crashing
			    try {  
			    	ArrayList<Health> memberData = new ArrayList<Health>(); // building the array list of strings
				    
			        Scanner fsc = new Scanner(new File(fname)); // read the file name 
			       
			        String line;
			        
			        while (fsc.hasNextLine())  // while there is next file, it will read it 
			        {
			            line = fsc.nextLine().trim(); // read and trim any unwanted spaces 
			            String[] lineparts = line.split("\t");
			           
			           Health member = new Health( lineparts[0],lineparts[1],lineparts[2],lineparts[3],lineparts[4],lineparts[5],lineparts[6],lineparts[7],
			            		lineparts[8], lineparts[9]);
			            memberData.add(member);
			            }
			            
			        fsc.close(); // close the file scanner
			        return memberData; // close the file and return the the data 
			        
			        } catch (Exception ex) 
			    {
			        return null; 
			    }
		}

	}



