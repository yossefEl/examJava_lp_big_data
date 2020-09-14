package societes.models;

public class SocieteModel {

    private int societeID;
    private String societeName;
    private String societeAdrr;
    public SocieteModel(){

    }

    public SocieteModel(int societeID, String societeName, String societeAdrr) {
        this.societeID = societeID;
        this.societeName = societeName;
        this.societeAdrr = societeAdrr;
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

    @Override
    public String toString() {
        return (societeID+societeName+societeAdrr);
    }
}
