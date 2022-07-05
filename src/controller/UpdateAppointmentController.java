package controller;

import DAO.DBAppointments;
import DAO.DBCountries;
import DAO.DBDivisions;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class UpdateAppointmentController implements Initializable {

    @FXML
    private TextField appointmentDescriptionField;

    @FXML
    private TextField appointmentIdField;

    @FXML
    private TextField appointmentLocationField;

    @FXML
    private TextField appointmentTitleField;

    @FXML
    private TextField appointmentTypeField;

    @FXML
    private ComboBox<?> contactComboBox;

    @FXML
    private ComboBox<?> customerComboBox;

    @FXML
    private ComboBox<?> endTimeComboBox;

    @FXML
    private ComboBox<?> startTimeComboBox;

    @FXML
    void onActionCancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/AppointmentScreen.fxml")));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Appointments");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionSave(ActionEvent event) {

    }


    public void SendAppointment(Appointments appointment) {
        appointmentIdField.setText(String.valueOf(appointment.getAppointmentId())); // id title description location type
        appointmentTitleField.setText(String.valueOf(appointment.getAppointmentTitle()));
        appointmentDescriptionField.setText(String.valueOf(appointment.getAppointmentDescription()));
        appointmentLocationField.setText(String.valueOf(appointment.getAppointmentLocation()));
        appointmentTypeField.setText(String.valueOf(appointment.getAppointmentType()));

/*
        startTimeComboBox.setItems(DBAppointments.getStartTime());
        startTimeComboBox.setValue(appointment.getStartTime()));
        divisionComboBox.setItems(DBDivisions.getDivisionsByCountryId(countryComboBox.getValue().getCountryId()));
        divisionComboBox.setValue(DBDivisions.getDivisionNameFromDivisionId(customer.getCustomerDivisionId()));
*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
