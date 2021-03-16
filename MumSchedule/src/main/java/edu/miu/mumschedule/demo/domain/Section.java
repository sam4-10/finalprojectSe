package edu.miu.mumschedule.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class Section {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sectionID;
	private String sectionName;
	@OneToMany()
	@JoinColumn(name = "section_id")
	private Set<Course> courses = new HashSet<>();




}
