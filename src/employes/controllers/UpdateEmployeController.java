package employes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.SQLException;

public class UpdateEmployeController {
    @FXML
    TextField oldEmployeName;
    @FXML
    TextField oldEmployeSalaire;
    @FXML TextField oldEmployeSocieteID;
    @FXML
    Button closeBtn;
    @FXML
    Button updateBtn;
    private  int employeID;

    private DatabaseHelper databaseHelper=new DatabaseHelper();;

    public void updateEmploye(int id,String name,String salaire,String idSociete) throws SQLException {
        databaseHelper.getStatement().executeUpdate("UPDATE `employes` SET `nom_complet`='"+name+"',`salaire`='"+salaire +"' ,`societe_id`='"+idSociete +"' WHERE id="+id);
    }

    public void setOldEmployeName(String name){
        oldEmployeName.setText(name);
    }

    public void setOldemployeSalaire(double salaire){
        oldEmployeSalaire.setText(String.valueOf(salaire));
    }
    public void setOldEmployeSocieteID(int id){
        oldEmployeSocieteID.setText(String.valueOf(id));
    }
    public void setEmployeID(int id){
        employeID=id;
    }
    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
            Stage stage = (Stage) closeBtn.getScene().getWindow();
            stage.close();

    }

    public void updateEmployeInfo(ActionEvent actionEvent) throws SQLException {
        updateEmploye(employeID,oldEmployeName.getText(),oldEmployeSalaire.getText(),oldEmployeSocieteID.getText());
        Stage stage = (Stage) updateBtn.getScene().getWindow();
        stage.close();
    }
}
