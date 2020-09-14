package employes.controllers;

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
import employes.models.EmployeModel;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class EmployeController implements Initializable {
    @FXML private TableView<EmployeModel> employesDataTableView;
        @FXML private TableColumn <String,String> employeIDTableCol;
        @FXML private TableColumn <String,String> employeNameTableCol;
        @FXML private TableColumn <String,String> employeSalaireTableCol;
    @FXML private TableColumn <String,String> employeSocieteTableCol;
            @FXML private TableColumn <String ,Button> employeUpdateTableCol;
    @FXML private TableColumn <String ,Button> employeDeleteTableCol;








    private ArrayList<EmployeModel> employes=new ArrayList<EmployeModel>();
    private DatabaseHelper databaseHelper=new DatabaseHelper();



    public  EmployeController() throws SQLException {
    }







    public ArrayList<EmployeModel> getEmployes() {
        return employes;
    }
    public void setEmployes(ArrayList<EmployeModel> employes) {
        this.employes = employes;
    }



    public void getAllEmployes() throws SQLException {



        ResultSet resultSet = null;
        try {
            resultSet= databaseHelper.getStatement().executeQuery("" +
                    "SELECT employes.id, employes.nom_complet,employes.salaire,employes.societe_id,societes.nom\n" +
                    "FROM employes\n" +
                    "INNER JOIN societes ON employes.societe_id=societes.id;");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        employes.clear();

        if(resultSet!=null){
            while(resultSet.next()){
                EmployeModel employe=new EmployeModel(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4));
                employe.setSocieteName(resultSet.getString(5));
                employes.add(employe);
            }
        }

        }




    public void fillTable(){

        EmployeModel employe=new EmployeModel();
            employeIDTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("employeID"));
            employeNameTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("employeName"));
            employeSalaireTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("employeSalaire"));
            employeSocieteTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("societeName"));
            employeUpdateTableCol.setCellValueFactory(new PropertyValueFactory<String ,Button>("updateButton"));
            employeDeleteTableCol.setCellValueFactory(new PropertyValueFactory<String ,Button>("deleteButton"));
            ObservableList<EmployeModel> list = FXCollections.observableList(employes);
            employesDataTableView.setItems(list);

    }




    public void searchSocieties(String keyword){
        ArrayList<EmployeModel> results =new ArrayList<EmployeModel>();
        employes.forEach((employe)->{
            //to string is a combination of the Class attributes so it is good to use it as a query
            //because the user may want to search with any employe attribute
            if(employe.toString().contains(keyword)){
                results.add(employe);
            }

        });

        employes.clear();
        employes.addAll(results);
    }


    public void showAddEmployeDialog(ActionEvent actionEvent) throws IOException {
        Parent parent= FXMLLoader.load(getClass().getResource("../views/add_employe_dialog.fxml"));
        Scene scene = new Scene(parent, 414, 180);
        Stage stage=new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(scene);
        stage.showAndWait();
        initialize(null,null);
    }








    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            getAllEmployes();
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
