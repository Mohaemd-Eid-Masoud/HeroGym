package newpackage;

public class Receptionist {
    private String name = "",ShiftName, Gender = "", Address = "", UserPassword = "", PhoneNum, Email;
    private int Age;
    private double Salary;

    public Receptionist() {
      
    }

    public Receptionist(Receptionist receptionist) {
        this.PhoneNum = receptionist.getPhoneNum();
        this.Age = receptionist.getAge();
        this.name = receptionist.getName();
        this.UserPassword = receptionist.getUserPassword();
        this.Gender = receptionist.getGender();
        this.Address = receptionist.getAddress();
        this.Salary = receptionist.getSalary();
        this.Email = receptionist.getEmail();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }

    public String getPhoneNum() {
        return PhoneNum;
    }

    public void setPhoneNum(String PhoneNum) {
        this.PhoneNum = PhoneNum;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }



    public double getSalary() {
        return Salary;
    }

    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

}
