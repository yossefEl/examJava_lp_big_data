package societes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.sql.SQLException;

public class UpdateSocieteController {


    private DatabaseHelper databaseHelper=new DatabaseHelper();;

    public void updateSociete(int id,String name,String adrr) throws SQLException {
        databaseHelper.getStatement().executeQuery("UPDATE `societes` SET `nom`="+name+",`adrr`="+adrr +" WHERE id="+id);
    }
    @FXML
    Button closeBtn;
    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();

    }
}
