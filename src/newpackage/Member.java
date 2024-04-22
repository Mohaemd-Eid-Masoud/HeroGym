package newpackage;


import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zdros
 */
public class Member {
    private String MemberName="",courseName;
    private LocalDate BirthDate;
    private LocalDate endDate;
    private LocalDate startDate;
    private String Gender="";
    private Double height;
    private Double weight;
    private int Age;
    private String PhoneNum="";
    private Coach coach;
    private String coachName;
    private int coachID,memberID;;
    private Course course;
    private  String level;
    
    public Member() {
    }

    public Member( LocalDate BirthDate, String Gender, Double height, Double weight, int Age, String PhoneNum,String MemberName) {
    this.height = height;
    this.weight = weight;
    this.Age = Age;
    this.BirthDate = BirthDate;
    this.Gender = Gender;
    this.MemberName = MemberName;
    this.PhoneNum = PhoneNum;
}

    public String getMemberName() {
        return MemberName;
    }

    public void setMemberName(String MemberName) {
        this.MemberName = MemberName;
    }

    public LocalDate getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(LocalDate BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }
    
    public void setCoach(Coach coach) {
    this.coach = coach;
    this.setCoachID(coach.getCoachID()); // Add this line to set the coachID
    }
    public void setCoachName(String coachName) {
    this.coachName = coachName;
    }
    public Coach getCoach(){
        return coach;
    }
    public String getCoachName(){
        return coachName;
    }
    public int getCoachID() {
        return coachID;
    }

    public void setCoachID(int coachID) {
        this.coachID = coachID;
    }


    int getMemberID() {
        return memberID;
    }

    void setCourse(Course course) {
        this.course=course;
    }
    public Course getCourse(){
        
        return course;
        
    }

    void setCourseName(String courseName) {
    if (getCourse() != null) {
            getCourse().setCourseName(courseName);
    } else {
        // If the course object is null, create a new instance and set the course name
            setCourse(new Course());
            getCourse().setCourseName(courseName);
    }
}

    void setMemberID(int memberId) {
        this.memberID=memberId;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @return the endDate
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }
}