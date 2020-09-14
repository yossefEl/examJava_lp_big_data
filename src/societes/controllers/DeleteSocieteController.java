package societes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.sql.SQLException;

public class DeleteSocieteController {
    private DatabaseHelper databaseHelper=new DatabaseHelper();

    public void removeSociete(int id) throws SQLException {
        databaseHelper.getStatement().executeQuery("DELETE FROM `societes` WHERE id="+id);
    }
    @FXML
    Button closeDeleteSocieteBtn;


    public void closeDeleteSocieteButtonAction(ActionEvent actionEvent) {
        Stage stage = (Stage) closeDeleteSocieteBtn.getScene().getWindow();
        stage.close();
    }
}
