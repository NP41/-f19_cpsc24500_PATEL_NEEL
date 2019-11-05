/**This java class file includes getters and setters to get the value from the file and use in program. 
 * Along with getters and setters, this class also include constructors to initialize objects.
 * @author NP
 *
 */

public class Health {
	    private  String fname;
	    private  String lname;
	    private  String age;
	    private  String height;
	    private  String weight;
	    private  String bpSystolic;
	    private  String bpDiastolic;
	    private  String cancer;
	    private  String diabetes;
	    private  String alzheimers;
	    
	    // Health constructor to store data from text file to a string
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

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getHeight() {
			return height;
		}

		public void setHeight(String height) {
			this.height = height;
		}

		public String getWeight() {
			return weight;
		}

		public void setWeight(String weight) {
			this.weight = weight;
		}

		public String getBpSystolic() {
			return bpSystolic;
		}

		public void setBpSystolic(String bpSystolic) {
			this.bpSystolic = bpSystolic;
		}

		public String getBpDiastolic() {
			return bpDiastolic;
		}

		public void setBpDiastolic(String bpDiastolic) {
			this.bpDiastolic = bpDiastolic;
		}

		public String getCancer() {
			return cancer;
		}

		public void setCancer(String cancer) {
			this.cancer = cancer;
		}

		public String getDiabetes() {
			return diabetes;
		}

		public void setDiabetes(String diabetes) {
			this.diabetes = diabetes;
		}

		public String getAlzheimers() {
			return alzheimers;
		}

		public void setAlzheimers(String alzheimers) {
			this.alzheimers = alzheimers;
		}

		public Health(String fname, String lname, String age, String height, String weight, String bpSystolic, String bpDiastolic, String cancer, 
				String diabetes, String alzheimers ){
	    	
	    	setLname(lname);
	    	setFname(fname);
	    	setAge(age);
	    	setHeight(height);
	    	setWeight(weight);
	    	setBpSystolic(bpSystolic);
	    	setBpDiastolic(bpDiastolic);
	    	setCancer(cancer);
	    	setDiabetes(diabetes);
	    	setAlzheimers(alzheimers);
	    	
	    }
	    
@Override
public String toString() {
	
	String result = String.format(" %s, %s\n Age %10s \n Height %7s in\n Weight %7s lbs\n BP Syst %6s\n BP Dias %6s\n Cancer %7s\n Diabetes %5s\n "
			+ "Alzheimers %3s\n "
			+ "----------------------", 
			lname, fname, age, height, weight, bpSystolic, bpDiastolic, cancer, diabetes, alzheimers);
			                     
    return result;         
	
}

}
