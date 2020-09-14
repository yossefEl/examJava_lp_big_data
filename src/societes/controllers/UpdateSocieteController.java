package societes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;

public class UpdateSocieteController {
    @FXML
    TextField oldSocieteName;
    @FXML
    TextField oldSocieteAdrr;
    @FXML
    Button closeBtn;
    @FXML
    Button updateBtn;
    private  int societeID;

    private DatabaseHelper databaseHelper=new DatabaseHelper();;

    public void updateSociete(int id,String name,String adrr) throws SQLException {
        databaseHelper.getStatement().executeUpdate("UPDATE `societes` SET `nom`='"+name+"',`adrr`='"+adrr +"' WHERE id="+id);
    }

    public void setOldSocieteName(String name){
        oldSocieteName.setPromptText(name);
    }

    public void setOldSocieteAdrr(String adrr){
        oldSocieteAdrr.setPromptText(adrr);
    }
    public void setSocieteID(int id){
        societeID=id;
    }
    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();

    }

    public void updateSocieteInfo(ActionEvent actionEvent) throws SQLException {
        updateSociete(societeID,oldSocieteName.getText(),oldSocieteAdrr.getText());
        Stage stage = (Stage) updateBtn.getScene().getWindow();
        stage.close();
    }
}
