package newpackage;

public class Coach {
    private int age,coachID;
    private String name, Address, Gender, Mail, BirthDate, StartDate, EndDate, experience, PhoneNum, shiftname,CourseName;
    private double salary;
    private Course course;

    // Constructors
    public Coach() {
        this.course = new Course();
    }

    public Coach(Coach coach) {
        this.name = coach.getName();
        this.Address = coach.getAddress();
        this.Gender = coach.getGender();
        this.Mail = coach.getMail();
        this.BirthDate = coach.getBirthDate();
        this.StartDate = coach.getStartDate();
        this.EndDate = coach.getEndDate();
        this.experience = coach.getExperience();
        this.PhoneNum = coach.getPhoneNum();
        this.salary = coach.getSalary();
        this.age = coach.getAge();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return Address;
    }

    public String getGender() {
        return Gender;
    }

    public String getMail() {
        return Mail;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public String getExperience() {
        return experience;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public double getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public Course getCourse() {
        return course;
    }

    public String getCourseName() {
        return course.getCourseName();
    }

   

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public void setEndDate(String EndDate) {
        this.EndDate = EndDate;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setCourseName(String courseName) {
        this.course.setCourseName(courseName);
    }

    
    
    public int getCoachID() {
        return coachID;
    }

    void setCoachName(String string) {
        this.CourseName=course.getCourseName();
    }

    String getcoachName() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
 