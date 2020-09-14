
package employes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddEmployeController {
    private DatabaseHelper databaseHelper=new DatabaseHelper();
    private Scene scene;
    @FXML
    Button closeAddEmployeDialogButton;
    @FXML
    Button addEmployeButton;
    @FXML
    TextField employeName;
    @FXML
    TextField employeAdrr;


    public void addEmploye(String name,String adrr) throws SQLException {
        if(name ==null || adrr==null) return;
        PreparedStatement preparedStatement = (PreparedStatement) databaseHelper.getCon().prepareStatement(
                "insert into  employes values (default,?, ?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, adrr);
        preparedStatement.executeUpdate();
    }






    public void closeAddEmployeDialog(ActionEvent actionEvent) {

            Stage stage = (Stage) closeAddEmployeDialogButton.getScene().getWindow();
            stage.close();

    }

    public void addEmploye(ActionEvent actionEvent) throws SQLException {
        String name=employeName.getText();
        String adrr=employeAdrr.getText();
        try{
            addEmploye(name,adrr);
        }catch (Exception ex){
            System.out.println(ex);
        }
        Stage stage = (Stage) addEmployeButton.getScene().getWindow();
        stage.close();
    }
}
