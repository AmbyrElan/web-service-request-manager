
public class RequestQuote {

    protected String email;
    protected String firstName;
    protected String lastName;
    protected String phoneNumber;
    protected String address_street_num;
    protected String address_street;
    protected String address_city;
    protected String address_state;
    protected String address_zip_code;

    // constructors
    public RequestQuote() {

    }

    public RequestQuote(String email) 
    {
        this.email = email;
    }

    public RequestQuote(String email, String firstName, String lastName, String phoneNumber, String address_street_num, String address_street, String address_city, String address_state,String address_zip_code) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address_street_num = address_street_num;
        this.address_street = address_street;
        this.address_city= address_city;
        this.address_state = address_state;
        this.address_zip_code = address_zip_code;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress_street_num() {
        return address_street_num;
    }
    public void setAddress_street_num(String address_street_num) {
        this.address_street_num = address_street_num;
    }
    public String getAddress_street() {
        return address_street;
    }
    public void setAddress_street(String address_street) {
        this.address_street = address_street;
    }
    public String getAddress_city() {
        return address_city;
    }
    public void setAddress_city(String address_city) {
        this.address_city = address_city;
    }
    public String getAddress_state() {
        return address_state;
    }
    public void setAddress_state(String address_state) {
        this.address_state = address_state;
    }
    public String getAddress_zip_code() {
        return address_zip_code;
    }
    public void setAddress_zip_code(String address_zip_code) {
        this.address_zip_code = address_zip_code;
    }
}
