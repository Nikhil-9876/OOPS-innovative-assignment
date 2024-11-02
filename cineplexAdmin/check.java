package cineplexAdmin;

public class check {
    public String password;
    public Boolean login() {
        if(this.password.equals("admin@123")) return true;
        return false;
    }
}