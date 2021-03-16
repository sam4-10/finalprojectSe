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
public class Faculty {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long facultyID;

	private String facultyName;
	private String email;

	@OneToOne
	@JoinColumn(name = "userId", nullable = false)
	User user;


	@ManyToMany(mappedBy = "facultyList")
	private Set<Course> courseList = new HashSet<Course>();


	public void addCourse(Course course){
		courseList.add(course);
		//course.setFaculty(this);
		course.addFaculty(this);

	}

	@Override
	public String toString() {
		return "Faculty{" +
				"facultyID=" + facultyID +
				", facultyName='" + facultyName + '\'' +
				", email='" + email + '\'' +
			//	", courseList=" + courseList +
				'}';
	}
}
