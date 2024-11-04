package cineplexUser;

public class user {
    private String mName;
    private String mTime;
    private String uName;
    private String uNum;
    private int mTotalSeats;
    private int mScreen;
    private int payment;

    // Default constructor
    public user() {
        this.mName = "";
        this.mTime = "";
        this.uName = "";
        this.uNum = ""; 
        this.mTotalSeats = 0;
        this.mScreen = 0;
        this.payment = 0;
    }

    // Parameterized constructor
    public user(String mName, String mTime, String uName, String uNum, int mTotalSeats, int mScreen, int payment) {
        this.mName = mName;
        this.mTime = mTime;
        this.uName = uName;
        this.uNum = uNum;
        this.mTotalSeats = mTotalSeats;
        this.mScreen = mScreen;
        this.payment = payment;
    }

    // Getter and Setter methods for mName
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    // Getter and Setter methods for mTime
    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    // Getter and Setter methods for uName
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    // Getter and Setter methods for uNum
    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum;
    }

    // Getter and Setter methods for mTotalSeats
    public int getmTotalSeats() {
        return mTotalSeats;
    }

    public void setmTotalSeats(int mTotalSeats) {
        this.mTotalSeats = mTotalSeats;
    }

    // Getter and Setter methods for mScreen
    public int getmScreen() {
        return mScreen;
    }

    public void setmScreen(int mScreen) {
        this.mScreen = mScreen;
    }

    // Getter and Setter methods for payment
    public int getpayment() {
        return payment;
    }

    public void setpayment(int payment) {
        this.payment = payment;
    }
}
