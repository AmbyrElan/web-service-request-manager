public class user 
{
		protected String password;
	 	protected String email;
	    protected String firstName;
	    protected String lastName;
	    protected String address_street_num;
	    protected String address_street;
	    protected String address_city;
	    protected String address_state;
	    protected String address_zip_code;
	    protected String birthday;
	    protected int cash_bal;
	    protected int PPS_bal;
	 
	    //constructors
	    public user() {
	    }
	 
	    public user(String email) 
	    {
	        this.email = email;
	    }
	    
	    public user(String email, String fname, String lname, String pwd, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code) {
	    	this.firstName = fname;
	    	this.lastName = lname;
	    	this.password = pwd;
	        this.address_street_num = adress_street_num;
	        this.address_street = adress_street;
	        this.address_city= adress_city;
	        this.address_state = adress_state;
	        this.address_zip_code = adress_zip_code;
	    }
	    /*
	    public user(String email,String firstName, String lastName, String password,String birthday, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code, int cash_bal,  int PPS_bal) 
	    {
	    	this(firstName,lastName,password,birthday, adress_street_num,  adress_street,  adress_city,  adress_state,  adress_zip_code,cash_bal,PPS_bal);
	    	this.email = email;
	    }
	    */
	
	    public user(String firstName, String lastName, String password,String birthday, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code, int cash_bal,  int PPS_bal) 
	    {
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.password = password;
	        this.birthday = birthday;
	        this.address_street_num = adress_street_num;
	        this.address_street = adress_street;
	        this.address_city= adress_city;
	        this.address_state = adress_state;
	        this.address_zip_code = adress_zip_code;
	        this.cash_bal = cash_bal;
	        this.PPS_bal = PPS_bal;
	    }
	    
	    public user(String email, String firstName, String lastName, String password,String birthday, String adress_street_num, String adress_street, String adress_city, String adress_state,String adress_zip_code, int cash_bal,  int PPS_bal) 
	    {
	    	this.email = email;
	    	this.firstName = firstName;
	    	this.lastName = lastName;
	    	this.password = password;
	        this.birthday = birthday;
	        this.address_street_num = adress_street_num;
	        this.address_street = adress_street;
	        this.address_city= adress_city;
	        this.address_state = adress_state;
	        this.address_zip_code = adress_zip_code;
	        this.cash_bal = cash_bal;
	        this.PPS_bal = PPS_bal;
	    }
	    
	   //getter and setter methods
	    public String getEmail() {
	        return email;
	    }
	    public void setEmail(String email) {
	        this.email = email;
	    }
	    
	    public String getFirstName() {
	        return firstName;
	    }
	    public void setFirstName(String firstName) {
	        this.firstName = firstName;
	    }
	    
	    public String getLastName() {
	        return lastName;
	    }
	    public void setLastName(String lastName) {
	        this.lastName = lastName;
	    }
	    
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	  
	    public String getBirthday() {
	    	return birthday;
	    }
	    public void setBirthday(String birthday) {
	    	this.birthday = birthday;
	    }
	    
	    public String getAddress_street_num() {
	        return address_street_num;
	    }
	    public void setAddress_street_num(String adress_street_num) {
	        this.address_street_num = adress_street_num;
	    }
	    public String getAddress_street() {
	        return address_street;
	    }
	    public void setAddress_street(String adress_street) {
	        this.address_street = adress_street;
	    }
	    public String getAddress_city() {
	        return address_city;
	    }
	    public void setAddress_city(String adress_city) {
	        this.address_city = adress_city;
	    }
	    public String getAddress_state() {
	        return address_state;
	    }
	    public void setAddress_state(String adress_state) {
	        this.address_state = adress_state;
	    }
	    public String getAddress_zip_code() {
	        return address_zip_code;
	    }
	    public void setAddress_zip_code(String adress_zip_code) {
	        this.address_zip_code = adress_zip_code;
	    }
	    
	    public int getCash_bal() {
	    	return cash_bal;
	    }
	    public void setCash_bal(int cash_bal) {
	    	this.cash_bal = cash_bal;
	    }
	    
	    public int getPPS_bal() {
	    	return PPS_bal;
	    }
	    public void setPPS_bal(int PPS_bal) {
	    	this.PPS_bal = PPS_bal;
	    }
	}