package societes.controllers;

import dbHelpers.DatabaseHelper;
import employes.models.EmployeModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrowseEmployesController {

    private DatabaseHelper databaseHelper=new DatabaseHelper();
    public ArrayList<EmployeModel> getAllSocieteEmplyees(int id) throws SQLException {
        ArrayList<EmployeModel> employeList=new ArrayList<EmployeModel>();
        ResultSet resultSet= databaseHelper.getStatement().executeQuery("SELECT * FROM `employes` WHERE societe_id="+id);
        while(resultSet.next()){
            employeList.add(new EmployeModel(resultSet.getInt(0),resultSet.getString(1),resultSet.getDouble(2),resultSet.getInt(3)));
        }
        return employeList;

    }
}
