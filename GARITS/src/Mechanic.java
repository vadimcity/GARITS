import DB.DatabaseConnection;

import java.util.ArrayList;

public class Mechanic extends User {
    int x = 0;
    StockControlSystem scs;

    public Mechanic(String un, String pw, StockControlSystem s){
        super("Mechanic", un,pw);
        scs = s;
    }
    public Mechanic(String role, String un, String pw, StockControlSystem s){
        super(role, un,pw);
        scs = s;
    }


    public void pickJob(){
        //read dropdown list of jobs (formed using databaseReturnString(String sql)) and choose one         possibly table or something else instead
        //so first, form an array of strings, or some array that's required, for the dropdown/table to implement

        ArrayList<String> al = DatabaseConnection.databaseReturnString(
                "SELECT * FROM pendingjoblist", "Details");
    }
    public void changeDurationOfJob(int JobID, int hours, int minutes, int seconds){
        DatabaseConnection.databaseAffectTemplate("UPDATE activeJoblist SET Duration = '" + hours + ":" + minutes + ":" + seconds + "' WHERE JobID='" + JobID + "'");
    }

    public void fillJobSheet(){
    }
    public void printTheJobSheet(){
    }

    public void getParts () { scs.getParts(); }

}