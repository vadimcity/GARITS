package UserSession;

public abstract class LoginSession {
    String role;
    String username;
    String password;
    boolean loggedin;

    public LoginSession(String r, String un, String pw){
        role = r;
        username = un;
        password = pw;
        loggedin = false;
    }

    /*protected*/ public boolean login(String role, String usn, String psw){
        String sql = "SELECT CASE WHEN EXISTS ( SELECT * FROM useraccounts WHERE Username='" + usn + "' AND Password='" + psw + "' AND Role=" + role + ") THEN 'TRUE' ELSE 'FALSE' END ";
        /* if(DatabaseConnection.databaseReturnBool(sql)){
            //bring user to the page for their role
            return true;
        } */

        loggedin = true;
        return false;
    }
    public void logout(){
        //logout of system, i.e. bring user to login page
        loggedin = false;
    }

}
