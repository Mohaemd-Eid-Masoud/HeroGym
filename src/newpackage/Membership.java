package newpackage;


import java.sql.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author WIN(10)X64
 */
public class Membership {
    private int PAidamount;
    private Date StartDate;
    private Date EndDate;
    public Membership(){       
    }
    public Membership(int PAidamount,Date StartDate,Date EndDate){
        this.PAidamount=PAidamount;
        this.StartDate=StartDate;
        this.EndDate=EndDate;
    }

    Membership(int paidAmount, java.util.Date startDate, java.util.Date endDate) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    /**
     * @return the PAidamount
     */
    public int getPAidamount() {
        return PAidamount;
    }

    /**
     * @param PAidamount the PAidamount to set
     */
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
