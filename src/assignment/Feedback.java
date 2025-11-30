/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;

/**
 *
 * @author Swiper
 */

public class Feedback {
    private String feedbackID;
    private String fromRole;
    private String fromID;
    private String toRole;
    private String toID;
    private String appointmentID;
    private String message;
    private String date;
    public Feedback(String feedbackID, String fromRole, String fromID,
                    String toRole, String toID, String appointmentID,
                    String message, String date) {
        this.feedbackID = feedbackID;
        this.fromRole = fromRole;
        this.fromID = fromID;
        this.toRole = toRole;
        this.toID = toID;
        this.appointmentID = appointmentID;
        this.message = message;
        this.date = date;
    }
    public String toCSV() {
        return feedbackID + "," + fromRole + "," + fromID + "," +
               toRole + "," + toID + "," + appointmentID + "," +
               message + "," + date;
    }
    public String getFeedbackID() {
        return feedbackID; 
    }
    public String getFromRole() {
        return fromRole; 
    }
    public String getFromID() {
        return fromID; 
    }
    public String getToRole() {
        return toRole; 
    }
    public String getToID() {
        return toID; 
    }
    public String getAppointmentID() {
        return appointmentID; 
    }
    public String getMessage() {
        return message; 
    }
    public String getDate() {
        return date; 
    }
}

