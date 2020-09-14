package societes.controllers;

import dbHelpers.DatabaseHelper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.stage.Modality;
import javafx.stage.Stage;
import societes.models.SocieteModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SocieteController implements Initializable {
    @FXML private TableView<SocieteModel> societesDataTableView;
        @FXML private TableColumn <String,String> societeIDTableCol;
        @FXML private TableColumn <String,String> societeNameTableCol;
        @FXML private TableColumn <String,String> societeAdrrTableCol;
            @FXML private TableColumn <String ,Button> societeUpdateTableCol;
    @FXML private TableColumn <String ,Button> societeDeleteTableCol;
    @FXML private TableColumn <String ,Button> societeBrowseEmployesTableCol;







    private ArrayList<SocieteModel> societes=new ArrayList<SocieteModel>();
    private DatabaseHelper databaseHelper=new DatabaseHelper();



    public  SocieteController() throws SQLException {
    }







    public ArrayList<SocieteModel> getSocietes() {
        return societes;
    }
    public void setSocietes(ArrayList<SocieteModel> societes) {
        this.societes = societes;
    }



    public void getAllSocietes() throws SQLException {



        ResultSet resultSet = null;
        try {
            resultSet= databaseHelper.getStatement().executeQuery("SELECT * FROM societes");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        societes.clear();

        if(resultSet!=null){
            while(resultSet.next()){
                societes.add(new SocieteModel(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
            }
        }

        }




    public void fillTable(){

        SocieteModel societe=new SocieteModel();
            societeIDTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("societeID"));
            societeNameTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("societeName"));
            societeAdrrTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("societeAdrr"));
            societeUpdateTableCol.setCellValueFactory(new PropertyValueFactory<String ,Button>("updateButton"));
            societeDeleteTableCol.setCellValueFactory(new PropertyValueFactory<String ,Button>("deleteButton"));
            societeBrowseEmployesTableCol.setCellValueFactory(new PropertyValueFactory<String ,Button>("browseButton"));
            ObservableList<SocieteModel> list = FXCollections.observableList(societes);
            societesDataTableView.setItems(list);

    }



//    private Button deleteButtonBuilder(){
//        System.out.println();
//        Button deleteButton =new Button("Supprimer");
//
//        deleteButton.setOnAction((event) -> {
//            societesDataTableView.getItems().forEach((item)->{
//                System.out.println(item);
//            });
//
//            Parent parent= null;
//
//            try {
//                parent = FXMLLoader.load(getClass().getResource("../views/delete_societe_dialog.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Scene scene = new Scene(parent, 414, 140);
//            Stage stage=new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.setScene(scene);
//            stage.showAndWait();
//            initialize(null,null);
//
//        });
//        return deleteButton;
//    }

//    private Button editButtonBuilder(){
//        Button editButton =new Button("Mettre a jour");
//        editButton.setOnAction((event) -> {
//
//            Parent parent= null;
//            try {
//                parent = FXMLLoader.load(getClass().getResource("../views/edit_societe_dialog.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Scene scene = new Scene(parent, 414, 140);
//            Stage stage=new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.setScene(scene);
//            stage.showAndWait();
//            initialize(null,null);
//
//        });
//        return editButton;
//    }
//    private Button browseButtonBuilder(){
//        Button browseButton =new Button("Consulter les employes");
//
//        browseButton.setOnAction((event) -> {
//
//            Parent parent= null;
//            try {
//                parent = FXMLLoader.load(getClass().getResource("../views/consulter_employes_dialog.fxml"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            Scene scene = new Scene(parent, 700, 500);
//            Stage stage=new Stage();
//            stage.initModality(Modality.APPLICATION_MODAL);
//            stage.setScene(scene);
//            stage.showAndWait();
//
//        });
//        return browseButton;
//    }



    public void searchSocieties(String keyword){
        ArrayList<SocieteModel> results =new ArrayList<SocieteModel>();
        societes.forEach((societe)->{
            //to string is a combination of the Class attributes so it is good to use it as a query
            //because the user may want to search with any societe attribute
            if(societe.toString().contains(keyword)){
                results.add(societe);
            }

        });

        societes.clear();
        societes.addAll(results);
    }


    public void showAddSocieteDialog(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("../views/add_societe_dialog.fxml"));
        Scene scene = new Scene(parent, 414, 140);
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        initialize(null,null);
    }








    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            getAllSocietes();
            fillTable();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refreshContent(ActionEvent actionEvent) {
        initialize(null,null);
    }
    @FXML
    TextField searchKeyWord;
    public void searchSocieties(ActionEvent actionEvent) {
        searchSocieties(searchKeyWord.getText());
        fillTable();
    }
}
