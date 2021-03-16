package edu.miu.mumschedule.demo.dao;

import java.util.List;

import edu.miu.mumschedule.demo.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	public List<Student> findAllByOrderByLastNameAsc();
}
