package cineplexAdmin;

abstract class admin{
    String password;
    abstract Boolean login();
}
public class check extends admin {
    public String password;
    public Boolean login() {
        if(this.password.equals("admin@123")) return true;
        return false;
    }
}