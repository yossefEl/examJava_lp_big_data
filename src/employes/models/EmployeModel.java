package employes.models;

public class EmployeModel {
    private  int employeID;
    private String employeName;
    private double employeSalaire;
    private int societeID;

    public EmployeModel(int employeID, String employeName, double employeSalaire, int societeID) {
        this.employeID = employeID;
        this.employeName = employeName;
        this.employeSalaire = employeSalaire;
        this.societeID = societeID;
    }
    public EmployeModel(String employeName, double employeSalaire, int societeID) {
        this.employeID = employeID;
        this.employeName = employeName;
        this.employeSalaire = employeSalaire;
        this.societeID = societeID;
    }

}
