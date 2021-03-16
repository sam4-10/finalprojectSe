package edu.miu.mumschedule.demo.dao;

import edu.miu.mumschedule.demo.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SectionDao extends JpaRepository<Section, Integer> {

}
