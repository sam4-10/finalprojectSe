package edu.miu.mumschedule.demo.service;




import edu.miu.mumschedule.demo.domain.Faculty;

import java.util.List;

public interface FacultyService {
   void deleteById(Long id);


    void save(Faculty faculty);
   List<Faculty> getByEmail(String email);

    List<Faculty> findAll();

    Faculty findById(Long id);

    Faculty findByName(String userName);
}
