package view_controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class ContactScheduleController {

    @FXML
    private RadioButton apptScreenRadioButton;

    @FXML
    private ComboBox<?> contactComboBox;

    @FXML
    private TableView<?> contactScheduleTableView;

    @FXML
    private RadioButton contactScreenRadioButton;

    @FXML
    private RadioButton custScreenRadioButton;

    @FXML
    private Button viewScheduleButton;

    @FXML
    void onActionAppointmentScreen(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view_controller/AppointmentScreen.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 900, 700);
        stage.setTitle("Appointments");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void onActionContactScreen(ActionEvent event) {

    }

    @FXML
    void onActionCustomerScreen(ActionEvent event) {

    }

    @FXML
    void onActionViewSchedule(ActionEvent event) {

    }

}