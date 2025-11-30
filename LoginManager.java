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
public class LoginManager {
    private String filePath;

    public LoginManager(String filePath) {
        this.filePath = filePath;
    }

    // ✅ Check login credentials
    public boolean authenticate(String username, String password) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String fileUsername = parts[1].trim();
                    String filePassword = parts[2].trim();

                    if (fileUsername.equals(username) && filePassword.equals(password)) {
                        return true; // ✅ login success
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // ❌ login failed
    }
}
