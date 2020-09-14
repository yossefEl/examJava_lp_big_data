package employes.models;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import employes.controllers.DeleteEmployeController;
import employes.controllers.UpdateEmployeController;

import java.io.IOException;
import java.nio.DoubleBuffer;

public class EmployeModel {

    private int employeID;
    private String employeName;
    private Double employeSalaire;
    private int societeID;
    private Button deleteButton;
    private Button updateButton;
    private String societeName;


    public EmployeModel(){
    initializeButtons();
    }



    public EmployeModel(int employeID, String employeName, Double employeSalaire, int societeID) {
        this.employeID = employeID;
        this.employeName = employeName;
        this.employeSalaire = employeSalaire;
        this.societeID = societeID;
        initializeButtons();
    }
    public EmployeModel(String employeName, Double employeSalaire,int societeID) {
        this.employeName = employeName;
        this.employeSalaire = employeSalaire;
        this.societeID=societeID;
    }

    public int getEmployeID() {
        return employeID;
    }

    public void setEmployeID(int employeID) {
        this.employeID = employeID;
    }

    public String getEmployeName() {
        return employeName;
    }

    public void setEmployeName(String employeName) {
        this.employeName = employeName;
    }

    public Double getEmployeSalaire() {
        return employeSalaire;
    }

    public void setEmployeSalaire(Double employeSalaire) {
        this.employeSalaire = employeSalaire;
    }

    public int getSocieteID() {
        return societeID;
    }

    public void setSocieteID(int societeID) {
        this.societeID = societeID;
    }

    public String getSocieteName() {
        return societeName;
    }

    public void setSocieteName(String societeName) {
        this.societeName = societeName;
    }
    private void initializeButtons(){
        deleteButton =new Button("Supprimer");

        deleteButton.setOnAction((event) -> {
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent parent= null;

            try {
                fxmlLoader.load(getClass().getResource("../views/delete_employe_dialog.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            parent = fxmlLoader.getRoot();

            DeleteEmployeController controller= fxmlLoader.getController();
            controller.setLabelText("Etes vous sur supprimer l'employe: "+employeName);
            controller.setEmployeID(employeID);
            Scene scene = new Scene(parent, 414, 200);
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();


        });
            updateButton =new Button("Mettre a jour");
        updateButton.setOnAction((event) -> {
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent parent= null;

            try {
                fxmlLoader.load(getClass().getResource("../views/edit_employe_dialog.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            parent = fxmlLoader.getRoot();

            UpdateEmployeController controller= fxmlLoader.getController();
            controller.setOldemployeSalaire(employeSalaire);
            controller.setOldEmployeName(employeName);
            controller.setEmployeID(employeID);
            controller.setOldEmployeSocieteID(societeID);

            Scene scene = new Scene(parent, 414, 200);
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

    });
        




    }


    public Button getUpdateButton() {

        return updateButton;
    }

    public void setUpdateButton(Button updateButton) {
        this.updateButton = updateButton;
    }

    public Button getDeleteButton() {
        return deleteButton;
    }




    @Override
    public String toString() {
        return (employeID+employeName+employeSalaire);
    }


}
