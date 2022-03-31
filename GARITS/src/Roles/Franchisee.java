package Roles;

import DB.DatabaseConnection;
import System.*;

public class Franchisee extends Foreperson {
    int x = 0;

    public Franchisee(String un, String pw, StockControlSystem scs){
        super("Roles.Franchisee", un, pw, scs);
    }


    public void setDiscountPlan(int CustID, String dp){     //may be subsumed by createAccountHolder and alterDiscountPlan
                                                            // as you only need to set it once, when creating the account, and altering it is a similar process
        //can be fixed, variable or flexible
        DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Discountplan='" + dp + "' WHERE ID='" + CustID + "'");
    }
    public void alterDiscountPlan(int CustID, String dp){
        //can be fixed, variable or flexible
        DatabaseConnection.databaseAffectTemplate("UPDATE customermemberlist SET Discountplan='" + dp + "' WHERE ID='" + CustID + "'");
    }

    public void createAccountHolder(String date, String name, String address, String postcode, int telephoneNumber, String email,
                                    String regno, String make, String model, String eng_serial, String chassisNumber, String colour,
                                    String discountplan) {
        //create customer account,
        // line 1 of parameters contains account details
        // line 2 contains the details of the first car on that account (must at least have 1)
        // line 3 contains the discountplan

        //add account with line 1 and line 3 details to the customeraccount table
        // also add "no_of_cars = 1" to the customeraccount table
        // add car with line 2 details and a customerID from this customer
    }
    public void payLateOption(boolean plo){ // customer account holders can have a pay late option. Set it to true or false
        // update pay late option to plo
    }

    public void alterAccountHolder(){ // alter customer account details
    }

}

