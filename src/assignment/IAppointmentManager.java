/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package assignment;
import java.util.List;

/**
 *
 * @author Swiper
 */

public interface IAppointmentManager {
    List<Appointment> readAppointments();
    void writeAppointments(List<Appointment> appointments);
    void rescheduleAppointment(String appointmentID, String newDate, String newTime);
}
