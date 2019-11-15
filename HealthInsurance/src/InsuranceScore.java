/**This class will be used to create an object of class InsuranceScore that stores the name, score, and risk level for a member.
 * 
 * @author NP
 *
 */
import java.io.Serializable;

// Implemented Serialization in case we need to use XML formatting.
public class InsuranceScore implements Serializable{
/**
 * Following getters and setters will be used within the object of InsuranceScore to model risk associated with each member.	
 */
	private String fname;
	private String lname;
	private int score;
	private String riskLevel;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public double getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getRiskLevel() {
		return riskLevel;
	}
	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}	
/**
 * Insurance score constructor that will calculate the riskLevel within itself.  
 * @param fname
 * @param lname
 * @param score
 */
	public InsuranceScore(String fname, String lname, int score) {
		setFname(fname);
		setLname(lname);
		setScore(score);
		
    if (score <= 20) 
    {
	 riskLevel = "Low Risk";
    }
    else if (score > 20 && score <=50)
    {
	riskLevel = "Moderate Risk";
    }
    else if (getScore() > 50 && score <=75)
    {
	riskLevel = "High Risk";
    }
    else {
	riskLevel = "Uninsurable";
    }
		
	}
	/**
	 * Default constructor in case we need to serialize in Xml.
	 */
	public InsuranceScore() {
		fname="";
		lname="";
		score=0;
		riskLevel ="";
	}
	
	@Override
/**
 * toString function will print the insurance details with risk assessment of members in a formatted way.
 */
	public String toString() {
		String str = "";
		String firstLast = lname + ", "+ fname;
		
		String scoreString = "" + score;
		return String.format("Name:          %20s\n"
							+"Score:         %20s\n" 
							+"Verdict:       %20s\n\n",
							firstLast, scoreString, riskLevel);
	}
}
