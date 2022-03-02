import DB.DatabaseConnection;

import java.util.ArrayList;

public class Receptionist extends User {
    StockControlSystem scs;


    public Receptionist(String un, String pw, StockControlSystem s){
        super("Receptionist", un,pw);
        scs = s;
    }


    public void produceInvoice(){
    }

    public void createCustomerRecord(){
    }
    public void takeInNewJobs(int CustomerID){
        int JobID = 2468;
        //for now use this random JobID number      but later, implement a method that reads from current job ids, and adds 1 to the greatest one to create a new ID
        // at 10,000, which this function should never reach, this function starts over again at 1

        ArrayList<Integer> alpending = DatabaseConnection.databaseReturnInt("SELECT * FROM pendingjoblist", "CustomerID");
        ArrayList<Integer> alactive = DatabaseConnection.databaseReturnInt("SELECT * FROM activejoblist", "CustomerID");
        alpending.addAll(alactive);

        JobID = IDSlotIn(alpending, 0);

        DatabaseConnection.databaseAffectTemplate("INSERT INTO pendingjoblist VALUES ('" + JobID + "', '" + CustomerID + "', 'NULL', 'NULL')");
    }
    private int IDSlotIn(ArrayList<Integer> al, int min){
        int x;
        int count = 0;
        boolean foundspace = false;
        //find a free slot
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.size(); i++) {
                if ((al.get(i)+1) == al.get(j)) { count++; }
            }
            if(count == 0){ return al.get(i)+1; }
        }
        //no slots, so add 1 to maximum
        x = IDmax(al,0) + 1;
        //if >= 10000, then we don't want an ID of that size. If there are both no slots AND max+1 >= 10000, then that means all IDs are bunched up near the top, leaving 0 free
        // if they were bunched at the top and bottom, even if al.get(al.size()) were about 3, 4 would be considered a free slot
        if(x >= 10000){ x = 0; }
        return x;
    }
    private int IDmax(ArrayList<Integer> al, int min){
        for (int i = 0; i < al.size(); i++) {
            if(al.get(i) > min){ min = al.get(i); }
        }
        return min;
    }

    public void monitorProgressJob(){           // " (including searching for a specific job by car number, name of the customer, etc.) "    from GARITS spec
    }
    public void searchJob(){
    }

    public void stockAlertPopup () { scs.stockAlertPopUp(); }

    public void orderParts () { scs.orderParts(); }
    public void sellSpareParts () { scs.sellSpareParts(); }
}

