/**
 * Java. Level 2  Lesson 4.
 *
 * @author Shangareev Rinat
 * @version dated 30.11.2017
 */
package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;


public class Controller {
    @FXML
    TextField textField;
    @FXML
    TextArea resultsArea;
    @FXML
    Button btnSend;

    public void btnClick(ActionEvent actionEvent){
        resultsArea.appendText(String.format("%s\n\r", textField.getText()));
        textField.clear();
        resultsArea.requestFocus();
    }

    public void keyPress(KeyEvent keyEvent){
        if (keyEvent.getCode() == KeyCode.ENTER) {
            btnClick(null);
        }
    }

}
