/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment;
import java.io.*;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Swiper
 */

public class FeedbackManager {
    private final String filePath = "C:\\Users\\Swiper\\Docments\\NetBeansProjects\\Assignment\\feedback.txt";

    // Generate next Feedback ID
    public String generateFeedbackID() {
    String filePath = "C:\\Users\\Swiper\\Docments\\NetBeansProjects\\Assignment\\feedback.txt";
    String lastID = "F000";  // default if file is empty

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        String lastLine = null;

        while ((line = br.readLine()) != null) {
            if (!line.trim().isEmpty()) { // skip empty lines
                lastLine = line;
            }
        }

        if (lastLine != null) {
            String[] parts = lastLine.split(",");
            lastID = parts[0]; // FeedbackID is the first column, e.g., F002
        }

    } catch (IOException e) {
        e.printStackTrace();
    }

    // Now safely increment
    int num = Integer.parseInt(lastID.substring(1)); // remove "F"
    num++;
    return String.format("F%03d", num); // e.g., F003
}


    // Save new feedback
    public boolean saveFeedback(Feedback feedback) {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(feedback.toCSV());
            bw.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Read all feedbacks from file
public List<Feedback> readFeedbacks() {
    List<Feedback> list = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line = br.readLine(); // skip header
        while ((line = br.readLine()) != null) {
            System.out.println("Reading line: " + line); // 👀 Debug here
            String[] parts = line.split(",");
            if (parts.length == 8) {
                Feedback f = new Feedback(
                    parts[0], parts[1], parts[2], parts[3],
                    parts[4], parts[5], parts[6], parts[7]
                );
                list.add(f);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    System.out.println("Total feedbacks read: " + list.size()); // 👀 Debug count
    return list;
}


}

