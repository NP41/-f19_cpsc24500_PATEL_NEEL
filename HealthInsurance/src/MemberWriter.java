/**This class will be useful for writing out data of members from ArrayList to different file formats, 
 * i.e. text, binary and XML.
 * @author NP
 */
// Required import packages
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
public class MemberWriter {
	
/** this function will print members from file to the screen with formatting.
 * 
 * @param memberData
 */
	public static void printMembers(ArrayList<Health> memberData) {
		for (Health h: memberData) {
		
		System.out.println(h);
	}
	}
/** This function will save member data from ArrayList to the text file in tab delimited file format.
 * 
 * @param fname
 * @param memberData
 * @return
 */
	public static boolean saveMembertoText(String fname, ArrayList<Health> memberData) 
	{
		
		    try 
				{
// PrintWriter used to stored data into text file with tab-delimited file format.
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(new File(fname))));
			
			for (Health m:memberData) // iterate through the ArrayList  
			{
				pw.println(m.getFname()+"\t"+ m.getLname()+"\t" + m.getAge()+ "\t"+ m.getHeight()+ "\t"+m.getWeight()+"\t" +m.getBpSystolic() +"\t"
				+ m.getBpDiastolic() + "\t"
				+ m.getCancer()+"\t" +m.getDiabetes() +"\t"+m.getAlzheimers());
			}
			pw.close();  // close the printWriter to avoid leakage of data
			return true;
		        } catch (Exception ex) 
				{
			      return false;
		        }
	}
/** This function will save member data from ArrayList into BinaryFile format
 * 
 * @param fname
 * @param memberData
 * @return
 */
	public static boolean saveMembertoBinary(String fname, ArrayList<Health> memberData) 
    {
		    try {  
// Object output Stream used to print data into binary file
	            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(fname)));
	
	            oos.writeObject(memberData);  //write data from ArrayList to the object output stream 
	            oos.close();
	            return true; // returns trues if condition is satisfied 
                } catch (Exception ex) 
		    {
	              return false; 
            }
    }
/** This function will save members in Array List in a XML file format
 * 
 * @param fname
 * @param memberData
 * @return
 */
    public static boolean saveStudentsToXML(String fname, ArrayList<Health> memberData ) 
    {
            try {
// XML encoder used to store data file into XML format
                XMLEncoder xml = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
                xml.writeObject(memberData);
                xml.close();           // close the xml encoder to avoid leaking
                return true;           // returns true if condition is satisfied
            } catch (Exception ex) 
            {
                return false;
            }
        }
    }


