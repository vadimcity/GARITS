package System;

import DB.DatabaseConnection;
import GUI.*;
import Roles.*;

import java.util.ArrayList;

public class Main {
    final static String[] roles = {"Roles.Admin", "Roles.Foreperson", "Roles.Franchisee", "Roles.Mechanic", "Roles.Receptionist"};
    private static String role;

    public static void setRole(String rl){ role = rl; }
    public static String getRole(){ return role; }

    public static void test(Admin ad){
        StockControlSystem scs = new StockControlSystem(100);

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

        fr.setDiscountPlan("flexible", 1234);
    }

    public static boolean checkRole(String role){
        for (int i = 0; i < roles.length; i++) {
            if(role == roles[i]){ return true; }
        }
        return false;
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
        dealWithDatabase();
        Login myLogin = new Login (null);
    }
}
