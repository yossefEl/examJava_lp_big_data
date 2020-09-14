package societes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteSocieteController {

    private DatabaseHelper databaseHelper=new DatabaseHelper();


    @FXML
    Button closeDeleteSocieteBtn;

    @FXML
    Button deleteSocieteBtn;

    @FXML
    Label message;
    private int societeID;

    public void closeDeleteSocieteButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeDeleteSocieteBtn.getScene().getWindow();
        stage.close();
    }

    public void setLabelText(String s) {
        message.setText(s);
    }

    public void setSocieteID(int societeID) {
        this.societeID=societeID;
    }

    public void deleteSocieteButtonAction(ActionEvent actionEvent) throws SQLException {
        removeSociete();
    }
    public void removeSociete() throws SQLException {
        databaseHelper.getStatement().executeUpdate("DELETE FROM `societes` WHERE id="+societeID);
        Stage stage = (Stage) deleteSocieteBtn.getScene().getWindow();
        stage.close();
    }
}
