
package societes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import societes.models.SocieteModel;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddSocieteController {
    private DatabaseHelper databaseHelper=new DatabaseHelper();
    private Scene scene;
    @FXML
    Button closeAddSocieteDialogButton;
    @FXML
    Button addSocieteButton;
    @FXML
    TextField societeName;
    @FXML
    TextField societeAdrr;


    public void addSociete(String name,String adrr) throws SQLException {
        if(name ==null || adrr==null) return;
        PreparedStatement preparedStatement = (PreparedStatement) databaseHelper.getCon().prepareStatement(
                "insert into  societes values (default,?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, adrr);
        preparedStatement.executeUpdate();
    }






    public void closeAddSocieteDialog(ActionEvent actionEvent) {

            Stage stage = (Stage) closeAddSocieteDialogButton.getScene().getWindow();
            stage.close();

    }

    public void addSociete(ActionEvent actionEvent) throws SQLException {
        String name=societeName.getText();
        String adrr=societeAdrr.getText();
        try{
            addSociete(name,adrr);
        }catch (Exception ex){
            System.out.println(ex);
        }
        Stage stage = (Stage) addSocieteButton.getScene().getWindow();
        stage.close();
    }
}
