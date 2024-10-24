import java.util.ArrayList;
import java.util.List;

// Base class for a general Show
class Show {
    private String title;
    private int duration; // in minutes
    protected int availableSeats;

    public Show(String title, int duration, int availableSeats) {
        this.title = title;
        this.duration = duration;
        this.availableSeats = availableSeats;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeats(int numberOfSeats) {
        if (availableSeats >= numberOfSeats) {
            availableSeats -= numberOfSeats;
            return true;
        } else {
            return false;
        }
    }

    public void showDetails() {
        System.out.println("Show: " + title);
        System.out.println("Duration: " + duration + " minutes");
        System.out.println("Available Seats: " + availableSeats);
    }
}

// Movie class inheriting from Show
class Movie extends Show {
    public Movie(String title, int duration, int availableSeats) {
        super(title, duration, availableSeats);
    }

    @Override
    public void showDetails() {
        System.out.println("Movie: " + getTitle());
        System.out.println("Duration: " + getDuration() + " minutes");
        System.out.println("Available Seats: " + getAvailableSeats());
    }
}

// Class representing a cinema hall
class Cinema {
    private String name;
    private List<Show> shows;

    public Cinema(String name) {
        this.name = name;
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }

    public void listShows() {
        System.out.println("Shows available at " + name + ":");
        for (int i = 0; i < shows.size(); i++) {
            System.out.println((i + 1) + ". " + shows.get(i).getTitle());
        }
    }

    public Show getShow(int index) {
        if (index >= 0 && index < shows.size()) {
            return shows.get(index);
        } else {
            return null;
        }
    }
}

// Class for handling bookings
class Booking {
    private Show show;
    private int numberOfSeats;

    public Booking(Show show, int numberOfSeats) {
        this.show = show;
        this.numberOfSeats = numberOfSeats;
    }

    public boolean makeBooking() {
        return show.bookSeats(numberOfSeats);
    }

    public void showBookingDetails() {
        System.out.println("Booking for: " + show.getTitle());
        System.out.println("Seats booked: " + numberOfSeats);
    }
}

// Main class
public class CinemaBookingSystem {
    public static void main(String[] args) {
        // Create some movies (inheriting from Show)
        Movie movie1 = new Movie("Inception", 148, 100);
        Movie movie2 = new Movie("The Matrix", 136, 50);
        Movie movie3 = new Movie("Interstellar", 169, 75);

        // Create a cinema and add shows (movies in this case)
        Cinema cinema = new Cinema("Cineplex");
        cinema.addShow(movie1);
        cinema.addShow(movie2);
        cinema.addShow(movie3);

        // Display available shows (movies)
        cinema.listShows();

        // Book a show
        Show selectedShow = cinema.getShow(0); // User selects "Inception"
        if (selectedShow != null) {
            selectedShow.showDetails();

            // Create a booking
            Booking booking = new Booking(selectedShow, 3); // Book 3 seats
            if (booking.makeBooking()) {
                System.out.println("Booking successful!");
                booking.showBookingDetails();
            } else {
                System.out.println("Booking failed! Not enough seats available.");
            }
        }
    }
}