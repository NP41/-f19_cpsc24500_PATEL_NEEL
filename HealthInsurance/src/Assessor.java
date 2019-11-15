
/**This Accessor class will perform all calculations to create the insurance report card. 
 * i.e. assessing the risk levels of members based on their diseases history and blood pressure. 
 * 
 * @author NP
 */
import java.util.ArrayList;

public class Assessor{
	
/**memberScoreAssessor will assess risk score for each member. 
 * 
 * @param memberData
 * @return
 */
public static ArrayList<InsuranceScore> memberScoreAsessor(ArrayList<Health> memberData)
{
	ArrayList<InsuranceScore> assessment = new ArrayList<InsuranceScore>();
	
	for (Health h: memberData) 
	{
		// create insurance score object
		InsuranceScore assess = new InsuranceScore(h.getFname().trim(),h.getLname().trim(),addScoreForMembers(h)); 
		assessment.add(assess);
	}
	
	return assessment;
}
/**
 * This addScoreForMembers will assign penalty points to members based on their age, blood pressure, BMI and disease in family (if any).
 * @
 */
public static int addScoreForMembers(Health h) 
{
	
int riskLevel =0; 
double bmi=0;
// formula to calculate the BMI
bmi = ((double)(h.getWeight())/ (h.getHeight()* h.getHeight()))*703;

{
	if (bmi>=18.5 && bmi <= 24.9)
	  {
			riskLevel = riskLevel +0;	
	  }
			
	else if (bmi>=25.0 && bmi <= 29.9) 
	  {
				riskLevel = riskLevel +30;
	  }
	else 
	  {
				riskLevel = riskLevel + 75;
	  }
	}	     
	    
	/*
	 *  If Systolic blood pressure is less than 120 and diastolic bp is less than 80 add 0 penalty points to riskLevel of member 
	 *  follow same steps for adding penalty points for all criteria including age, BMI, family disease (if any). 
	 */
{   	
	if (h.getBpSystolic() < 120 && h.getBpDiastolic() <80)
	  {
		riskLevel = riskLevel + 0;
	  }
	else if ((h.getBpSystolic() >= 120 && h.getBpSystolic() <=129) && h.getBpDiastolic() < 80)
	  {
		
		riskLevel = riskLevel + 15;
	  }
	else if (h.getBpSystolic() >= 130 && h.getBpSystolic() <=139 || 
	(h.getBpDiastolic() >=80 && h.getBpDiastolic() <=89))
	  {
		riskLevel = riskLevel+ 30;
	  }
	else if (h.getBpSystolic() >= 140 || h.getBpDiastolic() >=90) 
	  {
		riskLevel = riskLevel+ 75;
	  }

	else if (h.getBpSystolic() >= 180 || h.getBpDiastolic() >=120)
	{
		riskLevel = riskLevel+100;
	}
	     }
	     {
	    	 
	 if(h.getAge() >= 30 && h.getAge() < 45) 
	    {
		riskLevel = riskLevel+10;
	    }
	 else if (h.getAge() >= 45&& h.getAge() < 60) 
	    {
		 riskLevel = riskLevel+20;
	    }
	 else if (h.getAge()>=60)
	    {
		 riskLevel = riskLevel+30;
	     }
	     }
	     {
	  if (h.getCancer().contentEquals("y")) 
	    	 {
	    		 riskLevel = riskLevel+10;
	    	 }
	   if (h.getDiabetes().contentEquals("y")) 
	    	 {
	    		 riskLevel = riskLevel + 10;
	    	 }
	   if (h.getAlzheimers().contentEquals("y")) 
	    	 {
	    		 riskLevel = riskLevel + 10;
	    	 } 
	     }
	     return riskLevel;
		}
}
