package edu.miu.mumschedule.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
    private int studentID;
	private String firstName;
	private String lastName;
	private String email;

	@OneToOne
	@JoinColumn(name = "userId", nullable = false)
	User user;

	@ManyToMany(mappedBy = "studentList")
	private Set<Course> courseList = new HashSet<Course>();

	public void addCourse(Course course){
		courseList.add(course);
		//course.setFaculty(this);
		course.addStudent(this);

	}

	@Override
	public String toString(){
		return "id "+ id + " studentID " + studentID + " firstName "+ firstName +
				" lastName " + lastName + " email "+ email;
	}

}
