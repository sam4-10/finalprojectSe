package edu.miu.mumschedule.demo.serviceImpl;


import edu.miu.mumschedule.demo.dao.FacultyRepository;
import edu.miu.mumschedule.demo.domain.Faculty;
import edu.miu.mumschedule.demo.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceimpl implements FacultyService {

    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public void deleteById(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public void save(Faculty faculty) {
        facultyRepository.save(faculty);

    }

    @Override
    public List<Faculty> getByEmail(String email) {
        return facultyRepository.findAllByEmail(email);
    }



    @Override
    public List<Faculty> findAll() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty findById(Long id) {
            Optional<Faculty> faculty = facultyRepository.findById(id);
        return faculty.get();
    }

    @Override
    public Faculty findByName(String userName) {
        return facultyRepository.findFacultyByName(userName);
    }


}
