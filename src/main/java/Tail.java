import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Set;
import javax.swing.*;

public class Tail {
    public ComboBox<String> OptionComboBox;

    @FXML
    public void initialize() {
        System.out.println("Tail controller started!");
        OptionComboBox.getItems().addAll("Basic IP lookup", "Whois lookup", "DNS lookup");
    }
}
