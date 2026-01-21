package model.user;

public class User {
    private String name;
    private String mobile;
    private String email;
    private String password;
    private String pincode;
    private String city;
    private String state;
    private String address;

    // Constructor
    public User(String name, String mobile, String email, String password,
                String pincode, String city, String state, String address) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.password = password;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.address = address;
    }

    // Getters and Setters ...
    public String getName() { return name; }
    public void setName(String name){this.name= name;}

    public String getMobile() { return mobile; }
    public void setMobile(String mobile){this.mobile= mobile;}

    public String getEmail() { return email; }
    public void setEmail(String email){this.email= email;}

    public String getPassword() { return password; }
    public void setPassword(String password){this.password= password;}

    public String getPincode() { return pincode; }
    public void setPincode(String pincode){this.pincode= pincode;}

    public String getCity() { return city; }
    public void setCity(String city){this.city= city;}

    public String getState() { return state; }
    public void setState(String state){this.state= state;}

    public String getAddress() { return address; }
    public void setAddress(String address){this.address= address;}

}