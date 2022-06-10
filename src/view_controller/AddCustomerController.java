package view_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddCustomerController {

    @FXML
    private ComboBox<?> countryComboBox;

    @FXML
    private TextField customerAddressField;

    @FXML
    private TextField customerIdField;

    @FXML
    private TextField customerNameField;

    @FXML
    private TextField customerPhoneNumberField;

    @FXML
    private TextField customerPostalCodeField;

    @FXML
    private ComboBox<?> divisionComboBox;

    @FXML
    void onActionCancel(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view_controller/CustomerScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 900, 700);
        stage.setTitle("Customers");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onActionSave(ActionEvent event) {

    }

}