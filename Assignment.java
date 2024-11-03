
import java.util.*;

import cineplexShows.show;
import cineplexTheatre.Theatre;
import cineplexAdmin.check;

import java.io.*;
import java.util.Scanner;

public class Assignment {
    public static void main(String args[]){
        try {
            PrintWriter out=new PrintWriter("users.csv");
            out.printf("%s,%s,%s,%s,%s,%s,%s\n","Movie_Name","Movie_Time","User_Name","User_Number","Seats","Screen","payment");        
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } 

        Theatre cinema = new Theatre();
        Scanner sc = new Scanner(System.in);
        Boolean cond = true;
        String identity;
        while(cond){
            Boolean condUser=true, condAdmin=true;
            System.out.println("Admin or User or Exit ? ");
            identity = sc.next();
            if(identity.equals("admin")) {
                System.out.println("Enter password to login: ");
                check admin = new check();
                admin.password = sc.next();
                boolean x = admin.login();// if password then x=true
                if(x){
                    System.out.println();
                    System.out.println("Logged in successfully !");
                }
                else{ // try once again
                    condAdmin=false;
                    System.out.println();
                    System.out.println("Password Incorrect ! Try again. ");
                    System.out.println("Enter password to login : ");
                    admin.password=sc.next();
                    x = admin.login(); // if password correct then x=true
                    if(x){
                        System.out.println();
                        System.out.println("Logged in successfully !");
                        condAdmin=true;
                    }else{ // out of attempts
                        System.out.println();
                        System.out.println("Password Incorrect ! Could not login !");
                        System.out.println();
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
                        System.out.println();
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
                        // count of movie decrease krvanu baki
                    }else if(choice.equals("display")){
                        System.out.println();
                        System.out.println("Display show Bookings or shows ? ");
                        String choiceD = sc.nextLine();
                        if(choiceD.equals("bookings")){
                            System.out.println();
                            cinema.generatingBillForAdmin();
                        }else{
                            System.out.println("Display all shows/ shows by movie name/ by screen/ by time ? ");
                            String choiceOfDisplay = sc.nextLine();
                            if(choiceOfDisplay.equals("all")){
                                cinema.printallshows();
                            }else if(choiceOfDisplay.equals("name")){
                                System.out.println("Enter movie name : ");
                                String displayName = sc.nextLine();
                                cinema.printshowsbyName(displayName);
                            }else if(choiceOfDisplay.equals("screen")){
                                System.out.println("Enter Screen nnumber : ");
                                int displayScreen = sc.nextInt();
                                cinema.printshows(displayScreen);
                            }else if(choiceOfDisplay.equals("time")){
                                System.out.println("Enter movie name : ");
                                String displayTime = sc.nextLine();
                                cinema.printshows(displayTime);
                            }
                        }
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
    }
}