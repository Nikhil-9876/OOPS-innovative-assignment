import java.util.ArrayList;
import java.util.Scanner;

class check {
    String password;
    Boolean login(){
        if(this.password.equals("admin@123")) return true;
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

// class Movie{
//     String movies[] = new String[5];

// }

// class show extends Movie{
//     String title;
//     int availableSeats; // total 36 seats
//     int duration; // mins
//     String time;

//     show(){
//         int j=4;
//         while(j>=0){
//             System.out.println(this.movies[4-j] + " " + " ");
//         }
//     }
// }

class show{
    String title;
    int duration;
    int availableseats;
    String time;
    int seatmatrix[][] = new int[7][7];


    show(String title,int duration,int availableseats,String time,int occupiedseats){
        this.title=title;
        this.duration=duration;
        this.time=time;
        this.availableseats=availableseats;
        if(occupiedseats!=0)System.out.println("Enter coordinates of reserved seats:");
        Scanner sc=new Scanner(System.in);
        if(occupiedseats!=0){
            for(int i=0;i<occupiedseats;i++){
                System.out.println("enter row no. and column no. [7*7]:");
                int r=sc.nextInt();
                int c=sc.nextInt();
                sc.nextLine();
                seatmatrix[r-1][c-1]=1;
            }
        }
        sc.close();
    } 

    String gettitle(){
        return this.title;
    }
    String gettime(){
        return this.time;
    }

    void printseatmatrix(){
        System.out.println("1=Reserved seat and 0=available seat");
        System.out.println( " ___________ \n");
        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                System.out.print(seatmatrix[i][j]+" ");
            }   
            System.out.println();
            System.out.println();
        }
    }

    void displayshow(){
        System.out.println("Movie: "+title);
        System.out.println("Time: "+time);
        System.out.println("Duration: "+duration+" minutes");
        System.out.println("Available seats: "+availableseats);
        System.out.println("Seat matrix: \n");
        printseatmatrix();
    }

}



public class Assignment {
    public static void main(String args[]){
        ArrayList <show> shows=new ArrayList<>();//to be declared in cinema
        Scanner sc = new Scanner(System.in);
        Boolean cond = true;
        String identity;
        while(cond){
            Boolean condUser=true, condAdmin=true;
            System.out.println("Admin or User or Exit ? ");
            identity = sc.nextLine();
            //an input buffer error is here 

















            // System.out.println(identity);
            if(identity.equals("admin")){ // if person is admin
                // System.out.println("Enter password to login : ");
                // check admin = new check();
                // admin.password=sc.nextLine();
                // Boolean x = admin.login();// if password then x=true
                // if(x){
                //     System.out.println("Logged in successfully !");
                // }
                // else{ // try once again
                //     condAdmin=false;
                //     System.out.println("Password Incorrect ! Try again. ");
                //     System.out.println("Enter password to login : ");
                //     admin.password=sc.nextLine();
                //     x = admin.login(); // if password correct then x=true
                //     if(x){
                //         System.out.println("Logged in successfully !");
                //         condAdmin=true;
                //     }else{ // out of attempts
                //         System.out.println("Password Incorrect ! Could not login !");
                //     }
                // }

                while(condAdmin){
                    String choice;
                    System.out.println("Add movie, delete movie, display movie, exit ? ");//choose the operation to do
                    choice=sc.nextLine();
                    if(choice.equals("add")){
                        String title,time;
                        int duration,availableSeats,occupiedseats;
                        System.out.println("Enter title of the movie : ");
                        title = sc.nextLine();
                        System.out.println("Enter time of the movie : ");
                        time = sc.nextLine();
                        System.out.println("Enter duration of the movie : ");
                        duration=sc.nextInt();
                        System.out.println("Enter availableseats of the movie : ");
                        availableSeats=sc.nextInt();
                        occupiedseats=49-availableSeats;
                        show s = new show(title,duration,availableSeats,time,occupiedseats);
                        // s.displayshow();
                        shows.add(s);
                    }else if(choice.equals("delete")){
                        String title,time;
                        System.out.println("Enter title of the movie : ");//method to delete movie in cinema
                        title = sc.nextLine();
                        System.out.println("Enter time of the movie : ");
                        time = sc.nextLine();
                        for(int i=0;i<shows.size();i++){
                            String  showtitle = shows.get(i).gettitle();
                            String  showtime = shows.get(i).gettime();
                            if(showtime==time && showtitle==title){
                                shows.remove(i);
                            }
                        }
                    }else if(choice.equals("display")){
                        for(int i=0;i<shows.size();i++){
                            System.out.println("----------------------");
                            show s=shows.get(i);// method to be declared inside cinema class
                            s.displayshow();
                        }
                    }else{
                        condAdmin=false;
                    }
                }
            }else if(identity.equals("user")){ // if person is user
                System.out.println("user");
                // while(condUser){
                // }
            }else{
                cond=false;
            }
        }
        
        sc.close();
    }
}
