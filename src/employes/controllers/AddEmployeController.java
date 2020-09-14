
package employes.controllers;

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
import employes.models.EmployeModel;

import java.io.IOException;
import java.sql.CallableStatement;
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
    TextField employeSalaire;
    @FXML
    TextField  societeIDEmploye;


    public void addEmploye(String name,String salaire,String societeID) throws SQLException {
        if(name ==null || salaire==null) return;
        PreparedStatement preparedStatement = (PreparedStatement) databaseHelper.getCon().prepareStatement(
                "insert into  employes values (default,?, ?,?)");
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, salaire);
        preparedStatement.setString(3,societeID);
        preparedStatement.executeUpdate();
    }






    public void closeAddEmployeDialog(ActionEvent actionEvent) {

            Stage stage = (Stage) closeAddEmployeDialogButton.getScene().getWindow();
            stage.close();

    }

    public void addEmploye(ActionEvent actionEvent) throws SQLException {
        String name=employeName.getText();
        String salaire=employeSalaire.getText();
        String id=societeIDEmploye.getText();
        try{
            addEmploye(name,salaire,id);
        }catch (Exception ex){
            System.out.println(ex);
        }
        Stage stage = (Stage) addEmployeButton.getScene().getWindow();
        stage.close();
    }
}
