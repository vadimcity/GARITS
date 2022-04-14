package System;

import DB.BackupUI;
import DB.DatabaseConnection;
import GUI.*;
import Roles.*;

import java.util.ArrayList;

public class Main {
    final static String[] roles = {"Admin", "Foreperson", "Franchisee", "Mechanic", "Receptionist"};
    private static String role;
    private static String mechun;
    private static StockControlSystem scs;
    private static String backpage = "";

    public static void setRole(String rl){ role = rl; }
    public static String getRole(){ return role; }
    public static boolean checkRole(String role){
        for (int i = 0; i < roles.length; i++) {
            if(role == roles[i]){ return true; }
        }
        return false;
    }

    public static void setMechanicUsername(String un){ mechun = un; }
    public static String getMechanicUsername(){ return mechun; }

    public static String[] convertToColumns(String[][] s){
        String[] columns = new String[s[0].length];
        for (int i = 0; i < s[0].length; i++){  columns[i] = s[0][i]; }
        return columns;
    }
    //columns holds names of columns, from the first row            s.length = rows, s[0].length = columns
    public static String[][] convertToPureData(String[][] s){
        String[][] data = new String[s.length-1][s[0].length];
        for (int i = 1; i < s.length; i++){
            for (int j = 0; j < s[0].length; j++){  data[i-1][j] = s[i][j];  }
        }
        return data;
    }

    public static int IDSlotIn(ArrayList<Integer> al, int min){
        int x;
        int count = 0;
        boolean foundspace = false;
        //find a free slot
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.size(); j++) {
                if ((al.get(i)+1) == al.get(j)) { count++; }
            }
            if(count == 0){ return al.get(i)+1; }
            count = 0;
        }
        //no slots, so add 1 to maximum
        x = IDmax(al,0) + 1;
        //if >= 10000, then we don't want an ID of that size. If there are both no slots AND max+1 >= 10000, then that means all IDs are bunched up near the top, leaving 0 free
        // if they were bunched at the top and bottom, even if al.get(al.size()) were about 3, 4 would be considered a free slot
        if(x >= 10000){ x = 0; }
        return x;
    }
    public static int IDmax(ArrayList<Integer> al, int min){
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i) > min){ min = al.get(i); }
        }
        return min;
    }

    public static void updateMain(String newpage){
        backpage = newpage;
    }
    public static void backPage(){
        if(backpage.equals("AdminPanel")){ AdminPanel a = new AdminPanel(); }
        else if(backpage.equals("CarPanel")){ CarPanel c = new CarPanel(); }
        else if(backpage.equals("CreateAlterAccountHolder")){ CreateAlterAccountHolder c = new CreateAlterAccountHolder(); }
        else if(backpage.equals("FillJobSheet")){ FillJobSheet f = new FillJobSheet(); }
        else if(backpage.equals("ForepersonPanel")){ ForepersonPanel f = new ForepersonPanel(); }
        else if(backpage.equals("FranchiseePanel")){ FranchiseePanel f = new FranchiseePanel(); }
        else if(backpage.equals("Login")){ Login l = new Login(); }
        else if(backpage.equals("MainPanel")){ MainPanel m = new MainPanel(); }
        else if(backpage.equals("MechanicPanel")){ MechanicPanel m = new MechanicPanel(); }
        else if(backpage.equals("OrderParts")){ OrderParts o = new OrderParts(); }
        else if(backpage.equals("PendingJobPanel")){ PendingJobPanel p = new PendingJobPanel(); }
        else if(backpage.equals("ReceptionistPanel")){ ReceptionistPanel r = new ReceptionistPanel(); }
        else if(backpage.equals("ReceptionistStockControl")){ ReceptionistStockControl r = new ReceptionistStockControl(); }
        else if(backpage.equals("SearchJob")){ SearchJob s = new SearchJob(); }
        else{
            System.out.println("Pagename not correct, page = " + backpage);
        }
        System.out.println(backpage);
    }

    public static StockControlSystem getSCS(){ return scs; }

    public static void newpanel(){
        String role = getRole();
        if (role.equals("Admin")){
            AdminPanel ap = new AdminPanel();
        }else if (role == "Mechanic"){
            MechanicPanel mp = new MechanicPanel();
        }
    }

    public static void test(Admin ad){

        Admin a = ad;
        Foreperson fo = new Foreperson("Sampson", "password", scs);
        fo.allocateMechanic(9876, "John", "01:30:00");
        Franchisee fr = new Franchisee("Sampson","password", scs);
        Mechanic m = new Mechanic("Sampson", "password", scs);
        Receptionist r = new Receptionist("Sampson", "password", scs);

        /* a.createAccount("John","John123","Roles.Mechanic");
        a.createAccount("JSally","John123","Roles.Mechanic");
        a.deleteAccount("John"); */

        m.changeDurationOfJob(9543, 15, 36, 45);

        fr.setDiscountPlan(1234,"flexible");
    }

    static boolean checkUsername(String un){
        /* String sql = "SELECT CASE WHEN EXISTS ( SELECT * FROM useraccounts WHERE Username='" + un + "') THEN 'TRUE' ELSE 'FALSE' END ";
        if(DB.DatabaseConnection.databaseReturnBool(sql)){ return true; } */
        return false;
    }


    static void emptyDatabase(){
        DatabaseConnection.databaseAffectTemplate("TRUNCATE TABLE useraccounts;");
        DatabaseConnection.databaseAffectTemplate("TRUNCATE TABLE customermemberlist;");
        DatabaseConnection.databaseAffectTemplate("TRUNCATE TABLE pendingjoblist;");
        DatabaseConnection.databaseAffectTemplate("TRUNCATE TABLE activejoblist;");
        DatabaseConnection.databaseAffectTemplate("TRUNCATE TABLE spareparts;");
    }

    private static void fillDatabase(Admin a){
        fillUserAccounts(a);
        fillCustomerMemberList();
        fillPendingJobList();
        fillActiveJobList();
        fillSpareParts();
    }
    private static void fillUserAccounts(Admin a){      //username, password, role
        a.createAccount("John","John123","Mechanic");
        a.createAccount("Joan","Joan123","Mechanic");
        a.createAccount("Jane","Jane123","Receptionist");
        a.createAccount("Robert","Rob123","Foreperson");
        a.createAccount("James","Jim123","Franchisee");
        a.createAccount("Sampson","SonSam","Admin");
    }
    private static void fillCustomerMemberList(){       //ID, firstname, surname, discountplan
        DatabaseConnection.databaseAffectTemplate("INSERT INTO customermemberlist VALUES ('" + "1234" + "', '" + "Jack" + "', '" + "Johnson" + "', '" + "fixed" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO customermemberlist VALUES ('" + "1345" + "', '" + "Janet" + "', '" + "Jerome" + "', '" + "variable" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO customermemberlist VALUES ('" + "1456" + "', '" + "Janine" + "', '" + "Jansen" + "', '" + "flexible" + "')");
    }
    private static void fillPendingJobList(){           //jobID, customerID, details                            allow for duration and mechanic to be null
        DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + "9876" + "', '" + "1234" + "', '" + "NULL" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + "9765" + "', '" + "1345" + "', '" + "NULL" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + "9654" + "', '" + "1456" + "', '" + "NULL" + "')");
    }
    private static void fillActiveJobList(){            //jobID, customerID, duration, mechanic, details         allow for duration and mechanic to be null
        DatabaseConnection.databaseAffectTemplate("INSERT INTO activejoblist VALUES ('" + "9543" + "', '" + "1567" + "', '" + "2:05" + "', '" + "John" + "', '" + "NULL" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO activejoblist VALUES ('" + "9432" + "', '" + "1678" + "', '" + "2:05" + "', '" + "Joan" + "', '" + "NULL" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO activejoblist VALUES ('" + "9321" + "', '" + "1789" + "', '" + "2:05" + "', '" + "John" + "', '" + "NULL" + "')");
    }
    private static void fillSpareParts(){               //type, amount
        DatabaseConnection.databaseAffectTemplate("INSERT INTO spareparts VALUES ('" + "Roadwheel" + "', '" + "5" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO spareparts VALUES ('" + "Steeringwheel" + "', '" + "5" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO spareparts VALUES ('" + "Axel" + "', '" + "5" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO spareparts VALUES ('" + "Window" + "', '" + "5" + "')");
        DatabaseConnection.databaseAffectTemplate("INSERT INTO spareparts VALUES ('" + "Door" + "', '" + "5" + "')");
    }

    public static void printActiveJobList() {
        ArrayList<Integer> al1 = DatabaseConnection.databaseReturnInt(
                "SELECT * FROM activejoblist", "JobID");
        ArrayList<Integer> al2 = DatabaseConnection.databaseReturnInt(
                "SELECT * FROM activejoblist", "CustomerID");
        ArrayList<String> al3 = DatabaseConnection.databaseReturnString(
                "SELECT * FROM activejoblist", "Duration");
        ArrayList<String> al4 = DatabaseConnection.databaseReturnString(
                "SELECT * FROM activejoblist", "Mechanic");
        ArrayList<String> al5 = DatabaseConnection.databaseReturnString(
                "SELECT * FROM activejoblist", "Details");

        for (int i = 0; i < al1.size(); i++) {
            System.out.print(al1.get(i));
            System.out.print("    ");
            System.out.print(al2.get(i));
            System.out.print("    ");
            System.out.print(al3.get(i));
            System.out.print("    ");
            System.out.print(al4.get(i));
            System.out.print("    ");
            System.out.println(al5.get(i));
        }
    }

    public static void dealWithDatabase() {
        Admin a = new Admin("Sampson", "SonSam");
        //ArrayList<String> al = new ArrayList<String>();

        //emptyDatabase();
        fillDatabase(a);

        //DB.DatabaseConnection.databaseReturnBool();                          //COME BACK TO
        //DB.DatabaseConnection.databaseAffectTemplate("SELECT * FROM useraccounts WHERE Username='James'");
        //DB.DatabaseConnection.databaseReturnString(
        //        "SELECT * FROM useraccounts WHERE Username='James'");

        /* ArrayList<String> als = DB.DatabaseConnection.databaseReturnString(
                "SELECT * FROM useraccounts", "Username");
        ArrayList<Integer> ali = DB.DatabaseConnection.databaseReturnInt(
                "SELECT * FROM activejoblist", "JobID");
        String str = null;
        System.out.println(str); */

        printActiveJobList();

        if(a.login("John", "John123")){
            System.out.println("System.Main login success");
        }

        //test(a);
    }

    //actual intended functionality
    public static void main(String[] args) {
        setRole("Admin");
        scs = new StockControlSystem(100);

        //MainPanel mp = new MainPanel();
        Login myLogin = new Login ();
//        dealWithDatabase();
//          Login myLogin = new Login ();
//          ReceptionistPanel myrp = new ReceptionistPanel();
//        AdminPanel AP = new AdminPanel(null);

        //BackupUI backupUI = new BackupUI ();
    }
}
