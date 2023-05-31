import com.sun.jnlp.ApiDialog;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import javax.swing.*;
import javafx.event.ActionEvent;
import java.io.File;

public class Tail {
    public ComboBox<String> OptionComboBox;
    public TextArea LogBoxTextBox;
    public Tab LookupTab;
    public TextField IPInputBox;
    private String ip;

    public void AddLog(String log) {
        LogBoxTextBox.appendText(log + "\n");
    }

    @FXML
    public void initialize() {
        System.out.println("Tail controller started!");
        OptionComboBox.getItems().addAll("Basic IP lookup", "Whois lookup", "DNS lookup");

        // Listener for the ComboBox, which is the dropdown menu, this lets us know when the user has selected an option
        // We can then use a switch statement to determine which option was selected
        OptionComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("Selected item: '" + newValue + "'.");

            // Create a new instance of the TailLookup class calling it 'lookup'
            TailLookup lookup = new TailLookup();

            switch (newValue) {
                case "Basic IP lookup":
                    //lookup.basic(ip);
                    AddLog("basic lookup");
                    break;
                case "Whois lookup":
                    AddLog("whois lookup");
                    break;
                default:
                    System.out.println("Error: Invalid selection");
                    break;
            }
        });

        // listener for user to unfocus the IP input box
        IPInputBox.focusedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                // when the user unfocuses the IP input box, we want to get the IP they entered
                ip = IPInputBox.getText();

                if (ip.equals("")) {
                    // if the IP input box is empty, we want to display an error message
                    AddLog("Error: IP input box is empty!");
                    return;
                }

                AddLog("IP: " + ip);
            }
        });

        // listener for user to unfocus the LookupTab
        LookupTab.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                System.out.println("Unfocused on the LookupTab");
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Hanaui - Tail");
                alert.setHeaderText(null);
                alert.setContentText("Settings tab is not yet implemented!");
                alert.showAndWait();

                // go back to the LookupTab
                LookupTab.getTabPane().getSelectionModel().select(LookupTab);
            }
        });
    }

    public void ClearOutputButton(ActionEvent event) {
        LogBoxTextBox.clear();
    }

    public void SaveOutputButton(ActionEvent event) {
        // Code from : https://www.w3schools.com/java/java_files_create.asp
        try {
            File myObj = new File("Tail output.txt");
            myObj.createNewFile();

            FileWriter myWriter = new FileWriter("Tail output.txt");
            myWriter.write(LogBoxTextBox.getText());

            myWriter.close();

            if (myObj.exists()) {
                AddLog("Successfully saved output to 'Tail output.txt'!");
            }
        } catch (IOException e) {
            AddLog(e.toString());
            e.printStackTrace();
        }
    }
}
