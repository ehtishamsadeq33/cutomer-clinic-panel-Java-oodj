/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.io.*;
import java.util.*;

/**
 *
 * @author Swiper
 */


public class AppointmentFileManager implements IAppointmentManager {
    private String filePath;

    public AppointmentFileManager(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<Appointment> readAppointments() {
    List<Appointment> list = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        br.readLine(); // skip header ✅
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 8) {
                Appointment a = new Appointment(
                    parts[0], parts[1], parts[2], parts[3],
                    parts[4], parts[5], parts[6],
                    Double.parseDouble(parts[7]) // safe now
                );
                list.add(a);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return list;
}


    @Override
    public void writeAppointments(List<Appointment> appointments) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        // write header
        bw.write("appointmentID,customerID,doctorID,doctorname,date,time,status,Charge");
        bw.newLine();

        // write records
        for (Appointment a : appointments) {
            bw.write(
                a.getAppointmentID() + "," +
                a.getCustomerID() + "," +
                a.getDoctorID() + "," +
                a.getDoctorName() + "," +
                a.getDate() + "," +
                a.getTime() + "," +
                a.getStatus() + "," +
                a.getCharge()
            );
            bw.newLine();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    @Override
    public void rescheduleAppointment(String appointmentID, String newDate, String newTime) {
    List<Appointment> appointments = readAppointments();
    boolean updated = false;

    for (Appointment a : appointments) {
        if (a.getAppointmentID().equals(appointmentID)) {
            a.setDate(newDate);
            a.setTime(newTime);
            a.setStatus("PENDING"); // ✅ change status to PENDING
            updated = true;
            break;
        }
    }

    if (updated) {
        writeAppointments(appointments);
    }
}

}
