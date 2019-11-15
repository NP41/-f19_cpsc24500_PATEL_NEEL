/**This java class file includes getters and setters to get the value from the file and use in program. 
 * Along with getters and setters, this class also include constructors to initialize objects.
 * @author NP
 *
 */
import java.io.Serializable;

//class enabled to handle serialization for binary and XML files. 
public class Health implements Serializable {
	
	// declaring variables
	    private  String fname;
	    private  String lname;
	    private   int age;
	    private   int height;
	    private   int weight;
	    private   int bpSystolic;
	    private   int bpDiastolic;
	    private   String cancer;
	    private   String diabetes;
	    private   String alzheimers;
	    
/** Getters and Setters used to access data
 * 
 * @return
 */
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

		public  int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public  int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public  int getBpSystolic() {
			return bpSystolic;
		}

		public void setBpSystolic(int bpSystolic) {
			this.bpSystolic = bpSystolic;
		}

		public  int getBpDiastolic() {
			return bpDiastolic;
		}

		public void setBpDiastolic(int bpDiastolic) {
			this.bpDiastolic = bpDiastolic;
		}

		public  String getCancer() {
			return cancer;
		}

		public void setCancer(String cancer) {
			this.cancer = cancer;
		}

		public  String getDiabetes() {
			return diabetes;
		}

		public void setDiabetes(String diabetes) {
			this.diabetes = diabetes;
		}

		public  String getAlzheimers() {
			return alzheimers; 
		}

		public void setAlzheimers(String alzheimers) {
		    this.alzheimers = alzheimers;
		}
		
		/**
		 * This is a required default constructor to handle the Xml serialization.
		 */
		public Health () {
			fname ="";
			lname ="";
			age =0;
			height=0;
			weight=0;
			bpSystolic=0;
			bpDiastolic=0;
			cancer="";
			diabetes="";
			alzheimers="";
			
		}
/** Constructor used to set the values 
 * 
 * @param fname
 * @param lname
 * @param age
 * @param height
 * @param weight
 * @param bpSystolic
 * @param bpDiastolic
 * @param cancer
 * @param diabetes
 * @param alzheimers
 */
		public Health(String fname, String lname, String age, String height, String weight, String bpSystolic, String bpDiastolic, String cancer, 
				String diabetes, String alzheimers ){
	    	
	    	setLname(lname);
	    	setFname(fname);
	    	setAge(Integer.parseInt(age));
	    	setHeight(Integer.parseInt(height));
	    	setWeight(Integer.parseInt(weight));
	    	setBpSystolic(Integer.parseInt(bpSystolic));
	    	setBpDiastolic(Integer.parseInt(bpDiastolic));
	    	setCancer(cancer);
	    	setDiabetes(diabetes);
	    	setAlzheimers(alzheimers);
	    	
	    }
		
@Override
// toString function will print the data from arrayList into customized format
public String toString() {
	
	String result = String.format("%s, %s\n Age %10s \n Height %7s in\n Weight %7s lbs\n BP Syst %6s\n BP Dias %6s\n Cancer %7s\n Diabetes %5s\n "
			+ "Alzheimers %3s\n "
			+ "----------------------", 
			lname, fname, age, height, weight, bpSystolic, bpDiastolic, cancer, diabetes, alzheimers);
			                     
    return result;         
	
}
}
