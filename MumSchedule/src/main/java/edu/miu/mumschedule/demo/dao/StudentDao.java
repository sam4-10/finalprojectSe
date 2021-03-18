package edu.miu.mumschedule.demo.dao;

import java.util.List;

import edu.miu.mumschedule.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;





@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	public List<Student> findAllByOrderByLastNameAsc();

	@Query("select s from Student s where s.user.credential.userName=:userName")
	public Student findStudentByName(String userName);

@Query("select s from Student s where s.email=:email")
	Student findStudentByEmail(String email);
}
