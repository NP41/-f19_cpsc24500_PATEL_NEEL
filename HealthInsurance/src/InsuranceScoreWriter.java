/**This class contains functions to get the assessment data for members and write the assessment to JSON file. 
 * @author NP
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InsuranceScoreWriter 
{
/**writeRiskInformation function will write the risk assessment information for each member. 
 * 
 * @param assess
 */
	public static void writeRiskInformation(ArrayList<InsuranceScore> assess) {
		
		for (InsuranceScore ins: assess)
		{
			System.out.println(ins);
		}	
	}
/**
 * WriteMembersToJSON function will allow the member risk assessment to be stored in a JSON file format. 
 * @param fname
 * @param assessment
 * @return
 */
	public static boolean writeMembersToJSON(String fname, ArrayList<InsuranceScore> assessment) {
    	try {
    		
    	// print writer will be used to write data to JSON file
    		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
    	// create a JSON object for each element	
    		JSONObject memObj;
    		JSONArray jray= new JSONArray(); // JSON array to store JSON objects
    		
    		for (InsuranceScore ins :assessment) {
    			// add values to the JSON object
    			memObj = new JSONObject();
    			
    			// add values to the object 
    			memObj.put("FirstName",ins.getFname());
    			memObj.put("LastName", ins.getLname());
    			memObj.put("Score:", ins.getScore());
    			memObj.put("Verdict:", ins.getRiskLevel());
    			
    			jray.add(memObj);
    		}
          // create an outer Json object 
    		JSONObject out = new JSONObject();
    		out.put("assessment", jray); 
    		
    		pw.println(out.toJSONString());  
    		pw.close();
    		return true;
    	}catch(Exception ex) {
    		return false;
    	}
}
}
