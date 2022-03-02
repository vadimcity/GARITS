import DB.DatabaseConnection;

import java.util.ArrayList;

public abstract class User {
    String role;
    String username;
    String password;
    boolean loggedin;

    public User(String r, String un, String pw){
        role = r;
        username = un; username = "Sampson";
        password = pw; password = "SonSam";
        loggedin = false;
    }

    // /*protected*/ public boolean login(String role, String usn, String psw){
    //connect to database, and check if role, username and password apply to anyone, if not, return false;
    //current issue with getting databaseconnection class to get a boolean from database

    //DB.DatabaseConnection.databaseAffectTemplate(
    //        "SELECT FROM useraccounts WHERE Username=" + usn + " AND Password=" + psw + " AND Role=" + role);

    //"SELECT CASE WHEN EXISTS ( SELECT * FROM useraccounts WHERE Role='Mechanic') THEN 'TRUE' ELSE 'FALSE' END "


    //String sql = "SELECT CASE WHEN EXISTS ( SELECT * FROM useraccounts WHERE Username='" + usn + "' AND Password='" + psw + "' AND Role=" + role + ") THEN 'TRUE' ELSE 'FALSE' END ";
    //SELECT CASE WHEN EXISTS ( SELECT * FROM useraccounts WHERE Username='John' AND Password='John123' AND Role='Mechanic') THEN 'TRUE' ELSE 'FALSE' END
        /* if(DB.DatabaseConnection.databaseReturnBool(sql)){
            //bring user to the page for their role
            return true;
        } */
/*
        loggedin = true;
        return false;
    } */
    public boolean login(String usn, String psw){
        //connect to database, and check if role, username and password apply to anyone, if not, return false;
        // IMPORTANT need to add implementation for bringing user to new role GUI page

        boolean pass = true;

        ArrayList<String> usnlist = DatabaseConnection.databaseReturnString(
                "SELECT * FROM useraccounts", "Username");
        ArrayList<String> pswlist = DatabaseConnection.databaseReturnString(
                "SELECT * FROM useraccounts", "Password");

        for (int i = 0; i < usnlist.size(); i++) {
            if(usn.equals(usnlist.get(i))) {
                System.out.println("usn success");
                if(psw.equals(pswlist.get(i))) { System.out.println("Actual success"); loggedin = true; return true; }
                else{ System.out.println("Incorrect password"); pass = false; }
            }
        }
        if(pass){ System.out.println("No account exists with this username"); }
        return false;
    }
    public void logout(){
        //logout of system, i.e. bring user to login page
        loggedin = false;
    }

}
