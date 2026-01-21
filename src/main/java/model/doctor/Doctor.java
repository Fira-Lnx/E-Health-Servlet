package model.doctor;

public class Doctor {
    private String name;
    private String email;
    private String password;
    private String qualification;
    private String specialization;
    private String contact;
    private String address;

    public Doctor(String name, String email, String password,String qualification, String specialization, String contact, String address){
        this.name = name;
        this.email = email;
        this.password = password;
        this.qualification = qualification;
        this.specialization = specialization;
        this.contact = contact;
        this.address = address;

    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getContact() {return contact;}
    public void setContact(String contact) {this.contact = contact;}

    public String getQualification() {return qualification;}
    public void setQualification(String qualification) {this.qualification = qualification;}

    public String getSpecialization() {return specialization;}
    public void setSpecialization(String specialization) {this.specialization = specialization;}
}
