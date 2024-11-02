package cineplexShows;

import java.util.ArrayList;
import java.util.Scanner;

public class show {
    public String title;
    public int duration;
    public int availableseats;
    public String time;
    public int Screen;
    public int seatmatrix[][] = new int[7][7];

    public ArrayList<String> mName = new ArrayList<String>();
    public ArrayList<String> mTime = new ArrayList<String>();
    public ArrayList<String> uName = new ArrayList<String>();
    public ArrayList<String> uNum = new ArrayList<String>();
    public ArrayList<Integer> mTotalSeats = new ArrayList<Integer>();
    public ArrayList<Integer> mScreen = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> mRows = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> mCols = new ArrayList<ArrayList<Integer>>();
    public ArrayList<Integer> payment = new ArrayList<Integer>();

    public show(String title,int duration,int availableseats,String time,int occupiedseats,int Screen,Scanner sc){
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

    public void printseatmatrix(){
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

    public void BookSeats(int seats, String n){
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

    public void generatingBillForUser(String hisName){
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

    public void displayshow(){
        System.out.println("Movie: "+title);
        System.out.println("Time: "+time);
        System.out.println("Duration: "+duration+" minutes");
        System.out.println("Screen : "+Screen);
        System.out.println("Available seats: "+availableseats);
        System.out.println("Seat matrix: \n");
        printseatmatrix();
    }
}
