public class Receptionist extends User {
    int x = 0;
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
        DatabaseConnection.databaseAffectTemplate("INSERT INTO joblist VALUES ('" + JobID + "', '" + CustomerID + "', 'NULL', 'NULL')");
    }

    public void monitorProgressJob(){           // " (including searching for a specific job by car number, name of the customer, etc.) "    from GARITS spec
    }
    public void searchJob(){
    }

    public void stockAlertPopup () { scs.stockAlertPopUp(); }

    public void orderParts () { scs.orderParts(); }
    public void sellSpareParts () { scs.sellSpareParts(); }
}

