import DB.DatabaseConnection;

public class Franchisee extends Foreperson {
    int x = 0;

    public Franchisee(String un, String pw, StockControlSystem scs){
        super("Franchisee", un, pw, scs);
    }


    public void setDiscountPlan(String dp, int CustID){
        //can be fixed, variable or flexible
        DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Discountplan='" + dp + "' WHERE ID='" + CustID + "'");
    }
    public void alterDiscountPlan(){
    }

    public void createAccountHolder(){
    }
    public void payLateOption(){
    }

    public void alterAccountHolder(){
    }

}

