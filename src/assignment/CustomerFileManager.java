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
public class CustomerFileManager {
    private String filePath;

    public CustomerFileManager(String filePath) {
        this.filePath = filePath;
    }
    //Customer historypart
    public List<Customer> readCustomers() {
    List<Customer> customers = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean firstLine = true;
        while ((line = br.readLine()) != null) {
            if (firstLine) { // skip header row
                firstLine = false;
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length == 7) {
                customers.add(new Customer(
                        parts[0], parts[1], parts[2],
                        parts[3], parts[4], parts[5], parts[6]
                ));
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return customers;
}
    //customer registration part
    // Generate new CustomerID
    public String generateCustomerID() {
        int maxID = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 0 && parts[0].startsWith("C")) {
                    int id = Integer.parseInt(parts[0].substring(1));
                    if (id > maxID) maxID = id;
                }
            }
        } catch (IOException e) {
            // ignore if file is new
        }
        return "C" + String.format("%03d", maxID + 1);
    }

    // Save new customer
    public void saveCustomer(Customer customer) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true))) {
            bw.write(customer.getCustomerID() + "," +
                     customer.getUsername() + "," +
                     customer.getPassword() + "," +
                     customer.getFullName() + "," +
                     customer.getEmail() + "," +
                     customer.getPhone() + "," +
                     customer.getAddress());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    //for editprofile
    public void updateCustomer(Customer updated) {
    List<Customer> customers = readCustomers();
    for (int i = 0; i < customers.size(); i++) {
        if (customers.get(i).getCustomerID().equals(updated.getCustomerID())) {
            customers.set(i, updated);
            break;
        }
    }
    saveAll(customers);
}

private void saveAll(List<Customer> customers) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
        for (Customer c : customers) {
            bw.write(c.getCustomerID() + "," +
                     c.getUsername() + "," +
                     c.getPassword() + "," +
                     c.getFullName() + "," +
                     c.getEmail() + "," +
                     c.getPhone() + "," +
                     c.getAddress());
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

}
