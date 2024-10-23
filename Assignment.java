import java.util.Scanner;

class check {
    String password;
    Boolean login(){
        if(this.password=="Admin@123") return true;
        return false;
    }
}
/*
MOVIE TIMINGS
ALL MOVIE ARE OF LES THAN OR EQUAL TO 3 HRS
2 SCREENS ONLY 
7 AM (1 3)
11 AM (2 4)
3 PM (1 5)
7 PM (3 4)
11 PM (2 5)
 */

class Movie{
    String movies[] = new String[5];

}

class show extends Movie{
    String title;
    int availableSeats; // total 36 seats
    int duration; // mins

    show(){
        int j=4;
        while(j>=0){
            System.out.println(this.movies[4-j] + " " + " ");
        }
    }
}

public class Assignment {
    public static void main(String args[]){
        Boolean cond = true;
        while(cond){
            Boolean condUser=true, condAdmin=true;
            Scanner sc = new Scanner(System.in);
            System.out.println("Admin or User or Exit ? ");
            String identity = sc.nextLine();
            if(identity=="Admin"){ // if person is admin
                System.out.println("Enter password to login : ");
                check admin = new check();
                admin.password=sc.nextLine();
                Boolean x = admin.login();// if password then x=true
                if(x){
                    System.out.println("Logged in successfully !");
                    while(condAdmin){

                    }
                }
                else{ // try once again
                    System.out.println("Password Incorrect ! Try again. ");
                    System.out.println("Enter password to login : ");
                    admin.password=sc.nextLine();
                    x = admin.login(); // if password correct then x=true
                    if(x){
                        System.out.println("Logged in successfully !");
                        while(condAdmin){

                        }
                    }else{ // out of attempts
                        System.out.println("Password Incorrect ! Could not login !");
                    }
                }
            }else if(identity=="User"){ // if person is user
                while(condUser){

                }
            }else{
                cond=false;
            }
            sc.close();
        }
    }
}
