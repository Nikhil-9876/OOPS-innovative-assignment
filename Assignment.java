
// Movie class inheriting from Show
// class Movie extends Show {
//     public Movie(String title, int duration, int availableSeats) {
//         super(title, duration, availableSeats);
//     }

//     @Override
//     public void showDetails() {
//         System.out.println("Movie: "+gettitle);
//         System.out.println("Time: "+gettime());
//         System.out.println("Duration: "+duration+" minutes");
//         System.out.println("Available seats: "+availableseats);
//         System.out.println("Seat matrix: \n");
//         printseatmatrix();
//     }
// }

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
    int Screen;
    int seatmatrix[][] = new int[7][7];


    show(String title,int duration,int availableseats,String time,int occupiedseats,int Screen,Scanner sc){
        this.title=title;
        this.duration=duration;
        this.time=time;
        this.availableseats=availableseats;
        this.Screen = Screen;
        if(occupiedseats!=0)System.out.println("Enter coordinates of reserved seats:");
        if(occupiedseats!=0){
            for(int i=0;i<occupiedseats;i++){
                System.out.println("enter row no. and column no. [7*7]:");
                int r=sc.nextInt();
                int c=sc.nextInt();
                sc.nextLine();
                this.seatmatrix[r-1][c-1]=1;
            }
        }
    } 

    // public String gettitle(){
    //     return this.title;
    // }
    // public String gettime(){
    //     return this.time;
    // }
    // int getavailableseats(){
    //     return this.availableseats;
    // }


    void printseatmatrix(){
        System.out.println("1=Reserved seat and 0=available seat");
        System.out.println( " ___________ \n"); // seat matrix screen
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
        System.out.println("Screen : "+Screen);
        System.out.println("Available seats: "+availableseats);
        System.out.println("Seat matrix: \n");
        printseatmatrix();
    }

}

class Theatre{
    ArrayList<show> shows;

    Theatre(){
        this.shows=new ArrayList<>();
    }

    void addshow(show s){
        shows.add(s);
    }

    void printallshows(){
        for(int i=0;i<shows.size();i++){
            System.out.println("Show "+(i+1)+":");
            shows.get(i).displayshow();
        }
    }

    void printshowsbyname(String name){
        int c=0;
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).title.equals(name)){
                shows.get(i).displayshow();
                c++;
            }
        }
        if(c==0) System.out.println("No shows for the movie you a looking for");
    }

    void printshowsbyScreen(int Screen){
        int c=0;
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).Screen==Screen){
                shows.get(i).displayshow();
                c++;
            }
        }
        if(c==0) System.out.println("No shows for the movie you a looking for");
    }

    void printshowsbytime(String time){
        int c=0;
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).time.equals(time)){
                shows.get(i).displayshow();
                c++;
            }
        }
        if(c==0) System.out.println("No shows for the timespan you a looking for");
    }

    void change(String name, String time, int screen){
        Scanner sc = new Scanner(System.in);
        int i=0;
        for(;i<shows.size();i++){
            if(shows.get(i).title.equals(name) && shows.get(i).time.equals(time) && shows.get(i).Screen==screen){
                break;
            }
        }
        System.out.println("Enter new time of the movie : ");
        shows.get(i).time = sc.nextLine();
        System.out.println("Enter new Screen of the movie : ");
        shows.get(i).Screen = sc.nextInt();
    }

}


public class Assignment {
    public static void main(String args[]){
        Theatre cinema = new Theatre();
        Scanner sc = new Scanner(System.in);
        Boolean cond = true;
        String identity;
        while(cond){
            Boolean condUser=true, condAdmin=true;
            System.out.println("Admin or User or Exit ? ");
            identity = sc.next();
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
                    System.out.println("Add movie, delete movie, display movie, Change movie, exit ? ");//choose the operation to do
                    choice=sc.next();
                    if(choice.equals("add")){
                        String title,time;
                        int duration,availableSeats,occupiedseats, Screen;
                        sc.nextLine();
                        System.out.println("Enter title of the movie : ");
                        title = sc.nextLine();
                        System.out.println("Enter time of the movie : ");
                        time = sc.nextLine();
                        System.out.println("Enter duration of the movie : ");
                        duration=sc.nextInt();
                        System.out.println("Enter availableseats of the movie : ");
                        availableSeats=sc.nextInt();
                        System.out.println("Enter Screen of the movie : ");
                        Screen=sc.nextInt();
                        occupiedseats=49-availableSeats;
                        show s = new show(title,duration,availableSeats,time,occupiedseats,Screen,sc);
                        cinema.addshow(s);
                    }else if(choice.equals("delete")){
                        String title,time;
                        sc.nextLine();
                        System.out.println("Enter title of the movie : ");//method to delete movie in cinema
                        title = sc.nextLine();
                        System.out.println("Enter time of the movie : ");
                        time = sc.nextLine();
                        for(int i=0;i<cinema.shows.size();i++){
                            if(cinema.shows.get(i).time.equals(time) && cinema.shows.get(i).title.equals(title)){
                                cinema.shows.remove(i);
                            }
                        }
                        // count of movire decrease krvanu baki
                    }else if(choice.equals("display")){
                        for(int i=0;i<cinema.shows.size();i++){
                            System.out.println("----------------------");
                            show s=cinema.shows.get(i);// method to be declared inside cinema class
                            s.displayshow();
                        }
                    }else if(choice.equals("change")){
                        System.out.println("Enter movie name : ");
                        String chngName = sc.nextLine();
                        System.out.println("Enter movie time : ");
                        String chngTime = sc.nextLine();
                        System.out.println("Enter movie name : ");
                        int chngScreen = sc.nextInt();
                        cinema.change(chngName, chngTime, chngScreen);
                    }else{
                        condAdmin=false;
                    }
                }
            }else if(identity.equals("user")){ // if person is user
                System.out.println("user");
                while(condUser){
                    
                }
            }else{
                cond=false;
            }
        }
        
        sc.close();
    }
}