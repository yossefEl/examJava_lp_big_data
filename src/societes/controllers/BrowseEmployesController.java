package societes.controllers;

import dbHelpers.DatabaseHelper;
import employes.models.EmployeModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BrowseEmployesController implements Initializable {
    @FXML
    private TableView<EmployeModel> employesDataTableView;
    @FXML private TableColumn<String,String> employeIDTableCol;
    @FXML private TableColumn <String,String> employeNameTableCol;
    @FXML private TableColumn <String,String> employeSalaireTableCol;

        @FXML Label titleSocieteListEm;
    private int societeID;


    private ArrayList<EmployeModel> employeList=new ArrayList<EmployeModel>();

    private DatabaseHelper databaseHelper=new DatabaseHelper();

    public BrowseEmployesController() {
    }

    public void setTitle(String s){
        titleSocieteListEm.setText(s);
    }

    public void getAllSocieteEmplyees() throws SQLException {
        employeList.clear();
        ResultSet resultSet= databaseHelper.getStatement().executeQuery("SELECT * FROM `employes` WHERE societe_id="+societeID);
        while(resultSet.next()){
            employeList.add(new EmployeModel(resultSet.getInt(1),resultSet.getString(2),resultSet.getDouble(3),resultSet.getInt(4)));
        }

    }
    public void fillTable(){

        EmployeModel employe=new EmployeModel();
        employeIDTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("employeID"));
        employeNameTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("employeName"));
        employeSalaireTableCol.setCellValueFactory(new PropertyValueFactory<String ,String>("employeSalaire"));

        ObservableList<EmployeModel> list = FXCollections.observableList(employeList);
        employesDataTableView.setItems(list);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            getAllSocieteEmplyees();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        fillTable();
    }

    public void setSocieteID(int societeID) {
        this.societeID = societeID;
    }
}
