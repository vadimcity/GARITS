public class Mechanic extends User {
    int x = 0;

    public Mechanic(String un, String pw){
        super("Mechanic", un,pw);
    }
    public Mechanic(String role, String un, String pw){
        super(role, un,pw);
    }


    public void pickJob(){
    }
    public void changeDurationOfJob(){
    }

    public void fillJobSheet(){
    }
    public void printTheJobSheet(){
    }

    // public String getParts ? () {}

}
