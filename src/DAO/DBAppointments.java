package DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import model.Contacts;
import model.Customers;
import utilities.JDBC;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public abstract class DBAppointments {

    public static ObservableList<Appointments> getAllAppointments() {
        ObservableList<Appointments> allAppointmentsList = FXCollections.observableArrayList();

        try{
            String sql = "SELECT Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID FROM client_schedule.appointments;";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int appointmentId = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
//              Injecting Timestamp
//              ps.setTimestamp();
//              Extracting Timestamp
//              rs.getTimestamp("");
//              DateTimeFormatter
//              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
                Timestamp startTime = rs.getTimestamp("Start");
                Timestamp endTime = rs.getTimestamp("End");
                int customerId = rs.getInt("Customer_ID");
                int userId = rs.getInt("User_ID");
                int contactId = rs.getInt("Contact_ID");

                Appointments a = new Appointments(appointmentId, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, startTime, endTime, customerId, userId, contactId);
                allAppointmentsList.add(a);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return allAppointmentsList;
    }

    public static ObservableList<Appointments> getAppointmentsByContactId(int cID) {
        ObservableList<Appointments> contactAppointmentsList = FXCollections.observableArrayList();

        try {
            String sql = "SELECT Appointment_ID, Title, Description, Location, Type, Start, End, Customer_ID, User_ID, Contact_ID FROM client_schedule.appointments WHERE Contact_ID = ?;";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, cID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int appointmentId = rs.getInt("Appointment_ID");
                String appointmentTitle = rs.getString("Title");
                String appointmentDescription = rs.getString("Description");
                String appointmentLocation = rs.getString("Location");
                String appointmentType = rs.getString("Type");
//              Injecting Timestamp
//              ps.setTimestamp();
//              Extracting Timestamp
//              rs.getTimestamp("");
//              DateTimeFormatter
//              DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
                Timestamp startTime = rs.getTimestamp("Start");
                Timestamp endTime = rs.getTimestamp("End");
                int customerId = rs.getInt("Customer_ID");
                int userId = rs.getInt("User_ID");
                int contactId = rs.getInt("Contact_ID");

                Appointments a = new Appointments(appointmentId, appointmentTitle, appointmentDescription, appointmentLocation, appointmentType, startTime, endTime, customerId, userId, contactId);
                contactAppointmentsList.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contactAppointmentsList;
    }

    public static Contacts getContactByAppointmentId(int aId) {

        int cId = 0;
        Contacts contact = null;

        try {
            String sql = "SELECT Contact_ID FROM appointments WHERE Appointment_ID = ?;";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql2 = "SELECT * FROM client_schedule.contacts WHERE Contact_ID = ?;";
            PreparedStatement ps2 = JDBC.getConnection().prepareStatement(sql2);
            ps2.setInt(1, cId);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                int contactId = rs2.getInt("Contact_ID");
                String contactName = rs2.getString("Contact_Name");
                String contactEmail = rs2.getString("Email");

                contact = new Contacts(contactId, contactName, contactEmail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contact;
    }

    public static Customers getCustomerByAppointmentId(int aId) {

        int cId = 0;
        Customers customer = null;

        try {
            String sql = "SELECT Customer_ID FROM appointments WHERE Appointment_ID = ?;";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, aId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cId = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql2 = "SELECT Customer_ID, Customer_Name, Address, Postal_Code, Phone, Division_ID FROM customers WHERE Customer_ID = ?;";
            PreparedStatement ps2 = JDBC.getConnection().prepareStatement(sql2);
            ps2.setInt(1, cId);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                int customerId = rs2.getInt("Customer_ID");
                String customerName = rs2.getString("Customer_Name");
                String customerAddress = rs2.getString("Address");
                String customerPostalCode = rs2.getString("Postal_Code");
                String customerPhone = rs2.getString("Phone");
                int customerDivisionId = rs2.getInt("Division_ID");

                customer = new Customers(customerId, customerName, customerAddress, customerPostalCode, customerPhone, customerDivisionId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }



        public static ObservableList<String> getAllTypes(){
        ObservableList<String> allTypesList = FXCollections.observableArrayList();

        try{
            String sql = "SELECT distinct Type FROM client_schedule.appointments;";
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String type = rs.getString("Type");

                allTypesList.add(type);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return allTypesList;
    }

    public static void DeleteAppointment(int appointmentId){
        String sql = "DELETE FROM appointments WHERE Appointment_ID = ?";
        try{
            PreparedStatement ps = JDBC.getConnection().prepareStatement(sql);
            ps.setInt(1, appointmentId);
            ps.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    // TODO Add Appointment method.
/*
    public static void AddAppointment(int appointmentId, String appointmentTitle, String appointmentDescription, String appointmentLocation, String appointmentType, Timestamp startTime, Timestamp endTime, int customerId, int userId, int contactId){
        try {
            String sql = "INSERT INTO appointment VALUES(NULL, ?, ?, ?, ?, NULL, NULL, NULL, NULL, ?)"; // TODO will need to be adjusted for appointment
            PreparedStatement ps= JDBC.getConnection().prepareStatement(sql);
            ps.setString(1, customerName);
            ps.setString(2, customerAddress);
            ps.setString(3, customerPostalCode);
            ps.setString(4, customerPhone);
            ps.setInt(5, customerDivisionId);
            ps.executeUpdate(); // OR EXECUTE UPDATE or just EXECUTE?
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
*/

}
