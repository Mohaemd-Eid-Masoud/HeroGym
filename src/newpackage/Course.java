package newpackage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zdros
 */
public class Course {
    private String CourseName="";
    private String Plan="";
   private Coach coach;
   private Member member;
    private Coach Coach;

    public Course() {
    }
    public Course(String CourseName,String CoachID,String Plan,String length) {
        this.CourseName=CourseName;
        this.Plan=Plan;
        coach=new Coach();
        member=new Member();
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String CourseName) {
        this.CourseName = CourseName;
    }

    public String getPlan() {
        return Plan;
    }

    public void setPlan(String Plan) {
        this.Plan = Plan;
    }

public  void setMemberName(Member memberName) {
        this.member=memberName;
    }
    public String getMemberName(){
        
        return member.getMemberName();
                
    
    
    }
    
    public  void setCoachName(Coach coachName) {
        this.Coach=coachName;
    }
    public String getcoachName(){
        
        return coach.getcoachName();
                
    
    
    }
    
}    
    
    
