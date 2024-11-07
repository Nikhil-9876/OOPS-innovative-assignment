package cineplexShows;

import java.util.ArrayList;
import java.util.Scanner;

public class ShowDetails {
    protected String title;
    protected int duration;
    protected String time;
    protected int Screen;

    public ShowDetails(String title, int duration, String time, int Screen) {
        this.title = title;
        this.duration = duration;
        this.time = time;
        this.Screen = Screen;
    }

    public void displayShowDetails() {
        System.out.println("Movie: " + title);
        System.out.println("Time: " + time);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Screen : " + Screen);
    }
}

class Show extends ShowDetails {
    public int availableseats;
    public int[][] seatmatrix = new int[7][7];

    public ArrayList<String> uName = new ArrayList<>();
    public ArrayList<String> uNum = new ArrayList<>();
    public ArrayList<Integer> mTotalSeats = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> mRows = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> mCols = new ArrayList<>();
    public ArrayList<Integer> payment = new ArrayList<>();

    public Show(String title, int duration, int availableseats, String time, int occupiedseats, int Screen, Scanner sc) {
        super(title, duration, time, Screen);
        this.availableseats = availableseats;
        initializeSeatMatrix(occupiedseats, sc);
    }

    private void initializeSeatMatrix(int occupiedseats, Scanner sc) {
        if (occupiedseats != 0) System.out.println("Enter coordinates of not available seats:");
        for (int i = 0; i < occupiedseats; i++) {
            System.out.println("Enter row no. and column no. [7*7]:");
            int r = sc.nextInt();
            int c = sc.nextInt();
            this.seatmatrix[r - 1][c - 1] = 1;
        }
    }

    public void printSeatMatrix() {
        System.out.println("1=Reserved seat and 0=available seat");
        System.out.println(" ___________ \n"); // seat matrix screen
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(seatmatrix[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    public void bookSeats(int seats, String name) {
        Scanner sc = new Scanner(System.in);
        printSeatMatrix();
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        while (seats > 0) {
            System.out.println("Enter row no. and column no. [7*7]:");
            int row = sc.nextInt();
            int column = sc.nextInt();
            if (seatmatrix[row - 1][column - 1] == 1) {
                System.out.println("The seat is already Booked.");
                System.out.println("Book another seat !");
            } else {
                availableseats -= 1;
                seatmatrix[row - 1][column - 1] = 1;
                seats -= 1;
                rows.add(row);
                cols.add(column);
            }
        }
        mRows.add(rows);
        mCols.add(cols);
        uName.add(name);
        System.out.println("Booking Successful!");
    }

    public void generateBillForUser(String userName) {
        int i = 0;
        for (; i < uName.size(); i++) {
            if (uName.get(i).equals(userName)) {
                System.out.println("Name : " + uName.get(i));
                System.out.println("Number : " + uNum.get(i));
                System.out.println("Movie Name : " + title);
                System.out.println("Movie Time : " + time);
                System.out.println("Screen of the show : " + Screen);
                System.out.println("Total Seats Booked : " + mTotalSeats.get(i));
                System.out.println("Seats : ");
                for (int j = 0; j < mRows.get(i).size(); j++) {
                    System.out.println("row : " + mRows.get(i).get(j) + ", Column : " + mCols.get(i).get(j));
                }
                System.out.println("Payment: Rs" + payment.get(i));
                System.out.println("Pay on this UPI id: 98XXXXXX21@hdfcbank");
            }
        }
    }

    public void displayShow() {
        displayShowDetails();
        System.out.println("Available seats: " + availableseats);
        System.out.println("Seat matrix: \n");
        printSeatMatrix();
    }
}
