package edu.miu.mumschedule.demo.domain;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String Coursename;
    private String courseCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;


    @ManyToMany
    @JoinTable(name = "Course_Faculty",
            joinColumns = { @JoinColumn(name = "Course_id") },
            inverseJoinColumns = { @JoinColumn(name = "Faculty_id") }
    )

    private List<Faculty> facultyList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Course_Student",
            joinColumns = { @JoinColumn(name = "Course_id") },
            inverseJoinColumns = { @JoinColumn(name = "Student_id") }
    )

    private List<Student> studentList = new ArrayList<>();



    public void addFaculty(Faculty faculty){
        facultyList.add(faculty);
        faculty.addCourse(this);
    }
//    public void addSection(Section section){
//        sectionList.add(section);
//        section.addCourse(this);
//    }

    public void addStudent(Student student) {
        studentList.add(student);
        student.addCourse(this);
    }



}
