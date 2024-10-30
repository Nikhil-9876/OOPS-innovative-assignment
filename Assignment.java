
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


class show{
    String title;
    int duration;
    int availableseats;
    String time;
    int Screen;
    int seatmatrix[][] = new int[7][7];

    ArrayList<String> mName = new ArrayList<String>();
    ArrayList<String> mTime = new ArrayList<String>();
    ArrayList<String> uName = new ArrayList<String>();
    ArrayList<String> uNum = new ArrayList<String>();
    ArrayList<Integer> mTotalSeats = new ArrayList<Integer>();
    ArrayList<Integer> mScreen = new ArrayList<Integer>();
    ArrayList<ArrayList<Integer>> mRows = new ArrayList<ArrayList<Integer>>();
    ArrayList<ArrayList<Integer>> mCols = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> payment = new ArrayList<Integer>();

    show(String title,int duration,int availableseats,String time,int occupiedseats,int Screen,Scanner sc){
        this.title=title;
        this.duration=duration;
        this.time=time;
        this.availableseats=availableseats;
        this.Screen = Screen;
        if(occupiedseats!=0)System.out.println("Enter coordinates of not available seats : ");
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

    void BookSeats(int seats, String n){
        Scanner sc = new Scanner(System.in);
        printseatmatrix();
        ArrayList<Integer> R = new ArrayList<Integer>();
        ArrayList<Integer> C = new ArrayList<Integer>();
        while(seats>0){
            System.out.println("Enter Row of the seat you want to choose : ");
            int row = sc.nextInt();
            System.out.println("Enter Column of the seat you want to choose : ");
            int column = sc.nextInt();
            if(seatmatrix[row-1][column-1]==1){
                System.out.println("The seat is already Booked.");
                System.out.println("Book another seat !");
            }else{
                availableseats-=1;
                seatmatrix[row-1][column-1]=1;
                seats-=1;
                R.add(row);
                C.add(column);
            }
        }   
        mRows.add(R);
        mCols.add(C);
        System.out.println("Booking Successfull !");
    }

    void generatingBillForUser(String hisName){
        int i=0;
        for(;i<uName.size();i++){
            if(uName.get(i).equals(hisName)){
                System.out.println("Name : " + uName.get(i));
                System.out.println("Number : " + uNum.get(i));
                System.out.println("Movie Name : " + title);
                System.out.println("Movie Time : " + time);
                System.out.println("Screen of the show : " + Screen);
                System.out.println("Total Seats Booked : "+mTotalSeats.get(i));
                System.out.println("Seats : ");
                for(int j=0;j<mRows.get(i).size();j++){
                    System.out.println("row : " + mRows.get(i).get(j) +", Column : " + mCols.get(i).get(j));
                }
                System.out.println("Payment: Rs" + payment.get(i));
                System.out.println("Pay on this UPI id: 98XXXXXX21@hdfcbank");
            }
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

    int printshowsbyname(String name){
        int c=0;
        System.out.println("These are the available showtimes:");
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).title.equals(name)){
                System.out.println("Time:"+shows.get(i).time);
                c++;
            }
        }
        if(c==0) {
            System.out.println("No shows for the movie you a looking for");
            return 0;
        }else{
            return 1;
        }
    }
    
    void change(String name, String time, int screen){
        Scanner sc = new Scanner(System.in);
        int i=0,f=0;
        for(;i<shows.size();i++){
            if(shows.get(i).title.equals(name) && shows.get(i).time.equals(time) && shows.get(i).Screen==screen){
                f=1;
                break;
            }
        }
        if(f==0){
            System.out.println("show not found!");
            return;
        }
        System.out.println("Enter new time of the movie : ");
        shows.get(i).time = sc.nextLine();
        System.out.println("Enter new Screen of the movie : ");
        shows.get(i).Screen = sc.nextInt();
    }

    void movieList(){
        ArrayList<String> m = new ArrayList<String>();
        for(int i=0;i<shows.size();i++){
            Boolean x=false;
            for(int j=0;j<m.size();j++){
                if(shows.get(i).title.equals(m.get(j))){
                    x=true;
                    break;
                }
            }
            if(!x){
                m.add(shows.get(i).title);
            }
        }
        System.out.println("Movie list : ");
        for(int i=0;i<m.size();i++){
            System.out.println((i+1)+". "+m.get(i));
        }
        System.out.println();
    }

    int Booking(String MovieName, String Time){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).title.equals(MovieName) && shows.get(i).time.equals(Time)){
                if(shows.get(i).availableseats == 0){
                    System.out.println("Sorry, No seats available");
                    return 0;
                }else{
                    System.out.println("How many Seats do you want ? ");
                    int seats = sc.nextInt();
                    if(seats > shows.get(i).availableseats){
                        System.out.println("Sorry only "+shows.get(i).availableseats+" seats are available !");
                        return 0;
                    }else{
                        sc.nextLine();
                        System.out.println("Enter your name : ");
                        String userName=sc.nextLine();
                        shows.get(i).uName.add(userName);
                        System.out.println("Enter your phone number : ");
                        String userNumber=sc.nextLine();
                        shows.get(i).uNum.add(userNumber);
                        shows.get(i).mName.add(shows.get(i).title);
                        shows.get(i).mTime.add(shows.get(i).time);
                        shows.get(i).mTotalSeats.add(seats);
                        shows.get(i).mScreen.add(shows.get(i).Screen);
                        shows.get(i).BookSeats(seats, userName);
                        shows.get(i).payment.add(seats*300);
                        shows.get(i).generatingBillForUser(userName);
                        return 2;
                    }
                }
            }
        }
        System.out.println("Entered Movie name or Time is Wrong.");
        return 1;
    }

    void generatingBillForAdmin() {
        for (int i = 0; i < shows.size(); i++) {
            for (int j = 0; j < shows.get(i).uName.size(); j++) {
                System.out.println("User's name: " + shows.get(i).uName.get(j));
                System.out.println("User's number: " + shows.get(i).uNum.get(j));
                System.out.println("User's Movie: " + shows.get(i).mName.get(j));
                System.out.println("User's Time of movie: " + shows.get(i).mTime.get(j));
                System.out.println("User's Booked total seats: " + shows.get(i).mTotalSeats.get(j));
                System.out.println("User's Screen: " + shows.get(i).mScreen.get(j));
                for (int z = 0; z < shows.get(i).mRows.get(j).size(); z++) {
                    System.out.println("Row: " + shows.get(i).mRows.get(j).get(z) + ", Column: " + shows.get(i).mCols.get(j).get(z));
                }
                System.out.println("User's Payment: Rs" + shows.get(i).payment.get(j));
            }
            System.out.println();
        }
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
                System.out.println("Enter password to login : ");
                check admin = new check();
                admin.password=sc.next();
                Boolean x = admin.login();// if password then x=true
                if(x){
                    System.out.println("Logged in successfully !");
                }
                else{ // try once again
                    condAdmin=false;
                    System.out.println("Password Incorrect ! Try again. ");
                    System.out.println("Enter password to login : ");
                    admin.password=sc.next();
                    x = admin.login(); // if password correct then x=true
                    if(x){
                        System.out.println("Logged in successfully !");
                        condAdmin=true;
                    }else{ // out of attempts
                        System.out.println("Password Incorrect ! Could not login !");
                    }
                }
                
                while(condAdmin){
                    String choice;
                    sc.nextLine();
                    System.out.println("Add movie, delete movie, display movie, Change movie, exit ? "); // choose the operation to do
                    choice=sc.nextLine();
                    if(choice.equals("add")){
                        String title,time;
                        int duration,availableSeats,occupiedseats, Screen;
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
                        int f=0;
                        for(int i=0;i<cinema.shows.size();i++){
                            if(cinema.shows.get(i).time.equals(time) && cinema.shows.get(i).title.equals(title)){
                                cinema.shows.remove(i);
                                f=1;
                            }
                        }
                        if(f==0) System.out.println("Show not found!");
                        // count of movire decrease krvanu baki
                    }else if(choice.equals("display")){
                        for(int i=0;i<cinema.shows.size();i++){
                            System.out.println("----------------------");
                            show s=cinema.shows.get(i);// method to be declared inside cinema class
                            s.displayshow();
                            System.out.println();
                        }
                        cinema.generatingBillForAdmin();
                    }else if(choice.equals("change")){
                        System.out.println("Enter movie name : ");
                        String chngName = sc.nextLine();
                        System.out.println("Enter movie time : ");
                        String chngTime = sc.nextLine();
                        System.out.println("Enter movie screen : ");
                        int chngScreen = sc.nextInt();
                        cinema.change(chngName, chngTime, chngScreen);
                    }else{
                        condAdmin=false;
                    }
                }
            }else if(identity.equals("user")){ // if person is user
                int f=0;
                while(condUser){
                    cinema.movieList();
                    if(f==0) sc.nextLine();
                    f++;
                    System.out.println("Choose a movie you want to watch : ");
                    String choiceMovie = sc.nextLine();
                    int x=cinema.printshowsbyname(choiceMovie);
                    if(x==0) continue;
                    System.out.println("Enter Time of the show : ");
                    String choiceTime = sc.nextLine();
                    int booked  = cinema.Booking(choiceMovie, choiceTime);
                    if(booked==1){
                        System.out.println("Try Again ");
                    }else{
                        condUser=false;
                    }
                }
            }else{
                cond=false;
            }
        }
        
        sc.close();
    }
}