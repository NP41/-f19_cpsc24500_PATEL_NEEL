/** This class file reads the initial tab-delimited file and stores it into an arrayList. 
 * It also include functions to read back the stored files from binary, xml and JSON format. 
 * @author NP
 *
 */
import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

// This suppress warning annotation will handle the unnecessary warnings for binary and xml file reader functions.
@SuppressWarnings("unchecked")
public class MemberReader {

/** This function will read the tab delimited test file and store into an ArrayList.
 * 
 * @param fname
 * @return
 */
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
			            String[] lineparts = line.split("\t"); // split the data with tab
			           
			           Health member = new Health( lineparts[0],lineparts[1],lineparts[2],lineparts[3],lineparts[4],lineparts[5],
			        		   lineparts[6],lineparts[7],lineparts[8], lineparts[9]);
			           
			           memberData.add(member); // data will be added to the ArrayList
			        } 
			        fsc.close(); // close the file scanner
			        return memberData; // close the file and return the the data 
			        
			        } catch (Exception ex) 
			    {
			        return null; 
			    }
		}
/**readDataFromBinary function will read back data from stored binary file, it will be used to count number of members read/stored from binary.
 *  
 * @param fname
 * @return
 */
		public static ArrayList<Health> readMemberDataFromBinary(String fname){
			try {
// Object input stream will be used to read the binary file			
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
				
				ArrayList <Health> result = (ArrayList<Health>)ois.readObject();
				ois.close();
				
				return result;
				
			}catch (Exception ex) {
				return null;
			}
		}
/**readMemberDataFromXml function will read back data from stored XML file, it will be used to count/read number of members from the file. 
 * 
 * @param fname
 * @return
 */

		public static ArrayList<Health> readMemberDataFromXml(String fname){
			try {
// XML decoder used to read the xml file into simple text
				XMLDecoder xml = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
				ArrayList <Health> result = (ArrayList<Health>)xml.readObject();
				xml.close();
				return result;
			} catch (Exception ex) {
				return null;
			}
		}
	}



