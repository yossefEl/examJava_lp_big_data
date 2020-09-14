package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML private VBox vBoxContent;
    @FXML private HBox hb;




    public  void loaderOfEmploye() throws Exception{

        VBox vBox= FXMLLoader.load(MainController.class.getResource("../employes/views/employe_view.fxml"));
        vBoxContent.getChildren().clear();
        vBoxContent.getChildren().setAll(vBox.getChildren());
    }
    public  void loaderOfSociete() throws Exception{

        VBox vBox= FXMLLoader.load(MainController.class.getResource("../societes/views/societe_view.fxml"));
        vBoxContent.getChildren().clear();
        vBoxContent.getChildren().setAll(vBox.getChildren());

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loaderOfSociete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
