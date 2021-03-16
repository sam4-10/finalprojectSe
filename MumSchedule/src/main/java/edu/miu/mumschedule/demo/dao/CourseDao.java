package edu.miu.mumschedule.demo.dao;



import edu.miu.mumschedule.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {
//    public List<Course> findCourseByCoursename();
}
