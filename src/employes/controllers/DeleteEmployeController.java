package employes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteEmployeController {
    private DatabaseHelper databaseHelper=new DatabaseHelper();

    public void removeEmploye(int id) throws SQLException {
        databaseHelper.getStatement().executeQuery("DELETE FROM `employes` WHERE id="+id);
    }
    @FXML
    Button closeDeleteEmployeBtn;


    public void closeDeleteEmployeButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeDeleteEmployeBtn.getScene().getWindow();
        stage.close();
    }
}
