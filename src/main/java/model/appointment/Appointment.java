package model.appointment;

import java.sql.Time;
import java.util.Date;

public class Appointment {
    private String doctor;
    private Date date;
    private Time time;
    private String reason;

    public Appointment(String doctor, Date date , Time time, String reason){
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.reason = reason;
    }

    public Date getDate() {return date;}

    public void setDate(Date date) {this.date = date;}

    public String getDoctor() {return doctor;}

    public void setDoctor(String doctor) {this.doctor = doctor;}

    public String getReason() {return reason;}

    public void setReason(String reason) {this.reason = reason;}

    public Time getTime() {return time;}

    public void setTime(Time time) {this.time = time;}
}
