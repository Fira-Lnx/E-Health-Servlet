package model.receptionist;

public class Receptionist {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String Address;

    public Receptionist(String name, String email, String phoneNumber,String Address, String password){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.Address = Address;
    }

    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for mobile
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for mobile
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter for email
    public String getEmail() {
        return email;
    }

    // Setter for email
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for password
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String Address){this.Address = Address;}
    public String getAddress() {return Address;}


}

