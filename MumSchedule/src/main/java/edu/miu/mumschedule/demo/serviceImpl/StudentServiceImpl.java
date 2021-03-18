package edu.miu.mumschedule.demo.serviceImpl;


import edu.miu.mumschedule.demo.dao.StudentDao;
import edu.miu.mumschedule.demo.domain.Student;
import edu.miu.mumschedule.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao;

	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	public Student findById(int theId) {
		Optional<Student> result = studentDao.findById(theId);

		Student theStudent = null;

		if (result.isPresent()) {
			theStudent = result.get();
		} else {
			// we didn't find the student
			throw new RuntimeException("Did not find student id - " + theId);
		}

		return theStudent;
	}

	@Override
	public void save(Student theStudent) {
		studentDao.save(theStudent);

	}

	@Override
	public void deleteById(int theId) {
		studentDao.deleteById(theId);


	}

	@Override
	public Student findByName(String userName) {
		return studentDao.findStudentByName(userName);
	}


	@Override
	public Student findStudentByEmail(String email) {
		return studentDao.findStudentByEmail(email);
	}

}
