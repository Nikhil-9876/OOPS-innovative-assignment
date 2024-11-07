package cineplexUser;

public class user {
    private String mName;
    private String mTime;
    private String uName;
    private String uNum;
    private int mTotalSeats;
    private int mScreen;
    private int payment;

    public user() {
        this.mName = "";
        this.mTime = "";
        this.uName = "";
        this.uNum = ""; 
        this.mTotalSeats = 0;
        this.mScreen = 0;
        this.payment = 0;
    }

    public user(String mName, String mTime, String uName, String uNum, int mTotalSeats, int mScreen, int payment) {
        this.mName = mName;
        this.mTime = mTime;
        this.uName = uName;
        this.uNum = uNum;
        this.mTotalSeats = mTotalSeats;
        this.mScreen = mScreen;
        this.payment = payment;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmTime() {
        return mTime;
    }

    public void setmTime(String mTime) {
        this.mTime = mTime;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuNum() {
        return uNum;
    }

    public void setuNum(String uNum) {
        this.uNum = uNum;
    }

    public int getmTotalSeats() {
        return mTotalSeats;
    }

    public void setmTotalSeats(int mTotalSeats) {
        this.mTotalSeats = mTotalSeats;
    }

    public int getmScreen() {
        return mScreen;
    }

    public void setmScreen(int mScreen) {
        this.mScreen = mScreen;
    }

    public int getpayment() {
        return payment;
    }

    public void setpayment(int payment) {
        this.payment = payment;
    }
}
