abstract public class User {
    String role;
    String username;
    String password;
    boolean loggedin;

    public User(String r, String un, String pw){
        role = r;
        username = un;
        password = pw;
        loggedin = false;
    }

    public boolean login(String role, String usn, String psw){
        //connect to database, and check if role, username and password apply to anyone, if not, return false;
        loggedin = true;
        return false;
    }
    public void logout(){
        //logout of system
        loggedin = false;
    }

}
