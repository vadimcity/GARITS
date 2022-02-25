public class Main {
    public static void main(String[] args) {
        test();

        //c.start();
    }

    public static void test(){
        Admin a = new Admin("Sampson", "password");
        Foreperson fo = new Foreperson("Sampson", "password");
        Franchisee fr = new Franchisee("Sampson", "password");
        Mechanic m = new Mechanic("Sampson", "password");
        Receptionist r = new Receptionist("Sampson", "password");
    }
}
