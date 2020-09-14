package societes.models;

import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import societes.controllers.BrowseEmployesController;
import societes.controllers.DeleteSocieteController;
import societes.controllers.UpdateSocieteController;

import java.io.IOException;
import java.sql.SQLException;

public class SocieteModel {

    private int societeID;
    private String societeName;
    private String societeAdrr;
    private Button deleteButton;
    private Button updateButton;
    private Button browseButton;

    public SocieteModel(){
    initializeButtons();
    }



    public SocieteModel(int societeID, String societeName, String societeAdrr) {
        this.societeID = societeID;
        this.societeName = societeName;
        this.societeAdrr = societeAdrr;
        initializeButtons();
    }
    public SocieteModel(String societeName, String societeAdrr) {
        this.societeName = societeName;
        this.societeAdrr = societeAdrr;
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

    public String getSocieteAdrr() {
        return societeAdrr;
    }

    public void setSocieteAdrr(String societeAdrr) {
        this.societeAdrr = societeAdrr;
    }


    private void initializeButtons(){
        deleteButton =new Button("Supprimer");

        deleteButton.setOnAction((event) -> {
            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent parent= null;

            try {
                fxmlLoader.load(getClass().getResource("../views/delete_societe_dialog.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            parent = fxmlLoader.getRoot();

            DeleteSocieteController controller= fxmlLoader.getController();
            controller.setLabelText("Etes vous sur supprimer la societe: "+societeName);
            controller.setSocieteID(societeID);
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
                fxmlLoader.load(getClass().getResource("../views/edit_societe_dialog.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            parent = fxmlLoader.getRoot();

            UpdateSocieteController controller= fxmlLoader.getController();
            controller.setOldSocieteAdrr(societeAdrr);
            controller.setOldSocieteName(societeName);
            controller.setSocieteID(societeID);

            Scene scene = new Scene(parent, 414, 200);
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

    });


        browseButton =new Button("Consulter les employes");

        browseButton.setOnAction((event) -> {

            FXMLLoader fxmlLoader=new FXMLLoader();
            Parent parent= null;

            try {
                fxmlLoader.load(getClass().getResource("../views/consulter_employes_dialog.fxml").openStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
            parent = fxmlLoader.getRoot();

            BrowseEmployesController controller= fxmlLoader.getController();

            controller.setSocieteID(societeID);
            controller.setTitle("Les employes de la societe "+societeName);
            controller.initialize(null,null);

            Scene scene = new Scene(parent, 700, 500);
            Stage stage=new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        });


    }
    public Button getBrowseButton() {
        return browseButton;
    }

    public void setBrowseButton(Button browseButton) {

        this.browseButton = browseButton;
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
        return (societeID+societeName+societeAdrr);
    }
}
