

public class user {
    String mName;
    String mTime;
    String uName;
    String uNum;
    int mTotalSeats;
    int mScreen;
    int payment;

    public user(){
        this.mName="";
        this.mTime="";
        this.uName="";
        this.uNum=""; 
        this.mTotalSeats=0;
        this.mScreen=0;
        this.payment=0;
    }
    public user(String mName, String mTime, String uName,String uNum,int mTotalSeats,int mScreen,int payment){
        this.mName=mName;
        this.mTime=mTime;
        this.uName=uName;
        this.uNum=uNum;
        this.mTotalSeats=mTotalSeats;
        this.mScreen=mScreen;
        this.payment=payment;
    }
}
