package employes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteEmployeController {

    private DatabaseHelper databaseHelper=new DatabaseHelper();


    @FXML
    Button closeDeleteEmployeBtn;

    @FXML
    Button deleteEmployeBtn;

    @FXML
    Label message;
    private int employeID;

    public void closeDeleteEmployeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeDeleteEmployeBtn.getScene().getWindow();
        stage.close();
    }

    public void setLabelText(String s) {
        message.setText(s);
    }

    public void setEmployeID(int employeID) {
        this.employeID=employeID;
    }

    public void deleteEmployeButtonAction(ActionEvent actionEvent) throws SQLException {
        removeEmploye();
    }
    public void removeEmploye() throws SQLException {
        databaseHelper.getStatement().executeUpdate("DELETE FROM `employes` WHERE id="+employeID);
        Stage stage = (Stage) deleteEmployeBtn.getScene().getWindow();
        stage.close();
    }
}
