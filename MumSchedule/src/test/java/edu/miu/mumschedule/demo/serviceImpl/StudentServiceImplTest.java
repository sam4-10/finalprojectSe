package edu.miu.mumschedule.demo.serviceImpl;

import edu.miu.mumschedule.demo.dao.StudentDao;
import edu.miu.mumschedule.demo.domain.Student;
import edu.miu.mumschedule.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;



    @ExtendWith(SpringExtension.class)
    @SpringBootTest
    class StudentServiceImplTest {

        @MockBean
        StudentDao studentDao;
        @Autowired
        StudentService studentService;

        @Test
        void findAll() {
        }

        @Test
        public void findByIdTest() {

            // given
            Student student = new Student(3, "hiwi", "Ne", "fikir@gmail.com");
            given(studentDao.findById(3)).willReturn(Optional.of(student));

            String testemail = "fikir@gmail.com";

//        when(studentService.findById(3)).thenReturn((student));
            // when
            Student actual = studentService.findById(3);

            // then
            assertEquals(student, actual);


        }

        @Test
        public void saveTest() {
            Student theStudent = new Student(2, "Hiwot", "Nega", "hiwi@gmail.com");
            //when(studentServiceImpl.save(any(Student.class)));
            assertEquals(theStudent, studentService.addStudent(theStudent));
            //verify(mockFoo, atLeast(0)).bool(anyString(), anyInt(), any(Object.class)); verify(mockFoo, atLeast(0)).bool(eq("false"), anyInt(), any(Object.class));
        }

        @Test
        public void deleteTest() {

            // given
            Student student = new Student(2, "hiwot", "Nega", "h@gmail.com");
            given(studentDao.save(student)).willReturn(student);

            // when
            studentDao.deleteById(2);
            Optional<Student> s = studentDao.findById(2);

            //verify(studentDao.findById(2).delet(2));;
            assertNull(s.orElse(null));
            assertEquals(Optional.empty(), s);
            //verify(studentDao,times(1)).delete(student);;
        }
    }

