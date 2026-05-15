package newpackage;

import java.sql.Date;

public class Membership {
    private int membershipID;
    private int memberID;
    private int PAidamount;
    private Date StartDate;
    private Date EndDate;

    public Membership() {       
    }

    public Membership(int PAidamount, Date StartDate, Date EndDate) {
        this.PAidamount = PAidamount;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
    }

    public int getMembershipID() {
        return membershipID;
    }

    public void setMembershipID(int membershipID) {
        this.membershipID = membershipID;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public int getPAidamount() {
        return PAidamount;
    }

    public void setPAidamount(int PAidamount) {
        this.PAidamount = PAidamount;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }
}
