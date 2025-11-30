/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Swiper
 */

public class Appointment {
    private String appointmentID, customerID, doctorID, doctorName, date, time, status;
    private double charge;

    public Appointment(String appointmentID, String customerID, String doctorID,
                       String doctorName, String date, String time,
                       String status, double charge) {
        this.appointmentID = appointmentID;
        this.customerID = customerID;
        this.doctorID = doctorID;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
        this.status = status;
        this.charge = charge;
    }

    public String getAppointmentID() {
        return appointmentID; 
    }
    
    public String getCustomerID() {
        return customerID; 
    }
    
    public String getDoctorID() {
        return doctorID; 
    }
    
    public String getDoctorName() {
        return doctorName; 
    }
    
    public String getDate() {
        return date; 
    }
    
    public String getTime() {
        return time; 
    }
    
    public String getStatus() {
        return status; 
    }
    
    public double getCharge() {
        return charge; 
    }

    public void setDate(String date) {
        this.date = date;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setCharge(double charge) {
        this.charge = charge;
    }
}
