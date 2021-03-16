package edu.miu.mumschedule.demo.serviceImpl;


import edu.miu.mumschedule.demo.dao.CourseDao;
import edu.miu.mumschedule.demo.domain.Course;
import edu.miu.mumschedule.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;


    @Override
    public void save(Course course) {
        courseDao.save(course);
        return;
    }

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
        //return courseDao.findCourseByCoursename();
    }

    @Override
    public void deleteById(long id) {
        courseDao.deleteById(id);
    }

    @Override
    public Course findById(long id) {
        Optional<Course> result = courseDao.findById(id);

        Course theCourse = null;
        if(result.isPresent()){
            theCourse = result.get();
        }else {
            throw new RuntimeException("Did not find Course id "+ id);
        }

        return theCourse;
    }
}
