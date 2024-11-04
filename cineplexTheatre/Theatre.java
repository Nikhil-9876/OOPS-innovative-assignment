package cineplexTheatre;

import cineplexShows.show;
import cineplexUser.user;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Theatre{
    public ArrayList<show> shows;

    public Theatre(){
        this.shows=new ArrayList<>();
    }

    public void addshow(show s){
        shows.add(s);
    }

    public void printallshows(){
        int count=0;
        for(int i=0;i<shows.size();i++){
            count++;
            System.out.println("Show "+(i+1)+":");
            shows.get(i).displayshow();
        }
        if(count==0){
            System.out.println("No shows available !");
        }
    }

    public void printshowsbyName(String name){
        int c=0;
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).title.equals(name)){
                shows.get(i).displayshow();
                c++;
            }
        }
        if(c==0) System.out.println("No shows for the movie you are looking for");
    }

    public int printshowsbyname(String name){
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
    
    public void printshows(int Screen){
        int c=0;
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).Screen==Screen){
                shows.get(i).displayshow();
                c++;
            }
        }
        if(c==0) System.out.println("No shows for the screen you are looking for");
    }

    public void printshows(String time){
        int c=0;
        for(int i=0;i<shows.size();i++){
            if(shows.get(i).time.equals(time)){
                shows.get(i).displayshow();
                c++;
            }
        }
        if(c==0) System.out.println("No shows for the time you are looking for");
    }


    public void change(String name, String time, int screen){
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
        for(int j=0;j<shows.get(i).uName.size();j++){
            shows.get(i).mTime.set(j, shows.get(i).time);   // Use set to update the element
            shows.get(i).mScreen.set(j, shows.get(i).Screen);
        }
        System.out.println();
        System.out.println("Users have been notified about the changes !");
        System.out.println();
    }

    public void movieList(){
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

    public int Booking(String MovieName, String Time){
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

                        try {
                            PrintWriter out = new PrintWriter(new FileWriter("users.csv", true));
                            user us=new user(shows.get(i).title, shows.get(i).time,userName,userNumber,seats,shows.get(i).Screen,seats*300);
                            out.printf("%s,%s,%s,%s,%d,%d,%d\n",us.getmName(),us.getmTime(),us.getuName(),us.getuNum(),us.getmTotalSeats(),us.getmScreen(),us.getpayment());       
                            out.close();
                        }  catch (IOException e) {
                            e.printStackTrace();
                        }

                        return 2;
                    }
                }
            }
        }
        System.out.println("Entered Movie name or Time is Wrong.");
        return 1;
    }

    public void generatingBillForAdmin() {
        int count=0;
        for (int i = 0; i < shows.size(); i++) {
            for (int j = 0; j < shows.get(i).uName.size(); j++) {
                count++;
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
        if(count==0){
            System.out.println("No Bookings done yet !");
        }
    }
}