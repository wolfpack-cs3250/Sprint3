//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.banner.bannerApplication.entities;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Section{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sectionNumber;

    private String startDate, endDate, startTime, endTime;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Rooms room;

    @ManyToOne
    private Professor professor;

    @OneToMany(mappedBy = "section")
    private Set<User> users = new HashSet<>();

    public Section() {}
    public Section(Course course, Long sectionNumber){
        this.sectionNumber = sectionNumber;
        this.course = course;
    }
    public Long getId () {
        return id;
    }
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    public Professor getProfessor(){
        return professor;
    }
    public Long getSectionNumber (Long sectionNumber) {
        return sectionNumber;
    }
    public void setSectionNumber (Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }
    public Rooms getRoom(){
        return room;
    }
    public void setRoom(Rooms room){ this.room = room; }
    public void setStartDate (String startDate) { this.startDate = startDate;}
    public String getStartDate() { return startDate; }
    public void setEndDate (String EndDate) { this.endDate = endDate;}
    public String getEndDate() { return endDate; }
    public String getStartTime() { return startTime; }
    public void setStartTime (String startTime) { this.startTime = startTime;}
    public String getEndTime() { return endTime; }
    public void setEndTIme (String endDate) { this.endTime = endTime;}
}
