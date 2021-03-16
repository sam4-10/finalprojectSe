package edu.miu.mumschedule.demo.service;

import edu.miu.mumschedule.demo.domain.Section;

import java.util.List;

public interface SectionService {
public List<Section> findAll();
	
	public Section findById(int theId);
	
	public void save(Section section);
	
	public void deleteById(int theId);
}
